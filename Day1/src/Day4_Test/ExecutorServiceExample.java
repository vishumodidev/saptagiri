package Day4_Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        // Create a thread pool with 3 threads
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // Submit 10 tasks
        for (int i = 1; i <= 10; i++) {

            int taskId = i;

            executor.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " processing Task "
                                + taskId
                );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    System.out.println(
                            "Task " + taskId + " interrupted."
                    );

                    Thread.currentThread().interrupt();
                }
            });
        }

        // Stop accepting new tasks
        executor.shutdown();

        System.out.println("Tasks submitted.");
    }
}