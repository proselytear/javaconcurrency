package net.proselyte.concurrency.synchronization;

public class SimplePQ {
    public void send() throws InterruptedException {
        synchronized (this) {
//            Thread.sleep(5000);
            System.out.println("New message generated...");
            wait();
            System.out.println("Previous message sent...");
        }
    }


    public void receive() throws InterruptedException {
        Thread.sleep(5000);
        synchronized (this) {
            System.out.println("Message received...");
            notify();
        }
    }

}
