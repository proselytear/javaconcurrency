package net.proselyte.concurrency.threadsintro;

public class SimpleCounterDemo {
    public static void main(String[] args) {
        SimpleCounterWorker scw1 = new SimpleCounterWorker("A");
        SimpleCounterWorker scw2 = new SimpleCounterWorker("B");

        scw1.runCounter(15);
        scw2.runCounter(15);
    }
}
