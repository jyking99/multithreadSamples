package ch07.problem.q4;

public class Host {
    
    // finalじゃなくてもコンパイルエラーにならない
    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new HelperThread(count, c).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
