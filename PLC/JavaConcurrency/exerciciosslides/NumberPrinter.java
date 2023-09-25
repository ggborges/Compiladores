package exerciciosslides;

public class NumberPrinter {
    
    private static final int MAX_THREADS = 50;
    private static final int NUM_TO_PRINT = 2000000000;

    public static void main(String[] args) {
        int number_per_threads = NUM_TO_PRINT / MAX_THREADS;
        int remainder = NUM_TO_PRINT % MAX_THREADS;

        Thread[] threads = new Thread[MAX_THREADS];
        int currentNumber = 1;

        for (int i = 0; i < MAX_THREADS; i++) {
            int threadStart = currentNumber;
            int threadEnd = currentNumber + number_per_threads - 1 + (1 < remainder ? 1 : 0);
            currentNumber = threadEnd + 1;
            threads[i] = new Thread(new NumberPrintingTask(threadStart, threadEnd, i));
            threads[i].start();
        }

        long startTime = System.currentTimeMillis();

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("All threads finished");
        System.out.println("Execution time: " + (endTime - startTime) + "miliseconds");
    }

    static class NumberPrintingTask implements Runnable {
        private int start;
        private int end;
        private int threadNumber;

        public NumberPrintingTask(int start, int end, int threadNumber) {
            this.start = start;
            this.end = end;
            this.threadNumber = threadNumber;
        }

        public void run() {
            for (int i = start; i <= end; i++) {
                System.out.println("Thread " + threadNumber + ": " + i);
            }

            System.out.println("Thread " + threadNumber + "finished.");
        }
    }

}
