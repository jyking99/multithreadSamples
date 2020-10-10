package problem4;

public class Bank {
    private int money;
    private String name;
    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }
    public void deposit(int m) {
    	printDeposit("in deposit before (" + m + ")");
        money += m;
    	printDeposit("in deposit after (" + m + ")");
    }
    public boolean withdraw(int m) {
    	printDeposit("in withdraw before (" + m + ")");
        if (money >= m) {
       		if (Thread.currentThread().getId() % 2 == 0) {
	        	try {
        			Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
            money -= m;
            check();
            return true;
        } else {
        	return false;
        }
    }
    public String getName() {
        return name;
    }
    private void check() {
    	printDeposit("in check");
        if (money < 0) {
        	System.err.println(Thread.currentThread().getId() + "(in check error)�a���c�����}�C�i�X�ł�! money = " + money);
        }
    }
	/**
	 * 
	 */
	public void printDeposit(String message) {
		System.out.println(Thread.currentThread().getId() + "(" + message + ")�a���c�� = " + money);
	}
}
