package ch07.problem.q5;

public class Service {
    public static void service() {
        new Thread() {
        	public void run() {
        		Handler.handle();
        	}
        }.start();
    }
}
