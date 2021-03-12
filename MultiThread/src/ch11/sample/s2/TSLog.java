package ch11.sample.s2;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TSLog {
    private PrintWriter writer = null;

    // writer�t�B�[���h�̏�����
    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ���O������
    public void println(String s) {
        writer.println(s);
    }

    // ���O�����
    public void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
