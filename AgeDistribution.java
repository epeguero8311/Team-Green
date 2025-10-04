//Task 14
import java.util.*;

public class AgeDistribution {
    public static void analyze(StoreRecords store) {
        ArrayList<InsuranceRecord> allRecords = store.getRecords();
        
        ArrayList<Integer> smokerAges = new ArrayList<>();
        
        for (InsuranceRecord record : allRecords) {
            if (record.smoker) {
                smokerAges.add(record.age);
            }
        }
        
        Map<String, Integer> histogram = new LinkedHashMap<>();
        histogram.put("18-25", 0);
        histogram.put("26-35", 0);
        histogram.put("36-45", 0);
        histogram.put("46-55", 0);
        histogram.put("56-65", 0);
        
        for (int age : smokerAges) {
            if (age >= 18 && age <= 25) {
                histogram.put("18-25", histogram.get("18-25") + 1);
            } else if (age >= 26 && age <= 35) {
                histogram.put("26-35", histogram.get("26-35") + 1);
            } else if (age >= 36 && age <= 45) {
                histogram.put("36-45", histogram.get("36-45") + 1);
            } else if (age >= 46 && age <= 55) {
                histogram.put("46-55", histogram.get("46-55") + 1);
            } else if (age >= 56 && age <= 65) {
                histogram.put("56-65", histogram.get("56-65") + 1);
            }
        }
        
        System.out.println("Age Distribution for Smokers:");
        System.out.println("Total smokers: " + smokerAges.size());
        System.out.println();
        
        for (Map.Entry<String, Integer> entry : histogram.entrySet()) {
            String bar = "*".repeat(entry.getValue());
            System.out.printf("%-8s (%3d): %s\n", entry.getKey(), entry.getValue(), bar);
        }
    }
}