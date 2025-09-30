import java.util.*;

public class Calculations {
    
    public static int count(ArrayList<InsuranceRecord> records) {
        return records.size();
    }
    
    public static double mean(ArrayList<Double> values) {
        if (values.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }
    
    public static double standardDeviation(ArrayList<Double> values) {
        if (values.size() < 2) return 0.0;
        double mean = mean(values);
        double sumSquaredDiff = 0.0;
        for (double value : values) {
            sumSquaredDiff += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sumSquaredDiff / (values.size() - 1));
    }
    
    public static double min(ArrayList<Double> values) {
        if (values.isEmpty()) return 0.0;
        double minimum = values.get(0);
        for (double value : values) {
            if (value < minimum) {
                minimum = value;
            }
        }
        return minimum;
    }
    
    public static double max(ArrayList<Double> values) {
        if (values.isEmpty()) return 0.0;
        double maximum = values.get(0);
        for (double value : values) {
            if (value > maximum) {
                maximum = value;
            }
        }
        return maximum;
    }
    
    public static double percentile(ArrayList<Double> values, double percentile) {
        if (values.isEmpty()) return 0.0;
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);
        
        double index = (percentile / 100.0) * (sorted.size() - 1);
        int lowerIndex = (int) Math.floor(index);
        int upperIndex = (int) Math.ceil(index);
        
        if (lowerIndex == upperIndex) {
            return sorted.get(lowerIndex);
        }
        
        double lowerValue = sorted.get(lowerIndex);
        double upperValue = sorted.get(upperIndex);
        double fraction = index - lowerIndex;
        
        return lowerValue + (upperValue - lowerValue) * fraction;
    }
    
    public static ArrayList<Double> extractAges(ArrayList<InsuranceRecord> records) {
        ArrayList<Double> ages = new ArrayList<>();
        for (InsuranceRecord record : records) {
            ages.add((double) record.age);
        }
        return ages;
    }
    
    public static ArrayList<Double> extractBMI(ArrayList<InsuranceRecord> records) {
        ArrayList<Double> bmis = new ArrayList<>();
        for (InsuranceRecord record : records) {
            bmis.add(record.bmi);
        }
        return bmis;
    }
    
    public static ArrayList<Double> extractChildren(ArrayList<InsuranceRecord> records) {
        ArrayList<Double> children = new ArrayList<>();
        for (InsuranceRecord record : records) {
            children.add((double) record.children);
        }
        return children;
    }
    
    public static ArrayList<Double> extractCharges(ArrayList<InsuranceRecord> records) {
        ArrayList<Double> charges = new ArrayList<>();
        for (InsuranceRecord record : records) {
            charges.add(record.charges);
        }
        return charges;
    }
    
    public static Map<String, Double> getStatistics(ArrayList<Double> values) {
        Map<String, Double> stats = new LinkedHashMap<>();
        stats.put("count", (double) values.size());
        stats.put("mean", mean(values));
        stats.put("std", standardDeviation(values));
        stats.put("min", min(values));
        stats.put("25%", percentile(values, 25));
        stats.put("50%", percentile(values, 50));
        stats.put("75%", percentile(values, 75));
        stats.put("max", max(values));
        return stats;
    }
    
    public static void printStatistics(String attribute, Map<String, Double> stats) {
        System.out.println("\nStatistics for " + attribute + ":");
        System.out.printf("Count: %.0f\n", stats.get("count"));
        System.out.printf("Mean: %.2f\n", stats.get("mean"));
        System.out.printf("Std: %.2f\n", stats.get("std"));
        System.out.printf("Min: %.2f\n", stats.get("min"));
        System.out.printf("25%%: %.2f\n", stats.get("25%"));
        System.out.printf("50%%: %.2f\n", stats.get("50%"));
        System.out.printf("75%%: %.2f\n", stats.get("75%"));
        System.out.printf("Max: %.2f\n", stats.get("max"));
    }
    
    public static void calculateAllStatistics(StoreRecords store) {
        ArrayList<InsuranceRecord> records = store.getRecords();
        
        Map<String, Double> ageStats = getStatistics(extractAges(records));
        printStatistics("Age", ageStats);
        
        Map<String, Double> bmiStats = getStatistics(extractBMI(records));
        printStatistics("BMI", bmiStats);
        
        Map<String, Double> childrenStats = getStatistics(extractChildren(records));
        printStatistics("Children", childrenStats);
        
        Map<String, Double> chargesStats = getStatistics(extractCharges(records));
        printStatistics("Charges", chargesStats);
    }
    
    public static void main(String[] args) {
        StoreRecords store = new StoreRecords();
        store.read_csv("insurance.csv");
        
        calculateAllStatistics(store);
    }
}