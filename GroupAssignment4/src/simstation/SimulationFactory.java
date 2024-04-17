package simstation;
import mvc.*;

public class SimulationFactory implements AppFactory {

	@Override
	public Model makeModel() {
		return new Simulation();
	}

	@Override
	public View makeView(Model m) {
		return new SimulationView(m);
	}

	@Override
	public String getTitle() {
		return "Simstation";
	}

	@Override
	public String[] getHelp() {
		String[] help = {"Start starts the simulation\n", "Suspend pauses the simulation\n", 
				"Resume undos suspend\n", 
				"Stop ends the simulation run\n", 
				"Stats displays relevant statistics to the simulation\n"};
		return help;
	}

	@Override
	public String about() {
		return "Assignment 4: Simstation (Group 6)";
	}

	@Override
	public String[] getEditCommands() {
		String[] commands = {"Start", "Suspend", "Resume", "Stop", "Stats"};
		return commands;
	}

	@Override
	public Command makeEditCommand(Model m, String name, Object source) {
		if (name.equals("Start")) return new StartCommand(m);
    	if (name.equals("Stop")) return new StopCommand(m);
    	if (name.equals("Suspend")) return new SuspendCommand(m);
    	if (name.equals("Resume")) return new ResumeCommand(m);	
    	if (name.equals("Stats")) return new StatsCommand(m);
		return null;
	}

}
