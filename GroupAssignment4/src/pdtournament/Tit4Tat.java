package pdtournament;

public class Tit4Tat extends Strategy{

	@Override
	public boolean cooperate() {
		// myPrisoner only cooperates if its last partner cooperated
		myPrisoner.willCheat = true;
		
		if (!myPrisoner.partnerCheated) {
			myPrisoner.willCheat = false;
			return myPrisoner.willCheat;
		} else {
			return myPrisoner.willCheat;
		}
	}

}
