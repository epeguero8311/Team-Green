import java.util.*;

public class RegionRegressionAnalysis {
    public static void analyze(StoreRecords store) {
        ArrayList<InsuranceRecord> allRecords = store.getRecords();
        
        ArrayList<Double> regionCodes = new ArrayList<>();
        ArrayList<Double> chargeValues = new ArrayList<>();
        
        for (InsuranceRecord record : allRecords) {
            double code = getRegionCode(record.region);
            regionCodes.add(code);
            chargeValues.add(record.charges);
        }
        
        int n = regionCodes.size();
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;
        
        for (int i = 0; i < n; i++) {
            double x = regionCodes.get(i);
            double y = chargeValues.get(i);
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
            sumY2 += y * y;
        }
        
        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;
        
        double numerator = n * sumXY - sumX * sumY;
        double denominator = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));
        double r = numerator / denominator;
        
        System.out.println("Linear Regression: Charges vs Region");
        System.out.println("Region encoding: northeast=1, northwest=2, southeast=3, southwest=4");
        System.out.printf("Regression equation: y = %.2fx + %.2f\n", slope, intercept);
        System.out.printf("Pearson Correlation Coefficient (r): %.4f\n\n", r);
        
        String[] regions = {"northeast", "northwest", "southeast", "southwest"};
        
        System.out.println("Predictions for 33 region values:");
        System.out.println("Region (x)\t\tCode\tPredicted Charges (y)");
        System.out.println("----------\t\t----\t---------------------");
        
        for (int i = 0; i < 33; i++) {
            String region = regions[i % 4];
            double code = getRegionCode(region);
            double predictedCharge = slope * code + intercept;
            System.out.printf("%-12s\t%.0f\t$%.2f\n", region, code, predictedCharge);
        }
    }
    
    private static double getRegionCode(String region) {
        switch (region.toLowerCase()) {
            case "northeast": return 1.0;
            case "northwest": return 2.0;
            case "southeast": return 3.0;
            case "southwest": return 4.0;
            default: return 0.0;
        }
    }
}