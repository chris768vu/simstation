package plague;

import mvc.*;
import simstation.*;

public class PlagueFactory extends SimulationFactory {
    @Override
    public Model makeModel() {
        return new PlagueSimstation();
    }
    @Override
    public View makeView(Model m) {
        return new PlagueView((PlagueSimstation)m);
    }

    @Override
    public String getTitle() {
        return "Plague";
    }
}