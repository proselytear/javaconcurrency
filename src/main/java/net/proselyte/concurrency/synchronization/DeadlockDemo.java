package net.proselyte.concurrency.synchronization;

public class DeadlockDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

        t1.start();
        try {
            Thread.sleep(1000);
            t2.start();
            Thread.sleep(1000);
            t3.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
