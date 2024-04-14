package simstation;
import mvc.*;

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
