package ch05.problem.q8;

public class Table {
    private final String[] buffer;
    private int tail;  // ����put����ꏊ
    private int head;  // ����take����ꏊ
    private int count; // buffer���̃P�[�L��
    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    /**
     * Changed notifyAll() to notify()
     * 以下のtake()で起こる問題の真逆で、ケーキが常に三つあって消費されない場合がある。
     * 
     * @param cake
     * @throws InterruptedException
     */
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notify();
    }
    /**
     * Changed notifyAll() to notify()
     * EaterThreadがケーキを取りnotify()を呼ぶと、MakerThreadではなくほかのEaterThreadが起こされる可能性がある。
     * それが続いた場合ケーキは減っていく一方で、補充するMakerThreadが長い間起こされないことになる。
     * 
     * @return
     * @throws InterruptedException
     */
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notify();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
