package ch10.sample.jucSample2;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static final int THREADS = 3; // �X���b�h�̌�

    public static void main(String[] args) {
        System.out.println("BEGIN");

        // �d�������s����X���b�h��񋟂���ExecutorService
        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        // �o���A�����������Ƃ��̃A�N�V����
        Runnable barrierAction = new Runnable() {
            public void run() {
                System.out.println("Barrier Action!");
            }
        };

        // �t�F�[�Y�����킹��CyclicBarrier
        CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, barrierAction);

        // �d���̏I���𒲂ׂ�CountDownLatch
        CountDownLatch doneLatch = new CountDownLatch(THREADS);

        try {
            // �d�����J�n����
            for (int t = 0; t < THREADS; t++) {
                service.execute(new MyTask(phaseBarrier, doneLatch, t));
            }
            // �d���̏I����҂�
            System.out.println("AWAIT");
            doneLatch.await();
        } catch (InterruptedException e) {
        } finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
