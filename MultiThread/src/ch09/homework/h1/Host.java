package ch09.homework.h1;
public class Host {
    public Data request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) FutureData�̃C���X�^���X�����
        final FutureData future = new FutureData();

        // (2) RealData����邽�߂̐V�����X���b�h���N������
        new Thread() {
            public void run() {
                RealData realdata = new RealData(count, c);
                future.setRealData(realdata);
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) FutureData�̃C���X�^���X��߂�l�Ƃ���
        return future;
    }
}
