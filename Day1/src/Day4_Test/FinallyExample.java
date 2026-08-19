package Day4_Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FinallyExample {

    public static void main(String[] args) {

        Scanner fileScanner = null;

        try {
            File file = new File("src/Day4_Test/data.txt");

            // Check where Java is actually looking
            System.out.println("Looking for file at:");
            System.out.println(file.getAbsolutePath());

            fileScanner = new Scanner(file);

            System.out.println("\nFile Content:");

            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found!");
            System.out.println("Error: " + e.getMessage());

        } finally {

            if (fileScanner != null) {
                fileScanner.close();
                System.out.println("\nFile resource closed.");
            }

            System.out.println("Finally block executed.");
        }
    }
}