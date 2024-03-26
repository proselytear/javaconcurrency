package net.proselyte.concurrency.collections;

import java.util.concurrent.ConcurrentMap;

public class WriteToCHMWorker implements Runnable {
    private final ConcurrentMap<String, Integer> map;

    public WriteToCHMWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.put("A", 1);
            Thread.sleep(100);
            map.put("B", 2);
            Thread.sleep(100);
            map.put("C", 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
