package ch12.problem.q2.activeobject;

public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillchar);
    public abstract void displayString(String string);
    public abstract Result<String> add(String x, String y);
}
