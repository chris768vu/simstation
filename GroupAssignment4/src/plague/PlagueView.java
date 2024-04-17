package plague;

import mvc.Model;
import simstation.Agent;
import simstation.SimulationView;

import java.awt.*;

public class PlagueView extends SimulationView {
    public PlagueView(Model model) {
        super(model);
    }

    @Override
    protected Color getAgentColor(Agent a) {
        if (((People)a).isInfected()) return Color.RED;
        return Color.GREEN;
    }
}