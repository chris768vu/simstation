package mvc;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Edits:
   Hiba 3/5/24: created file

   Hiba 3/5/24: : implemented AppPanel (MVC Pattern: finished)

   Christopher 3/13/24: Now implements Subscriber in addition to ActionListener. Neither
   	uses PropertyChangeListener nor JavaBean anymore (due to revised specifications). Added
   	update(), modified AppPanel constructor according to Pub-Sub, added to actionPerformed
   	and error handling

   Adarsh 3/14/24: implemented AppPanel class according to example given by professor

   Christopher 3/16/24: updated AppPanel constructor (controlPanel stuff)
*/

public class AppPanel extends JPanel implements Subscriber, ActionListener {
	protected Model model;
	protected View view;
	protected AppFactory factory;
	protected JPanel controlPanel;
	private JFrame frame;


	// Constructor
	public AppPanel(AppFactory factory) {
		this.factory = factory;
		model = factory.makeModel();
		view = factory.makeView(model);


		// initialize controlPanel
		controlPanel = new JPanel();
		GridLayout layout = new GridLayout();
		layout.setColumns(2);
		this.setLayout(layout);
		this.add(controlPanel);
		this.add(view);
		model.subscribe(this);


	}

	public void display() {
		SafeFrame frame = new SafeFrame();
		Container cp = frame.getContentPane();
		cp.add(this);

		frame.setJMenuBar(this.createMenuBar());
		frame.setTitle(factory.getTitle());
		frame.setSize(800, 800);
		frame.setVisible(true);
	}

	public void update() {}

	public Model getModel() { return model; }

	public void setModel(Model newModel) {
		this.model.unsubscribe(this);
		this.model = newModel;
		this.model.subscribe(this);
		view.setModel(this.model);
		update(); // ends up notifying subscribers, calling update methods
	}

	protected JMenuBar createMenuBar() {
		JMenuBar result = new JMenuBar();
		JMenu fileMenu = Utilities.makeMenu("File",  new String[] {"New", "Save", "Save as", "Open", "Quit"}, this);
		result.add(fileMenu);
		JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
		result.add(editMenu);
		JMenu helpMenu = Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
		result.add(helpMenu);
		return result;
	}

	// Method from ActionListener interface
	@Override
	public void actionPerformed(ActionEvent ae) {
		String cmmd = ae.getActionCommand();
		try {
			if (cmmd.equals("Save")) {
				Utilities.save(model,  false);
			}
			else if (cmmd.equals("SaveAs")) {
				Utilities.save(model,  true);
			}
			else if (cmmd.equals("Open")) {
				Model newModel = Utilities.open(model);
				if (newModel != null) setModel(newModel);
			}
			else if (cmmd.equals("New")) {
				Utilities.saveChanges(model);
				setModel(factory.makeModel());
				model.setUnsavedChanges(false);
			}
			else if (cmmd.equals("Quit")) {
				Utilities.saveChanges(model);
				System.exit(0);
			}
			else if (cmmd.equals("About")) {
				Utilities.inform(factory.about());
			}
			else if (cmmd.equals("Help")) {
				Utilities.inform(factory.getHelp());
			}
			else {
				factory.makeEditCommand(model, cmmd, null).execute();
			}
		} catch (Exception e) {
			handleException(e);
		}
	}

	protected void handleException(Exception e) {
		Utilities.error(e);
	}
}

