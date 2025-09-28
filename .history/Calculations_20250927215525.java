import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculations {

    public static void main(String[] args) {
        readCSV("insurance.csv");
    }

    public static void readCSV(String filename) {
        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<Double> bmis = new ArrayList<>();
        ArrayList<Integer> children = new ArrayList<>();
        ArrayList<Double> charges = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            // Skip the header row
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");

                int age = Integer.parseInt(parts[0].trim());
                double bmi = Double.parseDouble(parts[2].trim());
                int child = Integer.parseInt(parts[3].trim());
                double charge = Double.parseDouble(parts[6].trim());

                ages.add(age);
                bmis.add(bmi);
                children.add(child);
                charges.add(charge);
            }

            sc.close();

            // Print stats for each attribute
            printStats("Age", ages);
            printStats("BMI", bmis);
            printStats("Children", children);
            printStats("Charges", charges);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }
    }

    // Overload printStats for Integer and Double
    public static void printStats(String name, ArrayList<? extends Number> data) {
        int count = data.size();
        double mean = calculateMean(data);
        double std = calculateStd(data, mean);
        double min = Collections.min(toDoubleList(data));
        double max = Collections.max(toDoubleList(data));
        ArrayList<Double> sorted = toDoubleList(data);
        Collections.sort(sorted);

        double p25 = calculatePercentile(sorted, 25);
        double p50 = calculatePercentile(sorted, 50);
        double p75 = calculatePercentile(sorted, 75);

        System.out.println("---- " + name + " ----");
        System.out.println("Count: " + count);
        System.out.println("Mean: " + mean);
        System.out.println("Std: " + std);
        System.out.println("Min: " + min);
        System.out.println("25%: " + p25);
        System.out.println("50%: " + p50);
        System.out.println("75%: " + p75);
        System.out.println("Max: " + max);
        System.out.println();
    }

    public static double calculateMean(ArrayList<? extends Number> data) {
        double sum = 0;
        for (Number num : data) {
            sum += num.doubleValue();
        }
        return sum / data.size();
    }

    public static double calculateStd(ArrayList<? extends Number> data, double mean) {
        double sum = 0;
        for (Number num : data) {
            double diff = num.doubleValue() - mean;
            sum += diff * diff;
        }
        return Math.sqrt(sum / data.size());
    }

    public static double calculatePercentile(ArrayList<Double> sorted, double percentile) {
        int index = (int) Math.ceil(percentile / 100.0 * sorted.size()) - 1;
        return sorted.get(index);
    }

    public static ArrayList<Double> toDoubleList(ArrayList<? extends Number> data) {
        ArrayList<Double> list = new ArrayList<>();
        for (Number num : data) {
            list.add(num.doubleValue());
        }
        return list;
    }
}
