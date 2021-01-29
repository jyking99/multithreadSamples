package ch05.problem.q7;

public class HostThread extends Thread {
	@Override
	public void run () {
		try {
			Host.execute(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
