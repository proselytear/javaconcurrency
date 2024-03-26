package net.proselyte.concurrency.synchronization;

class SyncThread implements Runnable {
    private final Object lock1;
    private final Object lock2;

    public SyncThread(Object o1, Object o2) {
        this.lock1 = o1;
        this.lock2 = o2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread: " + name + " acquiring lock on " + lock1);
        synchronized (lock1) {
            System.out.println(name + " acquired lock on " + lock1);
            work();
            System.out.println(name + " acquiring lock on " + lock2);
            synchronized (lock2) {
                System.out.println(name + " acquired lock on " + lock2);
                work();
            }
            System.out.println(name + " released lock on " + lock2);
        }
        System.out.println(name + " released lock on " + lock1);
        System.out.println(name + " finished execution.");
    }

    private void work() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
