import java.util.*;

public class FitnessApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ActivityManager manager = new ActivityManager();
        FileManager fileManager = new FileManager();

        // Load old data
        manager.getActivities().addAll(fileManager.loadFromFile());

        // Start motivation thread
        MotivationThread mt = new MotivationThread();
        mt.start();

        while (true) {
            System.out.println("\n===== FITNESS TRACKER =====");
            System.out.println("1. Add Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Show Weekly Progress");
            System.out.println("4. Save & Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter date (DD-MM-YYYY): ");
                        String date = sc.nextLine();

                        System.out.print("Enter workout type: ");
                        String type = sc.nextLine();

                        System.out.print("Enter duration (minutes): ");
                        int duration = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter calories burned: ");
                        double calories = Double.parseDouble(sc.nextLine());

                        if (duration <= 0 || calories <= 0) {
                            throw new Exception("Values must be positive!");
                        }

                        manager.addActivity(new Activity(date, type, duration, calories));
                        System.out.println("Activity added!");

                    } catch (Exception e) {
                        System.out.println("Error adding activity: " + e.getMessage());
                    }
                    break;

                case 2:
                    manager.showAllActivities();
                    break;

                case 3:
                    manager.showWeeklyProgress();
                    break;

                case 4:
                    fileManager.saveToFile(manager.getActivities());
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
