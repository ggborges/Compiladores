public class SleepMessages {
    public static void main(String[] args)
        throws InterruptedException {
            String importantInfo[] = {"msg1", "msg2"};

            for (int i = 0; i < importantInfo.length; i++){
                // Pausa por 4seg
                Thread.sleep(4000);
                // Imprime uma mensagem
                System.out.println(importantInfo[i]);
            }

    }
}
