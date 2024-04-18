package pdtournament;

import mvc.Utilities;
import simstation.*;

public class Prisoner extends Agent {
	private final int RADIUS = 20;
	
	Strategy strategy;
	
	private int fitness = 0;
	protected boolean partnerCheated;
	protected boolean willCheat;
	
	public Prisoner() {
		super();
		heading = heading.random();
	}
	
	// interaction
	public boolean cooperate() {
		Agent partner = world.getNeighbor(this, RADIUS);
		
		if (partner != null) {
			Prisoner prisonPartner = (Prisoner) partner;
			
			strategy.cooperate();
			prisonPartner.strategy.cooperate();
			
			if (!willCheat && !prisonPartner.willCheat) {
				updateFitness(3);
				prisonPartner.updateFitness(3);
				partnerCheated = false;
				return true;
			} else if (willCheat && !prisonPartner.willCheat) {
				updateFitness(5);
				partnerCheated = false;
				return false;
			} else if (!willCheat && prisonPartner.willCheat) {
				prisonPartner.updateFitness(5);
				partnerCheated = true;
				return true;
			} else if (willCheat && prisonPartner.willCheat) {
				updateFitness(1);
				prisonPartner.updateFitness(1);
				partnerCheated = true;
				return false;
			} 
		}
		
		return false;
	}
	
	public void update() {
		cooperate();
		heading = Heading.random();
		int steps = Utilities.rng.nextInt(10) + 1;
		move(steps);	
	}
	
	public void updateFitness(int amt) {
		fitness += amt;
	}
	
	public synchronized int getFitness() {
		return fitness;
	}

}
