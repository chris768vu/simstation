package pdtournament;
import simstation.*;

public class Cooperate extends Strategy {

	@Override
	public boolean cooperate() {
		myPrisoner.willCheat = false;
		return true;
	}
	
}
