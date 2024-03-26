package net.proselyte.concurrency.forkjoin;


public class SumStandardDemo {
    public static void main(String[] args) {
        int arraySize = 1_000_000_000;
        int[] array = new int[arraySize];

        fillArray(array);


        long start = System.currentTimeMillis();
        long calculatedSum = 0;

        for (int i = 0; i < arraySize; i++) {
            calculatedSum+=array[i];
        }

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

    private static long gaussSum(int n) {
        return (long) n * (n + 1) / 2;
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }
}
