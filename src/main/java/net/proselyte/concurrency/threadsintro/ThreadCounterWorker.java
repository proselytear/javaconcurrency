package net.proselyte.concurrency.threadsintro;

public class ThreadCounterWorker extends Thread {
    private final String name;
    private final Integer range;

    public ThreadCounterWorker(String name, Integer range) {
        this.name = name;
        this.range = range;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter <= range) {
            System.out.println(name + ": " + counter++);
        }
    }
}
