package Day4_Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DeliveryManager {

    public void processOrder(
            String orderId,
            String customer) throws InterruptedException {

        System.out.println(
                "[" + orderId + "] Order received for "
                        + customer
        );

        // Simulate order validation
        Thread.sleep(500);

        System.out.println(
                "[" + orderId + "] Order validated."
        );

        // Simulate food preparation
        Thread.sleep(1000);

        System.out.println(
                "[" + orderId + "] Food prepared."
        );

        // Simulate delivery assignment
        Thread.sleep(500);

        System.out.println(
                "[" + orderId + "] Delivery partner assigned."
        );

        System.out.println(
                "[" + orderId + "] Order completed."
        );
    }
}

class FoodOrder implements Runnable {

    private String orderId;
    private String customer;
    private DeliveryManager manager;

    public FoodOrder(
            String orderId,
            String customer,
            DeliveryManager manager) {

        this.orderId = orderId;
        this.customer = customer;
        this.manager = manager;
    }

    @Override
    public void run() {

        try {

            System.out.println(
                    "[" + orderId + "] Processing on "
                            + Thread.currentThread().getName()
            );

            manager.processOrder(
                    orderId,
                    customer
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "[" + orderId
                            + "] Processing interrupted."
            );

        } catch (Exception e) {

            System.out.println(
                    "[" + orderId
                            + "] Order failed: "
                            + e.getMessage()
            );
        }
    }
}

public class FoodDeliveryProcessor {

    public static void main(String[] args) {

        DeliveryManager manager =
                new DeliveryManager();

        // Create thread pool with 4 threads
        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        // Submit food orders
        executor.submit(
                new FoodOrder(
                        "ORD-101",
                        "Rahul",
                        manager
                )
        );

        executor.submit(
                new FoodOrder(
                        "ORD-102",
                        "Priya",
                        manager
                )
        );

        executor.submit(
                new FoodOrder(
                        "ORD-103",
                        "Arun",
                        manager
                )
        );

        executor.submit(
                new FoodOrder(
                        "ORD-104",
                        "Sneha",
                        manager
                )
        );

        // Stop accepting new tasks
        executor.shutdown();

        System.out.println(
                "Food delivery system started..."
        );
    }
}