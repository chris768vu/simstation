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
		    	onStart();
		    	onInterrupted();
		    	
		        update();
		        Thread.sleep(20);
		        checkSuspended();
		        
		        onExit();
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
	
	/* "At strategic places Agent.run() calls empty methods: onStart, onInterrupted, and OnExit. 
	 * These can be overridden in subclasses if needed."
	 */
	public void onStart() {}
	public void onInterrupted() {}
	public void onExit() {}

	public void start() {}
	
	public void suspend() {}
	
	public void resume() {}
	
	public void stop() {}
	
	public void move(int steps) {
		for (int i = 0; i < steps; i++) {
			/* add or substract to xc or yc depending on this.heading...
			 * 
			 * so we need our latest Heading.java in to the repository,
			 * because I think someone already did it
			 */
			world.changed();
		}
	}
}
