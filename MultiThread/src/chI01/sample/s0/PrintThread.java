package chI01.sample.s0;

public class PrintThread extends Thread {
	private String message;
	public PrintThread(String message) {
		this.message = message;
	}
	public void run() {
		for (int i=0; i<10000; i++) {
			System.out.println(message);
		}
	}
}
