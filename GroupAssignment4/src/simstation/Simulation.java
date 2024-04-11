package simstation;
import mvc.*;
import java.util.List;
import java.util.ArrayList;

public class Simulation extends Model {
	int clock = 0;
	List<Agent> agents = new ArrayList<Agent>();
	
	public void start() {}
	
	public void suspend() {}
	
	public void resume() {}
	
	public void stop() {}
	
	public Agent getNeighbor(Agent a, double radius) {
		return null;
	}
	
	public void populate() {}
}
