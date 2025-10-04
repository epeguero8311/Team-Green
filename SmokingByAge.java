//Task 16
import java.util.*;

public class SmokingByAge {
    public static void analyze(StoreRecords store) {
        ArrayList<InsuranceRecord> allRecords = store.getRecords();
        
        System.out.println("Testing age cutoffs to find where younger people smoke more:\n");
        
        for (int cutoffAge = 20; cutoffAge <= 60; cutoffAge++) {
            int youngerTotal = 0;
            int youngerSmokers = 0;
            int olderTotal = 0;
            int olderSmokers = 0;
            
            for (InsuranceRecord record : allRecords) {
                if (record.age < cutoffAge) {
                    youngerTotal++;
                    if (record.smoker) youngerSmokers++;
                } else {
                    olderTotal++;
                    if (record.smoker) olderSmokers++;
                }
            }
            
            double youngerRate = (youngerTotal > 0) ? (youngerSmokers * 100.0 / youngerTotal) : 0;
            double olderRate = (olderTotal > 0) ? (olderSmokers * 100.0 / olderTotal) : 0;
            
            if (youngerRate > olderRate) {
                System.out.printf("Age %d: Younger (<%d) = %.2f%%, Older (>=%d) = %.2f%% ✓\n", 
                    cutoffAge, cutoffAge, youngerRate, cutoffAge, olderRate);
            }
        }
    }
}