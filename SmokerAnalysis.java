import java.util.*;

public class SmokerAnalysis {
    public static void main(String[] args) {
        StoreRecords store = new StoreRecords();
        store.read_csv("insurance.csv");
        
        ArrayList<InsuranceRecord> allRecords = store.getRecords();
        
        ArrayList<Double> southSmokerCharges = new ArrayList<>();
        ArrayList<Double> otherSmokerCharges = new ArrayList<>();
        
        for (InsuranceRecord record : allRecords) {
            if (record.smoker) {
                if (record.region.equalsIgnoreCase("south")) {
                    southSmokerCharges.add(record.charges);
                } else {
                    otherSmokerCharges.add(record.charges);
                }
            }
        }
        
        double southMean = Calculations.mean(southSmokerCharges);
        double otherMean = Calculations.mean(otherSmokerCharges);
        
        double percentageIncrease = ((southMean - otherMean) / otherMean) * 100;
        
        System.out.println("South smokers mean charge: $" + String.format("%.2f", southMean));
        System.out.println("Other smokers mean charge: $" + String.format("%.2f", otherMean));
        System.out.println("Percentage increase: " + String.format("%.2f", percentageIncrease) + "%");
        
        if (percentageIncrease >= 25) {
            System.out.println("\nYes, smokers in the south are charged at least 25% more than other smokers.");
        } else {
            System.out.println("\nNo, smokers in the south are NOT charged at least 25% more than other smokers.");
        }
    }
}