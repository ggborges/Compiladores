package exemplosgpt.SEMAFORO;

public class ExemploSemaforo {

    public static void main(String[] args) {
        Cruzamento cruzamento = new Cruzamento();

        Carro carro1 = new Carro("Carro 1", cruzamento);
        Carro carro2 = new Carro("Carro 2", cruzamento);

        carro1.start();
        carro2.start();
    }
}

class Carro extends Thread {
    private String nome;
    private Cruzamento cruzamento;

    public Carro(String nome, Cruzamento cruzamento) {
        this.nome = nome;
        this.cruzamento = cruzamento;
    }

    public void run() {
        cruzamento.entrarCruzamento(this.nome);
        cruzamento.sairCruzamento(this.nome);
    }
}

class Cruzamento {
    private boolean ocupado = false;

    public synchronized void entrarCruzamento(String carro) {
        while(ocupado) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        ocupado = true;
        System.out.println(carro + " entrou no cruzamento.");
    }

    public synchronized void sairCruzamento(String carro) {
        ocupado = false;
        System.out.println(carro + " saiu do cruzamento.");
        notify();
    }
}