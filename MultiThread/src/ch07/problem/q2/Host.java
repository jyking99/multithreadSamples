package ch07.problem.q2;

public class Host {
    private final Helper helper = new Helper();
    // finalじゃなくてもコンパイルエラーにならない
    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        helper.handle(count, c);
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
