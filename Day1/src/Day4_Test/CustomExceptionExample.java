    package Day4_Test;

    import java.util.Scanner;

    class InsufficientBalanceException extends Exception {

        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    public class CustomExceptionExample {

        static void withdraw(double balance, double amount)
                throws InsufficientBalanceException {

            if (amount > balance) {

                throw new InsufficientBalanceException(
                        "Insufficient balance. Available: ₹" + balance
                );
            }

            System.out.println("Withdrawal successful.");
            System.out.println(
                    "Remaining balance: ₹" + (balance - amount)
            );
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter account balance: ₹");
            double balance = scanner.nextDouble();

            System.out.print("Enter withdrawal amount: ₹");
            double withdrawalAmount = scanner.nextDouble();

            try {

                withdraw(balance, withdrawalAmount);

            } catch (InsufficientBalanceException e) {

                System.out.println("Transaction failed.");
                System.out.println(e.getMessage());
            }

            scanner.close();
        }
    }