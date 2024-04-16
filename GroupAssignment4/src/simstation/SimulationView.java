package simstation;
import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationView extends View {
	private Simulation world;
	private JPanel gridPanel;
	
	public SimulationView(Model model) {
		super(model);
		setModel(model);
		
        setLayout(new BorderLayout());
        gridPanel = new JPanel(new GridLayout(200, 200));
        add(gridPanel);
        
		world = (Simulation) model;
		if (world != null) {
			model.subscribe(this);
			paintComponent();
		}
	}
	
	public void paintComponent() {
        gridPanel.removeAll();

		if (world != null) {
			for (Agent a : world.agents) {	
	            JLabel oval= new JLabel();
	            oval.setOpaque(true);
	            oval.setBackground(Color.WHITE); 
	            oval.setPreferredSize(new Dimension(1, 1)); 
	            gridPanel.add(oval);
			}
		}
		
	}
	
	@Override
	public void update() {
		paintComponent();
	}
}
