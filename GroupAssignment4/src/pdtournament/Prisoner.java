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
			if (prisonPartner.strategy instanceof Cooperate && this.strategy instanceof Cooperate) {
				prisonPartner.fitness += 3;
				this.fitness += 3;
			}
			if (prisonPartner.strategy instanceof Cooperate && this.strategy instanceof Cheat) {
				prisonPartner.fitness += 3;
				this.fitness += 3;
			}
			if (prisonPartner.strategy instanceof Cooperate && this.strategy instanceof Cooperate) {
				prisonPartner.fitness += 3;
				this.fitness += 3;
			}
			if (prisonPartner.strategy instanceof Cooperate && this.strategy instanceof Cooperate) {
				prisonPartner.fitness += 3;
				this.fitness += 3;
			}
		}
		
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
