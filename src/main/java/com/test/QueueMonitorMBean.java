package com.test;

public interface QueueMonitorMBean {
    int getQueueSize();

    void addItem(String item);
}
