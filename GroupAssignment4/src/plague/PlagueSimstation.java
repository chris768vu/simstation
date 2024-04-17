package plague;

import simstation.*;
import mvc.*;

import java.util.Iterator;

public class PlagueSimstation extends Simulation {
    public static int COMMUNITYSIZE = 50;
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public static int INITIALINFECTION = 1;
    public int infected;
    @Override
    public void populate() {
        infected = 0;
        for(int i = 0; i < COMMUNITYSIZE; i++)
            addAgent(new People());
        initialize();
    }
    private void initialize(){
        Iterator<Agent> it = agentIterator();
        while(it.hasNext()){
            if (infected< INITIALINFECTION){
                ((People)it.next()).infect();
                infected++;
            }
            else {it.next();}
        }
    }
    @Override
    public String[] getStats() {
        return new String[]{"# agents = " + agents.size()
                + "\nclock = " + getTime()
                + "\n% infected = " + getPercentInfected()};
    }
    private int getPercentInfected() {

        return 100*getNumInfected()/COMMUNITYSIZE;
    }
    public int getNumInfected(){
        int infectedCount = 0;
        Iterator<Agent> it = agentIterator();
        while (it.hasNext()) {
            if (((People) it.next()).isInfected()) {
                infectedCount += 1;
            }
        }
        return infectedCount;
    }
    public static void main(String[] args) {
        AppFactory factory = new PlagueFactory();
        SimulationPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}