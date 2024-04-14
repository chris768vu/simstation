package simstation;
import mvc.*;

import java.awt.*;
import javax.swing.*;

public class SimulationPanel extends AppPanel {

	public SimulationPanel(AppFactory factory) {
		super(factory);
		View simView = factory.makeView(model);
		add(simView);
		
		JButton Start = new JButton("Start");
        Start.addActionListener(this);
        controlPanel.add(Start);
        
        JButton Suspend = new JButton("Suspend");
        Suspend.addActionListener(this);
        controlPanel.add(Suspend);
        
        JButton Resume = new JButton("Resume");
        Resume.addActionListener(this);
        controlPanel.add(Resume);
        
        JButton Stop = new JButton("Stop");
        Stop.addActionListener(this);
        controlPanel.add(Stop);
        
        JButton Stats = new JButton("Stats");
        Stats.addActionListener(this);
        controlPanel.add(Stats);
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new SimulationFactory());
		panel.display();
	}
	
}
