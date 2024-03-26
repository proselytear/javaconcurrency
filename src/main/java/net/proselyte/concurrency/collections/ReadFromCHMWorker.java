package net.proselyte.concurrency.collections;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class ReadFromCHMWorker implements Runnable{
    private final ConcurrentMap<String, Integer> map;

    public ReadFromCHMWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
            try {
                Thread.sleep(50);
                System.out.println("A: " + map.get("A"));
                System.out.println("B: " + map.get("B"));
                Thread.sleep(5000);
                System.out.println("C: " + map.get("C"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
