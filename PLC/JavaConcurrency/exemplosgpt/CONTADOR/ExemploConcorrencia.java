package exemplosgpt.CONTADOR;

public class ExemploConcorrencia {
    public static void main(String[] args) {
        Contador counter = new Contador();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final do contador: " + counter.getValor());
    }
}

class Contador {
    private int valor = 0;

    public synchronized void increment() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}