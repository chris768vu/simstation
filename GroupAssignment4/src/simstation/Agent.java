package simstation;

import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable {
	protected Simulation world;
	protected String name;
	protected Heading heading;
	protected int xc;
	protected int yc;
	protected boolean suspended = false;
	protected boolean stopped = false;
	transient protected Thread myThread;
	
	public void run() {
		myThread = Thread.currentThread();
		while (!stopped) {
		    try {
		        update();
		        Thread.sleep(20);
		        checkSuspended();
		    } catch(InterruptedException e) {
		       e.getMessage();
		    }
		}
    }
	
	 private synchronized void checkSuspended() {
		try {
		    while(!stopped && suspended) {
		        wait();
		        suspended = false;
		    }
		} catch (InterruptedException e) {
		   e.getMessage();
		}
	 }
	 // is called by run() and will be overridden by subclasses?
	public abstract void update();

	public void start() {}
	
	public void suspend() {}
	
	public void resume() {}
	
	public void stop() {}
	
	public void move(int steps) {}
}
