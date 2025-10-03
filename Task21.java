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

        double mean_y = mean(children);
        double mean_x = mean(charges);

        double numerator = 0.0;
        double denominator = 0.0;

        for(int i = 0; i < children.size(); i++){
            numerator += (children.get(i) - mean_y) * (charges.get(i) - mean_x);
            denominator += Math.pow(children.get(i) - mean_y, 2);
        }

        double slope = numerator / denominator;
        double intercept = mean_y - slope * mean_x;

        double r = pearson(children, charges);
        System.out.println("Pearson correlation coefficient: " + r);

        
    }
}
