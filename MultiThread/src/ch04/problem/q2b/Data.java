package ch04.problem.q2b;

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
    public void save() throws IOException {   // not synchronized
        if (!changed) {
            System.out.println(Thread.currentThread().getName() + " balks");
            return;
        }
        doSave();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
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
