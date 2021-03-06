package ch07.problem.q7;
public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");  // ここにはこない
        }
    }

// magic method
    private static void magic(Object obj) {
    	
    }

}
