package net.proselyte.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class SumDemo {
    public static void main(String[] args) {
        int arraySize = 1_000_000_000;
        int[] array = new int[arraySize];

        fillArray(array);


        long start = System.currentTimeMillis();
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            long calculatedSum = forkJoinPool.invoke(new SumTask(array, 0, array.length));
            System.out.println("Sum: " + calculatedSum);
            long gaussSum = gaussSum(arraySize);
            System.out.println("Gauss sum: " + gaussSum);

            if (gaussSum == calculatedSum) {
                System.out.println("Result is correct");
            }

            long end = System.currentTimeMillis();
            long duration = end - start;
            System.out.println("Time elapsed: " + duration + " ms");
        }
    }

    private static long gaussSum(int n) {
        return (long) n * (n + 1) / 2;
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }
}
