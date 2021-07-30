package ch12.problem.q2;
import ch12.problem.q3.activeobject.ActiveObject;
import ch12.problem.q3.activeobject.ActiveObjectFactory;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new AddClientThread("Diana", activeObject).start();
    }
}
