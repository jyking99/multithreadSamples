package ch07.sample.s1;

public class Host {
    private final Helper helper = new Helper();
    // finalじゃなくてもコンパイルエラーにならない
    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new Thread() {
            public void run() {
                helper.handle(count, c);
            }
        }.start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
