package ch05.problem.q9;

public class Something {
    public static void method(long x) throws InterruptedException {
        if (x != 0) {
            Object object = new Object();
            synchronized (object) {
                object.wait(x);
            }
        }
    }
}
