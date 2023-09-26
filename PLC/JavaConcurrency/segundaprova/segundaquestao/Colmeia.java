package segundaprova.segundaquestao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Colmeia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite número de operários e tarefas:");
        int O = scan.nextInt(); // numero de Operarios
        int N = scan.nextInt(); // numero de tarefas

        List<Tarefa> tasks = new ArrayList<>();
        scan.nextLine();

        for (int i = 0; i < N; i++) {
            String[] taskInfo = scan.nextLine().split(" ");
            int id = Integer.parseInt(taskInfo[0]);
            int duration = Integer.parseInt(taskInfo[1]);
            List<Integer> dependencias = new ArrayList<>();
            for (int j = 2; j < taskInfo.length; j++) {
                dependencias.add(Integer.parseInt(taskInfo[j]));
            }
            tasks.add(new Tarefa(id, duration, dependencias));
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(O);

        Map<Integer, Integer> taskDependencies = new HashMap<>();
        
        for (Tarefa task : tasks) {
            taskDependencies.put(task.id, task.dependencias.size());
        }

        while (!tasks.isEmpty()) {
            List<Tarefa> readyTasks = new ArrayList<>();

            for (Tarefa task : tasks) {
                if (taskDependencies.get(task.id) == 0) {
                    readyTasks.add(task);
                }
            }

            for (Tarefa task : readyTasks) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(task.duration);
                        System.out.println("tarefa " + task.id + " feita");
                        for (Tarefa t : tasks) {
                            t.dependencias.remove(Integer.valueOf(task.id));
                            taskDependencies.put(t.id, t.dependencias.size());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                tasks.remove(task);
            }
        }

        executor.shutdown();
        scan.close();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }    
}

class Tarefa {
    int id;
    int duration;
    List<Integer> dependencias;

    public Tarefa (int id, int duration, List<Integer> dependencias) {
        this.id = id;
        this.duration = duration;
        this.dependencias = dependencias;
    }

}