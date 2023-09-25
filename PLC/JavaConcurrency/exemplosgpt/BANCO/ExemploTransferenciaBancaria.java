package exemplosgpt.BANCO;

public class ExemploTransferenciaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria(1, 1000);
        ContaBancaria conta2 = new ContaBancaria(2, 2000);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                conta1.transferir(conta2, 100);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                conta2.transferir(conta1, 200);
            }
        });

        thread1.start();
        thread2.start();

        try {
            System.out.println("try catch");
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo da conta 1: " + conta1.getSaldo());
        System.out.println("Saldo da conta 2: " + conta2.getSaldo());
    }

    static class ContaBancaria {
    private int numero;
    private int saldo;

    public ContaBancaria(int numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public synchronized void depositar(int valor) {
        System.out.println("teste dep");
        this.saldo += valor;
        System.out.println("Depósito de " + valor + " na conta " + numero);
    }

    public synchronized boolean sacar(int valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " na conta " + this.numero);
            return true;
        } else {
            System.out.println("Saldo insuficiente na conta " + this.numero + " para saque de " + valor);
            return false;
        }
    }

    public void transferir(ContaBancaria destino, int valor) {
        if (this.sacar(valor)) {
            System.out.println("Transferência de " + valor + " da conta " + this.numero + " para " + destino.getNumero());
            synchronized (this) {
                destino.depositar(valor);            
            }
            
        }
    }
}

}

