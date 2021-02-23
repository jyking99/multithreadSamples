package ch06.problem.q4.data;

public abstract class AbstractReadWriteLock {
	private int readingReaders = 0;
	private int waitingWriters = 0; 
    private int writingWriters = 0; 
    private boolean preferWriter = true; 
    
    synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;                      
    }

    synchronized void readUnlock() {
        readingReaders--;              
        preferWriter = true;
        notifyAll();
    }

    synchronized void writeLock() throws InterruptedException {
        waitingWriters++;                      
        try {
            while (!allowWrite()) {
                wait();
            }
        } finally {
            waitingWriters--;              
        }
        writingWriters++;                      
    }

    synchronized void writeUnlock() {
        writingWriters--;                       
        preferWriter = false;
        notifyAll();
    }
    
    protected int getReadingReaders() {
		return readingReaders;
	}

	protected int getWaitingWriters() {
		return waitingWriters;
	}

	protected int getWritingWriters() {
		return writingWriters;
	}

	protected boolean isPreferWriter() {
		return preferWriter;
	}
    
    abstract boolean allowRead();
    abstract boolean allowWrite();
}
