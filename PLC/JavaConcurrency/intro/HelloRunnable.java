public class HelloRunnable implements Runnable {
    public void run() {
        System.out.println("Hi from a runnable");
    }

    public static void main (String args[]) {
        (new Thread(new HelloRunnable())).start();
    }
}