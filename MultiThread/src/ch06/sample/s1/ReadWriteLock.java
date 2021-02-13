package ch06.sample.s1;
public final class ReadWriteLock {
    private int readingReaders = 0; // (A) ���ۂɓǂ�ł���Œ��̃X���b�h�̐�
    private int waitingWriters = 0; // (B) �����̂�҂��Ă���X���b�h�̐�
    private int writingWriters = 0; // (C) ���ۂɏ����Ă���Œ��̃X���b�h�̐�
    private boolean preferWriter = true; // �����̂�D�悷��Ȃ�true

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;                       // (A) ���ۂɓǂ�ł���X���b�h�̐���1���₷
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (A) ���ۂɓǂ�ł���X���b�h�̐���1���炷
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;                       // (B) �����̂�҂��Ă���X���b�h�̐���1���₷
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;                   // (B) �����̂�҂��Ă���X���b�h�̐���1���炷
        }
        writingWriters++;                       // (C) ���ۂɏ����Ă���X���b�h�̐���1���₷
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (C) ���ۂɏ����Ă���X���b�h�̐���1���炷
        preferWriter = false;
        notifyAll();
    }
}
