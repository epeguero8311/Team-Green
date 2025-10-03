import java.util.*;
public class Task7 {
    private ArrayList<InsuranceRecord> records;

    public Task7(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public boolean is_data_fair() {
        Map<String, Integer> regionCounts = new HashMap<>();
        for (InsuranceRecord record : records) {
            regionCounts.put(record.region, regionCounts.getOrDefault(record.region, 0) + 1);
        }

        int total = records.size();
        double expected = (double) total / regionCounts.size();

        for (int count : regionCounts.values()) {
            double diffPercent = Math.abs(count - expected) / expected * 100.0;
            if (diffPercent > 5.0) {
                return false;
            }
        }
        return true;
    }

    public void print_fairness() {
        if (is_data_fair()) {
            System.out.println("The data is fair.");
        } else {
            System.out.println("The data is not fair.");
        }
    }
}
