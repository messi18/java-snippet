import com.test.QueueMonitor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("com.test:type=QueueMonitor");
        QueueMonitor mbean = new QueueMonitor();
        mbs.registerMBean(mbean, name);
        System.out.println("Server started.");
        TimeUnit.MINUTES.sleep(200);
    }

}

