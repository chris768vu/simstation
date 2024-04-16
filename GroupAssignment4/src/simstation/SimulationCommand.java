package simstation;

import mvc.Command;
import mvc.Model;

public class SimulationCommand {
	public class ResumeCommand extends Command {

		public ResumeCommand(Model model) {
			super(model);
		}

		@Override
		public void execute() throws Exception {
			Simulation sim = (Simulation) model;
			sim.resume();
		}

	}
	
	public class StartCommand extends Command {

		public StartCommand(Model model) {
			super(model);
		}

		@Override
		public void execute() throws Exception {
			Simulation sim = (Simulation) model;
			sim.start();
		}

	}
	
	public class StopCommand extends Command {

		public StopCommand(Model model) {
			super(model);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void execute() throws Exception {
			Simulation sim = (Simulation) model;
			sim.stop();
		}

	}
	
	public class SuspendCommand extends Command {

		public SuspendCommand(Model model) {
			super(model);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void execute() throws Exception {
			Simulation sim = (Simulation) model;
			sim.suspend();
		}

	}
}
