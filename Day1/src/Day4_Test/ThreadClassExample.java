package Day4_Test;

class DownloadThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    "Downloading file... " + (i * 20) + "%"
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Download interrupted.");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Download completed!");
    }
}

public class ThreadClassExample {

    public static void main(String[] args) {

        DownloadThread thread = new DownloadThread();

        // Start the new thread
        thread.start();

        System.out.println("Main thread continues...");
    }
}