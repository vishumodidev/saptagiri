package Day4_Test;
import java.io.FileReader;
import java.io.IOException;

public class CheckedUncheckedExample {

    public static void main(String[] args) {

        // Checked Exception
        try {
            FileReader reader = new FileReader("src/Day4_Test/data.txt");
            reader.close();

        } catch (IOException e) {
            System.out.println("Checked exception: File problem.");
        }

        // Unchecked Exception
        try {
            int result = 10 / 0;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("Unchecked exception: Division by zero.");
        }
    }
}
