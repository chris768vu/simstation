package simstation;

import mvc.Utilities;

import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable {
	private static final int SLEEP = 50;
	protected String name;
	protected Heading heading;
	protected double xc;
	protected double yc;
	protected Simulation world;
	private boolean suspended = false;
	private boolean stopped = false;
	transient protected Thread myThread;

	public Agent(String name) {
		this.name = name;
	}

	public Agent() {
		//super();
		suspended = false;
		stopped = false;
		myThread = null;

		heading = Heading.random();
		xc = Utilities.rng.nextInt(Simulation.SIZE);
		yc = Utilities.rng.nextInt(Simulation.SIZE);
	}

	@Override
	public void run() {
		myThread = Thread.currentThread();
		onStart();
		while (!stopped) {
			try {
				update();
				Thread.sleep(SLEEP);
				checkSuspended();
			} catch (InterruptedException e) {
				Utilities.error(e);
			}
		}
		onExit();
		world.changed();
	}

	public synchronized void start() {
		myThread = new Thread(this);
		myThread.start();
	}

	public synchronized void suspend() {
		suspended = true;
	}

	public synchronized void resume() {
		suspended = false;
		notify();
	}

	public synchronized void stop() {
		stopped = true;
	}

	public abstract void update();


	public void setWorld(Simulation world) {
		this.world = world;
	}

	public void onStart() {
	}
	public void onInterrupt(){

	}
	public void onExit() {
	}

	private synchronized void checkSuspended() {
		try {
			while (!stopped && suspended) {
				onInterrupt();
				wait();
				suspended = false;
			}
		} catch (InterruptedException e) {
			Utilities.error(e);
		}
	}
	
	public synchronized void move(int steps) {
		for (int i = 0; i < steps; i++) {
			xc = (xc + Simulation.SIZE + heading.getxDrt()) % Simulation.SIZE;
			yc = (yc + Simulation.SIZE + heading.getyDrt()) % Simulation.SIZE;
			world.changed();
		}
	}
	
	public synchronized double getXc() {
		return xc;
	}

	public synchronized double getYc() {
		return yc;
	}
}