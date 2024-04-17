package pdtournament;

public class Tit4Tat extends Strategy {
	
	public Tit4Tat() {
		super();
	}
	
	/* myPrisoner cheats (i.e. not cooperate) unless
		its last partner cooperates */
	public boolean cooperate() {
		if (!myPrisoner.partnerCheated) {
			return true;
		} else {
			return false;
		}
	}

}
