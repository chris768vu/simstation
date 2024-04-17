package pdtournament;

public class Cheat extends Strategy{
	
	public Cheat() {
		super();
	}

	public boolean cooperate() {
		// opposite of cooperate
		return false;
	}
}
