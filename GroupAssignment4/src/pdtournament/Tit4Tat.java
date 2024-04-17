package pdtournament;

public class Tit4Tat extends Strategy{

	@Override
	public boolean cooperate() {
		// myPrisoner's last partner cheated, so it will cheat against this new partner
		if (myPrisoner.cheated) {
			return false;
		} else {
			return true;
		}
	}

}
