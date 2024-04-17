package pdtournament;

import mvc.Utilities;

public class RandomlyCooperate extends Strategy{

	public RandomlyCooperate() {
		super();
	}
	
	public boolean cooperate() {
		int rng = Utilities.rng.nextInt(2);
		if (rng > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
