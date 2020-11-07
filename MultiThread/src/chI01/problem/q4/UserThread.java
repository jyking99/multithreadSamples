package chI01.problem.q4;

public class UserThread extends Thread {
	private Bank bank;
	
	public UserThread(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		while (true) {
			if (bank.withdraw(1000)) {
				bank.deposit(1000);
			}
		}
	}
}
