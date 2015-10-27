import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lancema on 15/10/27.
 */
public class InterruptTest {
    private static Logger LOG = LoggerFactory.getLogger(InterruptTest.class);

    private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(100);

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        LOG.info("Taking from queue");
                        String take = blockingQueue.take();
                        LOG.info("Got {} from queue", take);
                    }
                } catch (InterruptedException e) {
                    LOG.info("Takeing thread is interrupted.");
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    LOG.info("Putting to queue");
                    try {
                        blockingQueue.put("test");
                    } catch (InterruptedException e) {
                        LOG.info("Putting thread is interrupted.");
                        break;
                    }
                }
                LOG.info("Finished putting to queue");
            }
        };

        thread1.start();
        thread2.start();

        TimeUnit.SECONDS.sleep(5);

        thread1.interrupt();
        TimeUnit.SECONDS.sleep(5);
        thread2.interrupt();
        Thread.currentThread().join();
        LOG.info("Main thread exited.");
    }
}
