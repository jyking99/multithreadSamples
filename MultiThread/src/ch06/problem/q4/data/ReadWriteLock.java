package ch06.problem.q4.data;
public final class ReadWriteLock extends AbstractReadWriteLock {

	@Override
	boolean allowRead() {
		if (getWritingWriters() > 0 || (isPreferWriter() && getWaitingWriters() > 0)) {
			return false;
		}
		return true;
	}

	@Override
	boolean allowWrite() {
		if (getReadingReaders() > 0 || getWritingWriters() > 0) {
			return false;
		}
		return true;
	}
    
}
