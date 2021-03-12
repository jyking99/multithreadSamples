package ch12.sample.s1;
import ch12.sample.s1.activeobject.ActiveObject;
import ch12.sample.s1.activeobject.Result;

public class DisplayClientThread extends Thread {
    private final ActiveObject activeObject;
    public DisplayClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }
    public void run() {
        try {
            for (int i = 0; true; i++) {
                // �߂�l�̂Ȃ��Ăяo��
                String string = Thread.currentThread().getName() + " " + i;
                activeObject.displayString(string);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
        }
    }
}
