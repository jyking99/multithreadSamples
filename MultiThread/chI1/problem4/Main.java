package problem4;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank("my account", 1000);
		new UserThread(bank, 1000, 100).start();
		new UserThread(bank, 1000, 100).start();
	}
}
