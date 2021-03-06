package ch07.problem.q4;

public class HelperThread extends Thread {
	private final Helper helper = new Helper();
	private int count;
	private char c;
	
	public HelperThread(int count, char c) {
		this.count = count;
		this.c = c;
	}
	
	@Override
	public void run() {
		helper.handle(count, c);
	}
}
