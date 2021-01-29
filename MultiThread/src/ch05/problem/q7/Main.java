package ch05.problem.q7;

import ch05.problem.a7.Host;

public class Main {
	public static void main(String[] args) {
		Thread executor = new Thread() {
	        public void run() {
	            System.out.println("Host.execute BEGIN");
	            try {
	                Host.execute(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println("Host.execute END");
	        }
	    };
		
//		HostThread ht = new HostThread();
		executor.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Interrupting...");
		executor.interrupt();
	}
}
