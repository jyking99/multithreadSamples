package ch08.sample.jucSample1;
import java.util.Random;

public class Request implements Runnable {
    private final String name; // �˗���
    private final int number;  // ���N�G�X�g�̔ԍ�
    private static final Random random = new Random();
    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
        }
    }
    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";
    }
}
