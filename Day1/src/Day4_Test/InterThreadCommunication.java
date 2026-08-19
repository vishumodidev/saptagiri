package Day4_Test;

class SharedData {

    private int value;
    private boolean available = false;

    // Producer
    public synchronized void produce(int value)
            throws InterruptedException {

        // Wait if data is already available
        while (available) {
            wait();
        }

        this.value = value;
        available = true;

        System.out.println("Produced: " + value);

        // Inform the consumer
        notify();
    }

    // Consumer
    public synchronized void consume()
            throws InterruptedException {

        // Wait until data is available
        while (!available) {
            wait();
        }

        System.out.println("Consumed: " + value);

        available = false;

        // Inform the producer
        notify();
    }
}

public class InterThreadCommunication {

    public static void main(String[] args) {

        SharedData data = new SharedData();

        // Producer Thread
        Thread producer = new Thread(() -> {

            try {

                for (int i = 1; i <= 5; i++) {
                    data.produce(i);
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }, "Producer");

        // Consumer Thread
        Thread consumer = new Thread(() -> {

            try {

                for (int i = 1; i <= 5; i++) {
                    data.consume();
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}