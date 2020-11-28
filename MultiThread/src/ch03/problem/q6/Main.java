package ch03.problem.q6;

public class Main {
    public static void main(String[] args) {
        // �X���b�h���N������
        RequestQueue requestQueue = new RequestQueue();
        Thread alice = new ClientThread(requestQueue, "Alice", 314159L);
        Thread bobby = new ServerThread(requestQueue, "Bobby", 265358L);
        alice.start();
        bobby.start();

        // ��10�b�҂�
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        // interrupt���\�b�h���Ă�
        System.out.println("***** calling interrupt *****");
        alice.interrupt();
        bobby.interrupt();
    }
}
