package pdtournament;

import mvc.*;
import simstation.*;
import java.util.Iterator;

public class PDTournamentSimulation extends Simulation {
	final static int TOTAL_AGENTS = 200;
	@Override
	public String[] getStats() {
		int numCooperate = 0;
		int numCheat= 0;
		int numTit4Tat = 0;
		int numRandomlyCooperate = 0;
		Iterator<Agent> iterator = agentIterator();
		return new String[]{"#agents = " + agents.size(), ""};
	}
	
	public void populate() {
		Strategy s;
		
        for (int i = 0; i < TOTAL_AGENTS / 4; i++) {
        	s = new Cooperate();
			addAgent(new Prisoner(s));
        }
        for (int i = 0; i < TOTAL_AGENTS / 4; i++) {
        	s = new Cheat();
			addAgent(new Prisoner(s));
        }
        for (int i = 0; i < TOTAL_AGENTS / 4; i++) {
        	s = new Tit4Tat();
			addAgent(new Prisoner(s));
        }
        for (int i = 0; i < TOTAL_AGENTS / 4; i++) {
        	s = new RandomlyCooperate();
			addAgent(new Prisoner(s));
        }
    }
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PDTournamentFactory());
		panel.display();
	}

}
