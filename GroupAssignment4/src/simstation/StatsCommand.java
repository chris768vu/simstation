package simstation;
import mvc.*;

public class StatsCommand extends Command {

	public StatsCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws Exception {
		Simulation sim = (Simulation) model;
		// sim.stats();
		// Stats has been implemented in Simulation by the getStats() method (returns a String[])
	}

}
