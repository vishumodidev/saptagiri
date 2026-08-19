package Day4_Test;

public class RunnableExample {

    public static void main(String[] args) {

        // Create a task using Runnable
        Runnable task = () -> {

            for (int i = 1; i <= 5; i++) {

                System.out.println(
                        "Processing order " + i
                );

                try {
                    Thread.sleep(500);

                } catch (InterruptedException e) {

                    System.out.println(
                            "Order processing interrupted."
                    );

                    Thread.currentThread().interrupt();
                }
            }
        };

        // Create a Thread and pass the Runnable task
        Thread worker = new Thread(task);

        // Start the thread
        worker.start();

        System.out.println("Main thread is running...");
    }
}