package plague;

import mvc.Utilities;
import simstation.*;

public class People extends Agent {
    private static final int RADIUS = 15;
    private boolean isInfected;
    public People(){
        super();
        isInfected = false;
        heading = Heading.random();
    }
    private boolean infect(int rate){
        if (Utilities.rng.nextInt(100)< rate){
            return true;
        }
        return false;
    }
    public void infect(){this.isInfected=true;}
    private boolean resist(int rate){
        if (Utilities.rng.nextInt(100)<rate){
            return true;
        }
        return false;
    }
    public boolean isInfected(){
        return isInfected;
    }
    @Override
    public void update() {
        People neighbor = (People)world.getNeighbor(this, RADIUS);
        if (neighbor != null && neighbor.isInfected && !this.isInfected){
            isInfected = infect(PlagueSimulation.VIRULENCE);
            if (resist(PlagueSimulation.RESISTANCE)){isInfected = false ;}
        }
        heading = Heading.random();
        move(3);
    }
}