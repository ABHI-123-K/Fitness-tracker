import java.io.*;
import java.util.*;

public class FileManager {

    private static final String FILE_NAME = "fitness_logs.txt";

    public void saveToFile(ArrayList<Activity> activities) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Activity a : activities) {
                bw.write(a.toString());
                bw.newLine();
            }
            bw.close();

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public ArrayList<Activity> loadFromFile() {
        ArrayList<Activity> list = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return list;

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");

                String date = parts[0];
                String type = parts[1];
                int duration = Integer.parseInt(parts[2]);
                double calories = Double.parseDouble(parts[3]);

                list.add(new Activity(date, type, duration, calories));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

        return list;
    }
}
