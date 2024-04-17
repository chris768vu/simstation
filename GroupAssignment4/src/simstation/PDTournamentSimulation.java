package pdtournament;

import mvc.*;
import simstation.*;
import java.util.Iterator;

public class PDTournamentSimulation extends Simulation {
	final static int TOTAL_AGENTS = 200;
	
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
		
		double avgCooperate = cooperateFitness / TOTAL_AGENTS;
		double avgCheat = cheatFitness / TOTAL_AGENTS;
		double avgTit4Tat = tit4tatFitness / TOTAL_AGENTS;
		double avgRandCooperate = randCooperateFitness / TOTAL_AGENTS;
		
		return new String[]{"#agents = " + agents.size(), "\nAverage Fitness of Strategies", "Cooperate: " + avgCooperate, "Cheat: " + avgCheat,
				"Randomly Cooperate: " + avgRandCooperate, "Tit-4-Tat: " + avgTit4Tat};
	}
	
	public void populate() {
		Strategy s = null;
		for (int i = 0; i < 4; i++) {
			if (i == 0)
				s = new Cooperate();
			if (i == 1)
				s = new Cheat();
			if (i == 2)
				s = new Tit4Tat();
			if (i == 3)
				s = new RandomlyCooperate();
			
			for (int j = 0; j < TOTAL_AGENTS / 4; j++) {
				addAgent(new Prisoner(s));
			}
		}
    }
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PDTournamentFactory());
		panel.display();
	}

}
