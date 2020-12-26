package ch04.sample.s1;

import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class Data {
    private final String filename;  // �ۑ�����t�@�C���̖��O
    private String content;         // �f�[�^�̓��e
    private boolean changed;        // �ύX�������e���ۑ�����Ă��Ȃ��Ȃ�true

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    // �f�[�^�̓��e������������
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    // �f�[�^�̓��e���ύX����Ă�����t�@�C���ɕۑ�����
    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    // �f�[�^�̓��e�����ۂɃt�@�C���ɕۑ�����
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
