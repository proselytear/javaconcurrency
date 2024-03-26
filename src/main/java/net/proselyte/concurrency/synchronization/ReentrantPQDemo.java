package net.proselyte.concurrency.synchronization;

public class ReentrantPQDemo {
    public static void main(String[] args) {
        SimplePQ simplePQ = new SimplePQ();

        Thread t1 = new Thread(() -> {
            try {
                simplePQ.send();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                simplePQ.receive();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }
}
