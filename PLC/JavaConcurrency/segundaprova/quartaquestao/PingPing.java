package segundaprova.quartaquestao;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PingPing {
    public static void main(String[] args) {
        int numMessages = 10; // Número de mensagens a serem enviadas

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de mensagens: (n)");
        int n = scan.nextInt();

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(n);

        Thread sender = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    queue.put("Ping");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread receiver = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    String message = queue.take();
                    Thread.sleep(500);
                    System.out.println("Consumido: " + (i+1) + "º " + message);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        sender.start();
        receiver.start();
    }
}
