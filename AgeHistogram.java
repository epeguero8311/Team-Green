import java.lang.reflect.Array;
import java.util.*;

public class AgeHistogram {
    private ArrayList<InsuranceRecord> records;

    public AgeHistogram(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public void print_histogram() {
        HashMap<Integer, Integer> age_counts = new HashMap<>();
        for (InsuranceRecord record : records) {
            age_counts.put(record.age, age_counts.getOrDefault(record.age, 0) + 1);
    }

        for(int age : age_counts.keySet()) {
            System.out.printf("%2d: ", age);
            for(int i = 0; i < age_counts.get(age); i++) {
                System.out.print("*");
            }
            System.out.println();
        }

    //int[] age_groups = new int[10]; // 0-9, 10-19, ..., 90-99

        // for (InsuranceRecord record : records) {
        //     int age = record.age;
        //     if (age >= 0 && age < 100) {
        //         age_groups[age / 10]++;
        //     }
        // }

        // for (int i = 0; i < age_groups.length; i++) {
        //     int lower_bound = i * 10;
        //     int upper_bound = lower_bound + 9;
        //     System.out.printf("%2d-%2d: ", lower_bound, upper_bound);
        //     for (int j = 0; j < age_groups[i]; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
    }
}
