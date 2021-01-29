package ch04.problem.a4;

import java.util.Queue;
import java.util.LinkedList;

public class RequestQueue {
    private static final long TIMEOUT = 30000L;
    private final Queue<Request> queue = new LinkedList<Request>();
    public synchronized Request getRequest() {
        long start = System.currentTimeMillis(); // �J�n����
        while (queue.peek() == null) {
            long now = System.currentTimeMillis(); // ���ݎ���
            long rest = TIMEOUT - (now - start); // �c��̑҂�����
            if (rest <= 0) {
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
            }
            try {
                wait(rest);
            } catch (InterruptedException e) {
            }
        }
        return queue.remove();
    }
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
