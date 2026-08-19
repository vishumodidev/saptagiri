package Day4_Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

    public static void main(String[] args) {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("src/Day4_Test/data.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {

            System.out.println(
                    "File error: " + e.getMessage()
            );
        }

        System.out.println(
                "Resource automatically closed."
        );
    }
}