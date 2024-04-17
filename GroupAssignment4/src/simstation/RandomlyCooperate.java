package pdtournament;

import mvc.Utilities;

public class RandomlyCooperate extends Strategy{

	@Override
	public boolean cooperate() {
		int rng = Utilities.rng.nextInt(2);
		if (rng > 0) {
			myPrisoner.willCheat = false;
			// myPrisoner will not cheat, so it will cooperate
			return true;
		} else if (rng <= 0) {
			myPrisoner.willCheat = true;
			// similarly...
			return false;
		} else {
			return false;
		}
	}
	
}
