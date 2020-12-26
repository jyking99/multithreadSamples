package test;

public class TimeTest {
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		long now2 = System.currentTimeMillis();
		System.out.println("time elapsed: " + String.valueOf(now-now2));
	}
}
