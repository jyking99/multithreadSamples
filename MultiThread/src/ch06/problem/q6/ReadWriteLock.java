package ch06.problem.q6;

public final class ReadWriteLock {
    private int readingReaders = 0; // (a) ���ۂɓǂ�ł���X���b�h�̐�
    private int writingWriters = 0; // (b) ���ۂɏ����Ă���X���b�h�̐�

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0) {
            wait();
        }
        readingReaders++;                       // (a) ���ۂɓǂ�ł���X���b�h�̐���1���₷
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (a) ���ۂɓǂ�ł���X���b�h�̐���1���炷
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        while (readingReaders > 0 || writingWriters > 0) {
            wait();
        }
        writingWriters++;                       // (b) ���ۂɏ����Ă���X���b�h�̐���1���₷
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (b) ���ۂɏ����Ă���X���b�h�̐���1���炷
        notifyAll();
    }
}
