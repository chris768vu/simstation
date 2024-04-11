package simstation;
import mvc.*;

public abstract class SimulationFactory implements AppFactory{

	@Override
	public abstract Model makeModel();

	@Override
	public View makeView(Model m) {
		return new SimulationView(m);
	}

	@Override
	public abstract String getTitle();

	@Override
	public String[] getHelp() {
		String[] help = {"Start starts the simulation\n", "Suspend pauses the simulation\n", "Resume undos suspend\n", 
				"Stop ends the simulation run\n", 
				"Stats displays the simulation time (in seconds) and the number of agents\n"};
		return help;
	}

	@Override
	public String about() {
		return "Simstation";
	}

	@Override
	public String[] getEditCommands() {
		String[] commands = {"Start", "Suspend", "Resume", "Stop", "Stats"};
		return commands;
	}

	@Override
	public Command makeEditCommand(Model m, String name, Object source) {
		if (name.equals("Start")) return new StartCommand(m);
		if (name.equals("Stats")) return new StatsCommand(m);
    	if (name.equals("Stop")) return new StopCommand(m);
    	if (name.equals("Suspend")) return new SuspendCommand(m);
    	if (name.equals("Resume")) return new ResumeCommand(m);
		return null;
	}

}
