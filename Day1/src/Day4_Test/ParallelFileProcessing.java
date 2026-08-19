package Day4_Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelFileProcessing {

    static void processFile(String fileName) {

        try {
            // Open the file
            Path path = Path.of(fileName);

            // Read complete file content
            String content = Files.readString(path);

            // Count words
            int wordCount =
                    content.trim().isEmpty()
                            ? 0
                            : content.trim()
                            .split("\\s+").length;

            System.out.println(
                    Thread.currentThread().getName()
                            + " processed "
                            + fileName
                            + " → "
                            + wordCount
                            + " words"
            );

        } catch (IOException e) {

            System.out.println(
                    "Unable to process "
                            + fileName
                            + ": "
                            + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        String[] files = {
                "file1.txt",
                "file2.txt",
                "file3.txt",
                "file4.txt"
        };

        // Create a thread pool with 3 threads
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // Submit each file as a separate task
        for (String file : files) {

            executor.submit(() ->
                    processFile(file));
        }

        // Stop accepting new tasks
        executor.shutdown();

        System.out.println(
                "All file-processing tasks submitted."
        );
    }
}