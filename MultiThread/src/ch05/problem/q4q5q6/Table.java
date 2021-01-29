package ch05.problem.q4q5q6;

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
    // �P�[�L��u��
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
        	System.out.println(Thread.currentThread().getName() + " waits");
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }
    // �P�[�L�����
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
        	System.out.println(Thread.currentThread().getName() + " waits");
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
    
    public synchronized void clear() {
    	for (String cake : buffer) {
    		cake = null;
    	}
    	head = 0;
    	tail = 0;
    	count = 0;
    }
}
