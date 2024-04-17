package pdtournament;

public class Cheat extends Strategy{
	@Override
	public boolean cooperate() {
		myPrisoner.willCheat = true;
		// opposite of cooperate
		return false;
	}
}
