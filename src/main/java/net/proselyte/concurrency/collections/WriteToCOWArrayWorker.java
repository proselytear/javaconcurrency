package net.proselyte.concurrency.collections;

import java.util.List;
import java.util.Random;

public class WriteToCOWArrayWorker implements Runnable {

    private final List<Integer> list;

    private final Random random = new Random();

    public WriteToCOWArrayWorker(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                this.list.set(random.nextInt(list.size()), random.nextInt());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
