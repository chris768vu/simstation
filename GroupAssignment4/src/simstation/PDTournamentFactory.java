package pdtournament;

import mvc.*;
import simstation.*;

public class PDTournamentFactory extends SimulationFactory {
	public Model makeModel() {return new PDTournamentSimulation();}
	public String getTitle() {return "Prisoner's Dilemma Tournament";}
}
