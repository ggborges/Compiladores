package segundaprova.primeiraquestao;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Aeroporto {
    
    private int pistasDisponiveis;
    private final Lock lock = new ReentrantLock();
    private final Condition pistaLivre = lock.newCondition();
    private long horarioInicio;

    public Aeroporto(int pistas, long horarioInicio) {
        this.pistasDisponiveis = pistas;
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioInicio(long horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public long getHorarioInicio() {
        return horarioInicio;
    }

    public long decolar() throws InterruptedException {
        lock.lock();
        long horarioReal;
        try {
            while (pistasDisponiveis == 0) {
                System.out.println("Sem pistas disponíveis. Avião aguarda para decolar");
                pistaLivre.await(); // variável de condição esperando ser satisfeita
            }

            // tem pelo menos 1 pista livre
            pistasDisponiveis--; // consome uma pista para o aviao atual
            horarioReal = System.currentTimeMillis();
            Thread.sleep(500);
            System.out.println("Decolou!");
        } finally {

            // libera a pista, pois a decolagem foi feita
            pistasDisponiveis++;
            System.out.println("Pista liberada");
            pistaLivre.signalAll(); // avisa as threads que aguardavam
            lock.unlock();
        }

        return horarioReal;
    }

    public long aterrissar() throws InterruptedException {
        lock.lock();
        long horarioReal;
        try{
            while (pistasDisponiveis == 0) {
                pistaLivre.await();
            }
            pistasDisponiveis--;
            horarioReal = System.currentTimeMillis();
            Thread.sleep(500);
            System.out.println("Pousou!");
        } finally {
            pistasDisponiveis++;
            System.out.println("Pista liberada");
            pistaLivre.signalAll();
            lock.unlock();
        }

        return horarioReal;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite número de aviões para decolar:");
        int N = scan.nextInt();

        System.out.println("Digite número de aviões para aterrissar");
        int M = scan.nextInt();

        System.out.println("Digite o número de pistas disponíveis:");
        int K = scan.nextInt();

        long horarioInicio = System.currentTimeMillis();

        Aeroporto aeroporto = new Aeroporto(K, horarioInicio);

        List<Aviao> decolagemList = new ArrayList<>();
        List<Aviao> aterrissagemList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            System.out.print("Digite o horário de saída do Avião " + i + " (em milissegundos após o início do programa): ");
            long horario = scan.nextLong();
            Aviao aviao = new Aviao(i, horario, aeroporto, "decolar");
            decolagemList.add(aviao);
        }

        for (int i = N; i < N + M; i++) {
            System.out.print("Digite o horário de chegada do Avião " + i + " (em milissegundos após o início do programa): ");
            long horario = scan.nextLong();
            Aviao aviao = new Aviao(i, horario, aeroporto, "pousar");
            aterrissagemList.add(aviao);
        }

        Collections.sort(decolagemList, (a1, a2) -> Long.compare(a1.getHorario(), a2.getHorario()));
        Collections.sort(aterrissagemList, (a1, a2) -> Long.compare(a1.getHorario(), a2.getHorario()));

        List<Thread> threads = new ArrayList<>();

        for (Aviao aviao : decolagemList) {
            threads.add(new Thread(aviao));
        }

        for (Aviao aviao : aterrissagemList) {
            threads.add(new Thread(aviao));
        }

        aeroporto.setHorarioInicio(System.currentTimeMillis());
        long temp = 0;
        
        // Iniciar todas as threads após ordenação
        for (Thread thread : threads) {
            //Aviao aviao = decolagemList.get(threads.indexOf(thread));
            //temp = aviao.getHorario() - temp;
            //aviao.setHorario(System.currentTimeMillis());
            thread.start();
        }

        scan.close();
    }
}

class Aviao implements Runnable {
    private int id;
    private long horario;
    private Aeroporto aeroporto;
    private String action;

    public Aviao(int id, long horario, Aeroporto aeroporto, String action) {
        this.id = id;
        this.horario = horario;
        this.aeroporto = aeroporto;
        this.action = action;
    }

    public void run() {
        // long espera = this.horario + this.aeroporto.getHorarioInicio();
        long horarioE, horarioReal, atraso;

        try {
            Thread.sleep(this.horario);
            horarioE = System.currentTimeMillis();

            if (action.equals("decolar")) {
                horarioReal = aeroporto.decolar();
                atraso = horarioReal - horarioE;

                System.out.println("Avião: " + id + " - Horário: " + this.horario + "ms | Horário real: " + (atraso + this.horario) + "ms | Atraso: " + atraso + "ms");
            } else {
                horarioReal = aeroporto.aterrissar();
                atraso = horarioReal - horarioE;

                System.out.println("Avião: " + id + " - Horário: " + this.horario + "ms | Horário real: " + (atraso + this.horario) + "ms | Atraso: " + atraso + "ms");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public long getHorario() {
        return horario;
    }

    public void setHorario(long horario) {
        this.horario = horario;
    }

    public int compareTo(Aviao aviao) {
        return Long.compare(this.horario, aviao.horario);
    }
}
