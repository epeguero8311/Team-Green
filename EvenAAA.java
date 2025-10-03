import java.util.*;
public class EvenAAA {
    public static void main(String[] args) {
        ArrayList<Double> ages = new ArrayList<>(Arrays.asList(20.0, 30.0, 40.0, 50.0));
        ArrayList<Double> bmis = new ArrayList<>(Arrays.asList(18.5, 24.0, 28.0, 32.0));
        ArrayList<Double> children = new ArrayList<>(Arrays.asList(0.0, 1.0, 2.0, 3.0));
        ArrayList<Double> charges = new ArrayList<>(Arrays.asList(1000.0, 2000.0, 3000.0, 4000.0));


        Map<String, Double> ageStats = Calculations.getStatistics(ages);
        Map<String, Double> bmiStats = Calculations.getStatistics(bmis);
        Map<String, Double> childrenStats = Calculations.getStatistics(children);
        Map<String, Double> chargesStats = Calculations.getStatistics(charges);

        System.out.println("Age Test");
        //check if stats match expected outcome 
        System.out.println("Count correct? " + (ageStats.get("count") == 4));
        System.out.println("Mean correct? " + (Math.abs(ageStats.get("mean") - 35.0) < 0.0001));
        System.out.println("Std correct? " + (Math.abs(ageStats.get("std") - 12.9099) < 0.0001));
        System.out.println("Min correct? " + (ageStats.get("min") == 20.0));
        System.out.println("25% correct? " + (Math.abs(ageStats.get("25%") - 27.5) < 0.0001));
        System.out.println("50% correct? " + (Math.abs(ageStats.get("50%") - 35.0) < 0.0001));
        System.out.println("75% correct? " + (Math.abs(ageStats.get("75%") - 42.5) < 0.0001));
        System.out.println("Max correct? " + (ageStats.get("max") == 50.0));

        System.out.println("\n---- BMI Test ----");
        System.out.println("Mean correct? " + (Math.abs(bmiStats.get("mean") - 25.625) < 0.0001));
        System.out.println("Std correct? " + (Math.abs(bmiStats.get("std") - 5.34) < 0.01));

        System.out.println("\n---- Children Test ----");
        System.out.println("Max correct? " + (childrenStats.get("max") == 3.0));

        System.out.println("\n---- Charges Test ----");
        System.out.println("50% correct? " + (Math.abs(chargesStats.get("50%") - 2500.0) < 0.0001));


    }


}
