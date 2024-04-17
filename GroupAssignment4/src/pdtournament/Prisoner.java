package pdtournament;
import mvc.Utilities;
import simstation.*;

public class Prisoner extends Agent {
	Strategy strategy;
	int fitness = 0;
	
	// cheated stores whether this Prisoner's last partner cheated or not
	boolean cheated;
	
	public Prisoner() {
		super();
		heading = heading.random();
		this.strategy = strategy;
	}
	
	public boolean cooperate() {
		return false;
	}
	
	public void update() {
		
		heading = Heading.random();
		int steps = Utilities.rng.nextInt(10) + 1;
		move(steps);	
	}
	
	public void updateFitness(int amt) {
		fitness += amt;
	}

}
