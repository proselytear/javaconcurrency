package net.proselyte.concurrency.threadsintro;

public class ThreadCounterDemo {
    public static void main(String[] args) {
        ThreadCounterWorker tcw1 = new ThreadCounterWorker("A", 1000);
        ThreadCounterWorker tcw2 = new ThreadCounterWorker("B", 1000);

        // МНОГОПОТОЧНАЯ ОБРАБОТКА
        tcw1.start();
        tcw2.start();
    }
}
