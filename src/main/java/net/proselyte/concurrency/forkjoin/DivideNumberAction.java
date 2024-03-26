package net.proselyte.concurrency.forkjoin;

import java.util.concurrent.RecursiveAction;

public class DivideNumberAction extends RecursiveAction {

    private final Integer THRESHOLD = 1;

    private final Integer value;

    public DivideNumberAction(Integer value) {
        this.value = value;
    }

    @Override
    protected void compute() {
        if(value > THRESHOLD) {
            System.out.println("Halving: " + value);

            DivideNumberAction leftTask = new DivideNumberAction(value/2);
            DivideNumberAction rightTask = new DivideNumberAction(value/2);
            invokeAll(leftTask, rightTask);
        } else {
            System.out.println("Halving finished");
        }
    }
}
