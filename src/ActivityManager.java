import java.util.ArrayList;

public class ActivityManager {

    private ArrayList<Activity> activities = new ArrayList<>();

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void showAllActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities recorded yet.");
            return;
        }

        System.out.println("\n------ ALL ACTIVITIES ------");
        for (Activity a : activities) {
            System.out.println(a);
        }
    }

    public void showWeeklyProgress() {
        if (activities.isEmpty()) {
            System.out.println("No data to analyze.");
            return;
        }

        int totalDuration = 0;
        double totalCalories = 0;

        for (Activity a : activities) {
            totalDuration += a.getDuration();
            totalCalories += a.getCalories();
        }

        double avgWorkout = totalDuration * 1.0 / activities.size();

        System.out.println("\n------ WEEKLY PROGRESS ------");
        System.out.println("Total Duration: " + totalDuration + " minutes");
        System.out.println("Total Calories: " + totalCalories);
        System.out.println("Average Workout Duration: " + avgWorkout + " minutes");
    }
}
