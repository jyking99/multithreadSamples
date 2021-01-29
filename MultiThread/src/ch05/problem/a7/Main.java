package ch05.problem.a7;

public class Main {
    public static void main(String[] args) {
        // Host�̏d�����������s����X���b�h
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

        // �N������
        executor.start();

        // ��15�b�x��
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
        }

        // �L�����Z�����s
        System.out.println("***** interrupt *****");
        executor.interrupt();
    }
}
