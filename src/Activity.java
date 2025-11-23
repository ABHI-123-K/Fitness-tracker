public class Activity {
    private String date;
    private String workoutType;
    private int duration;        // in minutes
    private double calories;     // calories burned

    public Activity(String date, String workoutType, int duration, double calories) {
        this.date = date;
        this.workoutType = workoutType;
        this.duration = duration;
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public int getDuration() {
        return duration;
    }

    public double getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return date + ", " + workoutType + ", " + duration + ", " + calories;
    }
}
