package exemplosgpt;

public class ExemplosThreads {
    
    public static void main(String[] args) {
        Thread[] threads = {(new Thread(new ImparThread())), (new Thread(new ParThread()))};
        
        for(int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    static class ParThread implements Runnable {
        public void run() {
            for (int i = 2; i <= 20; i += 2) {
                System.out.println("Número par: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ImparThread implements Runnable {
        public void run() {
            for(int i = 1; i <= 19; i += 2) {
                System.out.println("Número ímpar: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }            
        }
    }
}
