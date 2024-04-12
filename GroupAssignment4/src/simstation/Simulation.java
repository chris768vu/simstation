package simstation;
import mvc.*;
import java.util.List;
import java.util.ArrayList;

public class Simulation extends Model {
	int clock = 0;
	List<Agent> agents = new ArrayList<Agent>();
	
	public void start() {
		for (Agent i: agents) {
			i.run();
		}
	}
	
	public void suspend() {
		for (Agent i: agents) {
			i.run();
		}
	}
	
	public void resume() {
		for (Agent i: agents) {
			i.resume();
		}
	}
	
	public void stop() {
		for (Agent i: agents) {
			i.stop();
		}
	}
	
	/*
	 * "An efficient implementation of getNeighbor picks a random location in the agents list. 
	 * Starting at this location it visits each agent in order (wrapping around to the start if necessary) until 
	 * it either finds a suitable neighbor or until it loops back to the starting point and returns null." - Dr. Pearce
	 * */
	public Agent getNeighbor(Agent a, double radius) {
		// randomly selecting an index to start in agents
		int rand = -1;
		rand = Utilities.rng.nextInt(agents.size());
		
		for (int i = rand; i < agents.size(); i++) {
			double distanceAway = Math.pow(
					Math.pow((agents.get(i).xc - a.xc), 2) + Math.pow((agents.get(i).yc - a.yc), 2), 
					0.5);
			if (distanceAway <= radius && distanceAway != 0) return agents.get(i);
		}
		
		// wrapping around until we reach the random index again
		for (int i = rand; i < agents.size(); i++) {
			double distanceAway = Math.pow(
					Math.pow((agents.get(i).xc - a.xc), 2) + Math.pow((agents.get(i).yc - a.yc), 2), 
					0.5);
			if (distanceAway <= radius && distanceAway != 0) return agents.get(i);
		}
		
		return null;
	}
	
	public void populate() {}
}
