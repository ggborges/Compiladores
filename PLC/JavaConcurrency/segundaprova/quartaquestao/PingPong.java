package segundaprova.quartaquestao;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de interações (n): ");
        int numInteractions = scanner.nextInt();
        scanner.close();

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        int pingMessages = numInteractions % 2 == 0 ? numInteractions / 2 : (numInteractions / 2) + 1;
        int pongMessages = numInteractions / 2;

        Thread pingThread = new Thread(new PingRunnable(queue, pingMessages));
        Thread pongThread = new Thread(new PongRunnable(queue, pongMessages));

        pingThread.start();
        pongThread.start();
    }
}

class PingRunnable implements Runnable {
    private BlockingQueue<String> queue;
    private int numInteractions;

    public PingRunnable(BlockingQueue<String> queue, int numInteractions) {
        this.queue = queue;
        this.numInteractions = numInteractions;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numInteractions; i++) {
                queue.put("Ping");
                System.out.println("Ping");
                queue.take();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class PongRunnable implements Runnable {
    private BlockingQueue<String> queue;
    private int numInteractions;

    public PongRunnable(BlockingQueue<String> queue, int numInteractions) {
        this.queue = queue;
        this.numInteractions = numInteractions;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numInteractions; i++) {
                queue.put("Pong");
                System.out.println("Pong");
                queue.take();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
/*
Estou tendo dificuldade em manter um fala, da a vez para o outro falar, e ai alternam.
Estou enfrentando varios pings para depois varios pongs e alguns intercalados entre os outros
 */

