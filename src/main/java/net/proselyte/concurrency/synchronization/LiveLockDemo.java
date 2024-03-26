package net.proselyte.concurrency.synchronization;

public class LiveLockDemo {
    public static void main(String[] args) {
        final Eater husband = new Eater("Bob");
        final Eater wife = new Eater("Alice");

        final Spoon s = new Spoon(husband);

        new Thread(() -> husband.eatWith(s, wife)).start();
        new Thread(() -> wife.eatWith(s, husband)).start();
    }
}
