package ch12.problem.q3.activeobject;

public interface ActiveObject {
    public abstract Result<String> search(String word);

	public abstract Result<String> add(String x, String y);
}
