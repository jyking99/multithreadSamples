package ch01.problem.q7;

public final class Mutex {
	private boolean locked = false;
	
	synchronized void lock() {
		if (locked) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		locked = true;
	}
	
	synchronized void unlock() {
		locked = false;
		notifyAll();
	}
}
