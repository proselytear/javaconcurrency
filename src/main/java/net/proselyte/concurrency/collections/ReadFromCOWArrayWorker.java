package net.proselyte.concurrency.collections;

import java.util.List;

public class ReadFromCOWArrayWorker implements Runnable {
    private final List<Integer> list;

    public ReadFromCOWArrayWorker(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(150);
                System.out.println(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
