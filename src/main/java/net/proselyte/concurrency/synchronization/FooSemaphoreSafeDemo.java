package net.proselyte.concurrency.synchronization;

public class FooSemaphoreSafeDemo {
    public static void main(String[] args) {
        FooSemaphoreSafe foo = new FooSemaphoreSafe();

        Thread t1 = new Thread(foo::second);
        Thread t2 = new Thread(foo::first);
        Thread t3 = new Thread(foo::third);

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
