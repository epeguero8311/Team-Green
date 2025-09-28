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
        ArrayList<Double> ages = new ArrayList<>();
        ArrayList<Double> bmis = new ArrayList<>();
        ArrayList<Double> children = new ArrayList<>();
        ArrayList<Double> charges = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            // Skip header
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                ages.add(Double.parseDouble(parts[0].trim()));
                bmis.add(Double.parseDouble(parts[2].trim()));
                children.add(Double.parseDouble(parts[3].trim()));
                charges.add(Double.parseDouble(parts[6].trim()));
            }

            sc.close();

            printStats("Age", ages);
            printStats("BMI", bmis);
            printStats("Children", children);
            printStats("Charges", charges);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }
    }

    public static void printStats(String name, ArrayList<Double> data) {
        Collections.sort(data); 

        int count = data.size();
        double mean = calculateMean(data);
        double std = calculateStd(data, mean);
        double min = data.get(0);
        double max = data.get(data.size() - 1);
        double p25 = calculatePercentile(data, 25);
        double p50 = calculatePercentile(data, 50);
        double p75 = calculatePercentile(data, 75);

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

    public static double calculateMean(ArrayList<Double> data) {
        double sum = 0;
        for (double num : data) sum += num;
        return sum / data.size();
    }

    public static double calculateStd(ArrayList<Double> data, double mean) {
        double sum = 0;
        for (double num : data) {
            double diff = num - mean;
            sum += diff * diff;
        }
        return Math.sqrt(sum / data.size());
    }

    public static double calculatePercentile(ArrayList<Double> sorted, double percentile) {
        int index = (int) Math.ceil(percentile / 100.0 * sorted.size()) - 1;
        return sorted.get(index);
    }
}
