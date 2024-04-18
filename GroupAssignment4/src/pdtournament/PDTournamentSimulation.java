package pdtournament;

import mvc.*;
import simstation.*;
import java.util.Iterator;

public class PDTournamentSimulation extends Simulation {
	final static int TOTAL_AGENTS = 20;
	final static int QUARTER_AGENTS = TOTAL_AGENTS / 4;
	
	@Override
	public String[] getStats() {
		int cooperateFitness = 0;
		int cheatFitness = 0;
		int tit4tatFitness = 0;
		int randCooperateFitness = 0;
		
		Iterator<Agent> iterator = agentIterator();
		while (iterator.hasNext()) {
			Prisoner current = (Prisoner) iterator.next();
			if (current.strategy instanceof Cooperate)
				cooperateFitness += current.getFitness();
			else if (current.strategy instanceof Cheat)
				cheatFitness += current.getFitness();
			else if (current.strategy instanceof Tit4Tat)
				tit4tatFitness += current.getFitness();
			else if (current.strategy instanceof RandomlyCooperate)
				randCooperateFitness += current.getFitness();
		}
		// averages are divided by the number of agents who use their respective strategies
		double avgCooperate = cooperateFitness / QUARTER_AGENTS;
		double avgCheat = cheatFitness / QUARTER_AGENTS;
		double avgTit4Tat = tit4tatFitness / QUARTER_AGENTS;
		double avgRandCooperate = randCooperateFitness / QUARTER_AGENTS;
		
		return new String[]{
				"#agents = " + agents.size(), 
				"clock = " + getTime(), 
				"\nAverage Fitness of Strategies", 
				"Cooperate: " + avgCooperate, 
				"Cheat: " + avgCheat, 
				"Randomly Cooperate: " + avgRandCooperate, 
				"Tit-4-Tat: " + avgTit4Tat
				};
	}
	
	public void populate() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < QUARTER_AGENTS; j++) {
				Prisoner p = new Prisoner();
				
				if (i == 0) {
					p.strategy = new Cooperate();
				} else if (i == 1) {
					p.strategy = new Cheat();
				} else if (i == 2) {
					p.strategy = new RandomlyCooperate();
				} else {
					p.strategy = new Tit4Tat();
				}
				
				p.strategy.myPrisoner = p;
				addAgent(p);
			}
		}
    }
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PDTournamentFactory());
		panel.display();
	}

}
