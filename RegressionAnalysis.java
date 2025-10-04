import java.util.*;

public class RegressionAnalysis {
    public static void analyze(StoreRecords store) {
        ArrayList<InsuranceRecord> allRecords = store.getRecords();
        
        ArrayList<Double> bmiValues = new ArrayList<>();
        ArrayList<Double> chargeValues = new ArrayList<>();
        
        for (InsuranceRecord record : allRecords) {
            bmiValues.add(record.bmi);
            chargeValues.add(record.charges);
        }
        
        int n = bmiValues.size();
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;
        
        for (int i = 0; i < n; i++) {
            double x = bmiValues.get(i);
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
        
        System.out.println("Linear Regression: Charges vs BMI");
        System.out.printf("Regression equation: y = %.2fx + %.2f\n", slope, intercept);
        System.out.printf("Pearson Correlation Coefficient (r): %.4f\n\n", r);
        
        double[] testBMI = {15.0, 17.5, 22.0, 27.5, 31.0, 34.5, 37.0, 41.5, 44.0, 48.5, 52.0};
        
        System.out.println("Predictions for new BMI values:");
        System.out.println("BMI (x)\t\tPredicted Charges (y)");
        System.out.println("-------\t\t---------------------");
        
        for (double bmi : testBMI) {
            double predictedCharge = slope * bmi + intercept;
            System.out.printf("%.1f\t\t$%.2f\n", bmi, predictedCharge);
        }
    }
}