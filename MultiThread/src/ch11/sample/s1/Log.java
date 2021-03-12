package ch11.sample.s1;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static PrintWriter writer = null;

    // writer�t�B�[���h�̏�����
    static {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ���O������
    public static void println(String s) {
        writer.println(s);
    }

    // ���O�����
    public static void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
