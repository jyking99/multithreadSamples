package ch12.problem.q3.activeobject;

class Proxy implements ActiveObject {
    private final SchedulerThread scheduler;
    private final Servant servant;
    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }
    public Result<String> search(String word) {
        FutureResult<String> future = new FutureResult<String>();
        scheduler.invoke(new SearchRequest(servant, future, word));
        return future;
    }

	public Result<String> add(String x, String y) {
		FutureResult<String> future = new FutureResult<String>();
        scheduler.invoke(new AddRequest(servant, future, x, y));
        return future;
	}
}
