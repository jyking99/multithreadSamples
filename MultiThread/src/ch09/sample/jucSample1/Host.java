package ch09.sample.jucSample1;
import java.util.concurrent.Callable;

public class Host {
    public FutureData request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) FutureData�̃C���X�^���X�����
        //     �i�R���X�g���N�^��Callable<RealData>��n���j
        FutureData future = new FutureData(
            new Callable<RealData>() {
                public RealData call() {
                    return new RealData(count, c);
                }
            }
        );

        // (2) RealData����邽�߂̐V�����X���b�h���N������
        new Thread(future).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) FutureData�̃C���X�^���X��߂�l�Ƃ���
        return future;
    }
}
