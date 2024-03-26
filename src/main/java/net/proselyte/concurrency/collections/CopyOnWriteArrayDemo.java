package net.proselyte.concurrency.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.addAll(Arrays.asList(100500, 200800, 100, 200, 300, 500));

        WriteToCOWArrayWorker writeToCOWArrayWorker = new WriteToCOWArrayWorker(list);
        ReadFromCOWArrayWorker readFromCOWArrayWorker = new ReadFromCOWArrayWorker(list);

        Thread t1 = new Thread(writeToCOWArrayWorker);
        Thread t2 = new Thread(writeToCOWArrayWorker);
        Thread t3 = new Thread(readFromCOWArrayWorker);

        t1.start();
        t2.start();
        t3.start();
    }
}
