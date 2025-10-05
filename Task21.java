import java.util.*;
import java.io.*;

public class Task21 {
    public static void main(String [] args){
        ArrayList<Double> children = new ArrayList<>();
        ArrayList<Double> charges = new ArrayList<>();

        try{
            Scanner sc = new Scanner(new File("insurance.csv"));
            sc.nextLine();
            while(sc.hasNextLine()){
                String [] row = sc.nextLine().split(",");
                children.add(Double.parseDouble(row[3].trim()));
                charges.add(Double.parseDouble(row[6].trim()));
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            return;
        }

        double mean_x = mean(children);
        double mean_y = mean(charges);

        double numerator = 0.0;
        double denominator = 0.0;

        for(int i = 0; i < children.size(); i++){
            numerator += (children.get(i) - mean_x) * (charges.get(i) - mean_y);
            denominator += Math.pow(children.get(i) - mean_x, 2);
        }

        double slope = numerator / denominator;
        double intercept = mean_y - slope * mean_x;

        double r = person(children, charges);
        System.out.println("Pearson correlation coefficient: " + r);

        System.out.println("\nPredicted charges for new child counts:");

        for(int x = 1; x <= 22; x++){
            double predictedCharge = slope * x + intercept;
            System.out.printf("Children: %d, Predicted Charges: %.2f%n", x, predictedCharge);
        }
    }

    public static double mean(ArrayList<Double> values) {
        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        return sum / values.size();
    }

    public static double person(ArrayList<Double> x, ArrayList<Double> y) {
        double meanx = mean(x);
        double meany = mean(y);

        double numerator = 0.0;
        double denominatorX = 0.0;
        double denominatorY = 0.0;

        for (int i = 0; i < x.size(); i++) {
            double dx = x.get(i) - meanx;
            double dy = y.get(i) - meany;

            numerator += dx * dy;
            denominatorX += dx * dx;
            denominatorY += dy * dy;
        }
        return numerator / Math.sqrt(denominatorX * denominatorY);
    }
}
