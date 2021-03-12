package ch12.sample.s1.activeobject;

public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillchar);
    public abstract void displayString(String string);
}
