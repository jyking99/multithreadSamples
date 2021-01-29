package ch05.problem.q7;

public class Host {
    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            doHeavyJob();
        }
    }
    private static void doHeavyJob() {
        // 以下は、
    	// キャンセル不可能な重い処理Jのfl;';A1
    	// (約10秒間回るループ)
        System.out.println("doHeavyJob BEGIN");
        long start = System.currentTimeMillis();
        while (start + 10000 > System.currentTimeMillis()) {
            // busy loop
        }
        System.out.println("doHeavyJob END");
    }
}
