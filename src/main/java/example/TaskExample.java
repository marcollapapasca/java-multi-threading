package example;

public class TaskExample implements Runnable {

    private final String TASK_NAME;

    public TaskExample(String taskName) {
        TASK_NAME = taskName;
    }

    public void run() {
        try {

            System.out.println(String.format("Initialization %s > time %s", TASK_NAME, Utils.getDateTime()));

            Thread.sleep(5000);

            System.out.println(String.format("Finalize %s < time %s", TASK_NAME, Utils.getDateTime()));

        } catch (Exception ex) {
            System.out.println(TASK_NAME + " " + ex.getMessage());
        }
    }
}

