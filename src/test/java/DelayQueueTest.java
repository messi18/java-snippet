import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lancema on 15/10/25.
 */
public class DelayQueueTest {
    @Test
    public void shouldEmptyDelayQueueBlock() throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.take();
    }

    @Test
    public void testLoop() throws InterruptedException {
        while (true) {
            new File(".").listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return true;
                }
            });

            TimeUnit.SECONDS.sleep(10);
        }
    }
}
