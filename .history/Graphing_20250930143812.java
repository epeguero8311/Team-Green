import java.util.*;

public class Graphing {
    
    public static void verticalHistogram(ArrayList<Double> values, String title, int numBins) {
        if (values.isEmpty()) {
            System.out.println("No data to display.");
            return;
        }
        
        double minValue = Collections.min(values);
        double maxValue = Collections.max(values);
        double binWidth = (maxValue - minValue) / numBins;
        
        int[] bins = new int[numBins];
        
        for (double value : values) {
            int binIndex = (int) ((value - minValue) / binWidth);
            if (binIndex >= numBins) {
                binIndex = numBins - 1;
            }
            bins[binIndex]++;
        }
        
        int maxCount = 0;
        for (int count : bins) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        System.out.println("\n" + title);
        System.out.println("Total Records: " + values.size());
        System.out.println();
        
        int height = Math.min(maxCount, 20);
        double scale = (double) maxCount / height;
        
        for (int level = height; level > 0; level--) {
            int threshold = (int) (level * scale);
            System.out.printf("%4d | ", threshold);
            
            for (int i = 0; i < numBins; i++) {
                if (bins[i] >= threshold) {
                    System.out.print(" ### ");
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println();
        }
        
        System.out.print("     +");
        for (int i = 0; i < numBins; i++) {
            System.out.print("-----");
        }
        System.out.println();
        
        System.out.print("       ");
        for (int i = 0; i < numBins; i++) {
            double binStart = minValue + (i * binWidth);
            System.out.printf("%-5.1f", binStart);
        }
        System.out.println();
    }
    
    public static ArrayList<Double> filterBMIBySmokerStatus(ArrayList<InsuranceRecord> records, boolean smokerStatus) {
        ArrayList<Double> filteredBMI = new ArrayList<>();
        for (InsuranceRecord record : records) {
            if (record.smoker == smokerStatus) {
                filteredBMI.add(record.bmi);
            }
        }
        return filteredBMI;
    }
    
    public static ArrayList<Double> extractAllBMI(ArrayList<InsuranceRecord> records) {
        ArrayList<Double> bmis = new ArrayList<>();
        for (InsuranceRecord record : records) {
            bmis.add(record.bmi);
        }
        return bmis;
    }
    
    public static void displayBMIHistograms(StoreRecords store) {
        ArrayList<InsuranceRecord> records = store.getRecords();
        
        ArrayList<Double> allBMI = extractAllBMI(records);
        verticalHistogram(allBMI, "BMI Distribution - All Records", 10);
        
        ArrayList<Double> smokerBMI = filterBMIBySmokerStatus(records, true);
        verticalHistogram(smokerBMI, "BMI Distribution - Smokers", 10);
        
        ArrayList<Double> nonSmokerBMI = filterBMIBySmokerStatus(records, false);
        verticalHistogram(nonSmokerBMI, "BMI Distribution - Non-Smokers", 10);
    }
    
    public static void main(String[] args) {
        StoreRecords store = new StoreRecords();
        store.read_csv("insurance.csv");
        
        displayBMIHistograms(store);
    }
}