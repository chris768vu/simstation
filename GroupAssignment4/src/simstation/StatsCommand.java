package simstation;
import mvc.*;

public class StatsCommand extends Command {

	public StatsCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() throws Exception {
		// Simulation sim = (Simulation) model;
		Utilities.inform(model.as(Simulation.class).getStats());
		// sim.stats();
		// Stats has been implemented in Simulation by the getStats() method (returns a String[])
	}

}