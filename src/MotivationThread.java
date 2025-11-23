public class MotivationThread extends Thread {

    private String[] quotes = {
            "Keep going! Progress is progress.",
            "One workout at a time!",
            "Believe in yourself!",
            "Don’t stop when you’re tired, stop when you're done."
    };

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                System.out.println("\n[MOTIVATION] " + quotes[i % quotes.length]);
                Thread.sleep(30000);  // 30 seconds
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println("Motivation thread stopped.");
        }
    }
}
