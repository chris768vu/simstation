package pdtournament;

public abstract class Strategy {
	Prisoner myPrisoner;
	
	public Strategy() {
		
	}
	public abstract boolean cooperate();
}
