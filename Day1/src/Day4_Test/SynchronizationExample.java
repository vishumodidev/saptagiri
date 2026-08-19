package Day4_Test;

class BankAccount {

    private int balance = 1000;

    // Only one thread can execute this method at a time
    public synchronized void withdraw(int amount) {

        if (balance >= amount) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " withdrawing ₹" + amount
            );

            // Simulate processing time
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            balance -= amount;

            System.out.println(
                    "Remaining balance: ₹" + balance
            );

        } else {

            System.out.println(
                    Thread.currentThread().getName()
                            + ": Insufficient balance."
            );
        }
    }
}

public class SynchronizationExample {

    public static void main(String[] args)
            throws InterruptedException {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(
                () -> account.withdraw(700),
                "User-1"
        );

        Thread t2 = new Thread(
                () -> account.withdraw(700),
                "User-2"
        );

        t1.start();
        t2.start();

        // Wait for both threads to complete
        t1.join();
        t2.join();

        System.out.println("Bank transaction processing completed.");
    }
}