import java.util.*;

public class BMIByRegion {
    public static void analyze(StoreRecords store) {
        ArrayList<InsuranceRecord> allRecords = store.getRecords();
        
        System.out.println("Testing BMI cutoffs to find where southerners have higher BMI rates:\n");
        
        for (int cutoffBMI = 20; cutoffBMI <= 40; cutoffBMI++) {
            int southTotal = 0;
            int southHighBMI = 0;
            int northTotal = 0;
            int northHighBMI = 0;
            
            for (InsuranceRecord record : allRecords) {
                if (record.region.equalsIgnoreCase("south")) {
                    southTotal++;
                    if (record.bmi >= cutoffBMI) southHighBMI++;
                } else if (record.region.equalsIgnoreCase("north")) {
                    northTotal++;
                    if (record.bmi >= cutoffBMI) northHighBMI++;
                }
            }
            
            double southRate = (southTotal > 0) ? (southHighBMI * 100.0 / southTotal) : 0;
            double northRate = (northTotal > 0) ? (northHighBMI * 100.0 / northTotal) : 0;
            
            if (southRate > northRate) {
                System.out.printf("BMI %d: South (>=%d) = %.2f%%, North (>=%d) = %.2f%% ✓\n", 
                    cutoffBMI, cutoffBMI, southRate, cutoffBMI, northRate);
            }
        }
    }
}