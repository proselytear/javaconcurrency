package net.proselyte.concurrency.synchronization;

public class FooUnsafeDemo {
    public static void main(String[] args) {
        FooUnsafe foo = new FooUnsafe();
        Thread t1 = new Thread(foo::first);
        Thread t2 = new Thread(foo::second);
        Thread t3 = new Thread(foo::third);

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
