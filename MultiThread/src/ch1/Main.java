package ch1;

public class Main {
	public static void main (String[] args) {
		new PrintThread("Good!").start();
		Thread niceThread = new PrintThread("Nice!");
		niceThread.setDaemon(true);
		niceThread.start();
	}
}
