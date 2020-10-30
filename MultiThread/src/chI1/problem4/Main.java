package chI1.problem4;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank("my account", 1000);
		new UserThread(bank).start();
		new UserThread(bank).start();
	}
}
