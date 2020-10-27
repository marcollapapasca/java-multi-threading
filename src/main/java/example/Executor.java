package example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {

    public static void main(String[] args) {
        try {
            int MAX_THREAD = 4;
            int TASK_NUM = 0;
            String[] PROCESS_NAME = {"Process-1", "Process-2", "Process-3", "Process-4", "Process-5", "Process-6"};

            System.out.println("Initialization - Parallel Processing");
            System.out.println("====================================");

            ExecutorService pool = Executors.newFixedThreadPool(MAX_THREAD);

            for (String processName : PROCESS_NAME) {
                TASK_NUM++;
                String taskName = String.format("Task-%s | %s", TASK_NUM, processName);
                Runnable runnable = new TaskExample(taskName);
                pool.execute(runnable);
            }
            pool.shutdown();
            boolean isWait = true;
            while (isWait) {
                try {
                    isWait = !pool.awaitTermination(10, TimeUnit.SECONDS);
                    if (isWait) {
                        System.out.println("Awaiting completion of bulk callback threads.");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interruped while awaiting completion of callback threads - trying again...");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("====================================");
            System.out.println("Finalize - Parallel Processing");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
