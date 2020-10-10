package problem4;

public class UserThread extends Thread {
	private Bank bank;
	private int withdraw;
	private int deposit;
	
	public UserThread(Bank bank, int withdraw, int deposit) {
		this.bank = bank;
		this.withdraw = withdraw;
		this.deposit = deposit;
	}
	
	public void run() {
		while (true) {
			if (!bank.withdraw(withdraw)) {
				bank.deposit(deposit);
			}
		}
	}
}
