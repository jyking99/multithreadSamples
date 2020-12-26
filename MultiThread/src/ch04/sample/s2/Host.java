package ch04.sample.s2;

import java.util.concurrent.TimeoutException;

public class Host {
    private final long timeout; // �^�C���A�E�g�l
    private boolean ready = false; // ���\�b�h���s���Ă悢�Ȃ�true

    public Host(long timeout) {
        this.timeout = timeout;
    }

    // ��Ԃ̕ύX������
    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }

    // ��Ԃ��l������Ŏ��s����
    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis(); // �J�n����
        while (!ready) {
            long now = System.currentTimeMillis(); // ���ݎ���
            long rest = timeout - (now - start); // �c��̑҂�����
            if (rest <= 0) {
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    // ���ۂ̏���
    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }
}
