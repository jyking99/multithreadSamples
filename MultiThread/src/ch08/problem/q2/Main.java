package ch08.problem.q2;
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel();   // ���[�J�[�X���b�h�̌�
//        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
    }
}
