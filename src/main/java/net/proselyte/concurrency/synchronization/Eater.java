package net.proselyte.concurrency.synchronization;

public class Eater {
    private String name;
    private boolean isHungry;

    public Eater(String n) {
        name = n;
        isHungry = true;
    }

    public String getName() {
        return name;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void eatWith(Spoon spoon, Eater spouse) {
        while (isHungry) {
            // Don't have the spoon, so wait patiently for spouse.
            if (spoon.getOwner() != this) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    continue;
                }
                continue;
            }

            // If spouse is hungry, insist upon passing the spoon.
            if (spouse.isHungry()) {
                System.out.printf(
                        "%s: You eat first my darling %s!%n",
                        name, spouse.getName());
                spoon.setOwner(spouse);
                continue;
            }

            // Spouse wasn't hungry, so finally eat
            spoon.use();
            isHungry = false;
            System.out.printf(
                    "%s: I am stuffed, my darling %s!%n",
                    name, spouse.getName());
            spoon.setOwner(spouse);
        }
    }
}
