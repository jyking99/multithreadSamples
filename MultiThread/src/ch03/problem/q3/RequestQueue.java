package ch03.problem.q3;

import java.util.Queue;
import java.util.LinkedList;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();
    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
            	System.out.println(Thread.currentThread().getName() + " entering waitlist");
                wait();
                System.out.println(Thread.currentThread().getName() + " awakens");
            } catch (InterruptedException e) {
            }
        }
        return queue.remove();
    }
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        System.out.println(Thread.currentThread().getName() + " notifyAll");
        notifyAll();
    }
}
