package segundaprova.primeiraquestao;

import java.util.Scanner;

public class Questao {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite número de aviões para decolar:");
        int N = scan.nextInt();

        System.out.println("Digite número de aviões para aterrissar");
        int M = scan.nextInt();

        System.out.println("Digite o número de pistas disponíveis:");
        int K = scan.nextInt();

       //Aeroporto aeroporto = new Aeroporto(K);

        

        scan.close();
    }
}
