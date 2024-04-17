package pdtournament;

import mvc.Utilities;

public class RandomlyCooperate extends Strategy{

	@Override
	public boolean cooperate() {
		int rng = Utilities.rng.nextInt(2);
		if (rng > 1)
			return true;
		if (rng < 1)
			return false;
		else
			return false;
	}
}
