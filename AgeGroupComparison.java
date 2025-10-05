// Task 8
import java.util.*;

public class AgeGroupComparison {
    
    public static void compareAgeGroupCharges(StoreRecords store) {
        ArrayList<InsuranceRecord> records = store.records;
        
        ArrayList<Double> seniorCharges = new ArrayList<>();
        for (InsuranceRecord record : records) {
            if (record.age >= 50) {
                seniorCharges.add(record.charges);
            }
        }
        
        ArrayList<Double> youngCharges = new ArrayList<>();
        for (InsuranceRecord record : records) {
            if (record.age <= 20) {
                youngCharges.add(record.charges);
            }
        }
        
        double seniorAvg = Calculations.mean(seniorCharges);
        double youngAvg = Calculations.mean(youngCharges);
        double ratio = seniorAvg / youngAvg;
        
        System.out.println("\n=== Age Group Charge Comparison ===");
        System.out.printf("People 50 or older - Count: %d, Average Charges: $%.2f\n", 
                          seniorCharges.size(), seniorAvg);
        System.out.printf("People 20 or younger - Count: %d, Average Charges: $%.2f\n", 
                          youngCharges.size(), youngAvg);
        System.out.printf("\nRatio (50+/20-): %.2fx\n", ratio);
        
        if (ratio >= 2.0) {
            System.out.println("TRUE: People 50+ average at least twice the charges of people 20 or younger.");
        } else {
            System.out.println("FALSE: People 50+ do NOT average twice the charges of people 20 or younger.");
        }
    }
}