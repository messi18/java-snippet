package com.test;

import java.util.ArrayList;
import java.util.List;

public class QueueMonitor implements QueueMonitorMBean {
    private List<String> queue = new ArrayList<String>();

    @Override
    public int getQueueSize() {
        return queue.size();
    }

    @Override
    public void addItem(String item) {
        queue.add(item);
    }
}
