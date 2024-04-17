package pdtournament;
import mvc.Utilities;
import simstation.*;

public class Prisoner extends Agent {
	private final int RADIUS = 20;
	
	Strategy strategy;
	
	private int fitness = 0;
	protected boolean partnerCheated = false;
	protected boolean willCheat = false;
	
	public Prisoner(Strategy strategy) {
		super();
		heading = heading.random();
		this.strategy = strategy;
	}
	
	public boolean cooperate() {
		Agent partner = world.getNeighbor(this, RADIUS);
		if (partner != null) {
			Prisoner prisonPartner = (Prisoner) partner;
			if (!willCheat && !prisonPartner.willCheat) {
				updateFitness(3);
				prisonPartner.updateFitness(3);
				if (strategy instanceof Tit4Tat) {
					
				}
				return false;
			} else if (willCheat && !prisonPartner.willCheat) {
				updateFitness(5);
				return false;
			} else if (!willCheat && prisonPartner.willCheat) {
				prisonPartner.updateFitness(5);
				return true;
			} else if (willCheat && prisonPartner.willCheat) {
				updateFitness(1);
				prisonPartner.updateFitness(1);
				return true;
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
	
	public int getFitness() {
		return fitness;
	}

}
