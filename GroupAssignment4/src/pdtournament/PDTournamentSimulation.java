package pdtournament;

import mvc.*;
import simstation.*;
import java.util.Iterator;

public class PDTournamentSimulation extends Simulation {
	final static int TOTAL_AGENTS = 40;
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
        for (int i = 0; i < 40; i++)
        	if (i < 10) {
        		addAgent(new Prisoner());
        	}
        
    }
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PDTournamentFactory());
		panel.display();
	}

}
