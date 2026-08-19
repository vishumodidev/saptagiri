package Day4_Test;

class Account {

    private int id;
    private int balance;

    // Constructor
    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    // Get account ID
    public int getId() {
        return id;
    }

    // Get balance
    public int getBalance() {
        return balance;
    }

    // Withdraw money
    public void withdraw(int amount) {
        balance -= amount;
    }

    // Deposit money
    public void deposit(int amount) {
        balance += amount;
    }
}

class Bank {

    public void transfer(
            Account from,
            Account to,
            int amount) {

        // Always lock accounts in the same order
        // to prevent deadlock
        Account first =
                from.getId() < to.getId() ? from : to;

        Account second =
                from.getId() < to.getId() ? to : from;

        synchronized (first) {

            synchronized (second) {

                if (from.getBalance() >= amount) {

                    from.withdraw(amount);
                    to.deposit(amount);

                    System.out.println(
                            "Transferred ₹" + amount
                                    + " from Account "
                                    + from.getId()
                                    + " to Account "
                                    + to.getId()
                    );

                } else {

                    System.out.println(
                            "Insufficient balance."
                    );
                }
            }
        }
    }
}

public class BankTransferExample {

    public static void main(String[] args)
            throws InterruptedException {

        Account account1 =
                new Account(1, 10000);

        Account account2 =
                new Account(2, 5000);

        Bank bank = new Bank();

        // Transfer from Account 1 → Account 2
        Thread t1 = new Thread(() ->
                bank.transfer(
                        account1,
                        account2,
                        2000
                ),
                "Transfer-1"
        );

        // Transfer from Account 2 → Account 1
        Thread t2 = new Thread(() ->
                bank.transfer(
                        account2,
                        account1,
                        1000
                ),
                "Transfer-2"
        );

        t1.start();
        t2.start();

        // Wait for both transfers to finish
        t1.join();
        t2.join();

        System.out.println(
                "Account 1 Balance: ₹"
                        + account1.getBalance()
        );

        System.out.println(
                "Account 2 Balance: ₹"
                        + account2.getBalance()
        );
    }
}