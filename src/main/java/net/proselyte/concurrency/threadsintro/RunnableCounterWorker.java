package net.proselyte.concurrency.threadsintro;

public class RunnableCounterWorker implements Runnable {

    private final String name;
    private final Integer range;

    public RunnableCounterWorker(String name, Integer range) {
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
