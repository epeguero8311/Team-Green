import java.util.*;
public class Task11{
    private ArrayList<InsuranceRecord> records;

    public Task11(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public void check_smoker_hypothesis(){
        ArrayList<Double> smoker_charges = new ArrayList<>();
        ArrayList<Double> nonsmoker_charges = new ArrayList<>();

        for(InsuranceRecord record : records){
            if(record.smoker){
                smoker_charges.add(record.charges);
            } else {
                nonsmoker_charges.add(record.charges);
            }
        }

        double smoker_avg = Calculations.getStatistics(smoker_charges).get("mean");
        double nonsmoker_avg = Calculations.getStatistics(nonsmoker_charges).get("mean");

        double range_smoker = Calculations.getStatistics(smoker_charges).get("max") - Calculations.getStatistics(smoker_charges).get("min");
        double range_nonsmoker = Calculations.getStatistics(nonsmoker_charges).get("max") - Calculations.getStatistics(nonsmoker_charges).get("min");


        System.out.printf("Smokers -> Avg: %.2f, Range: %.2f%n", smoker_avg, range_smoker);
        System.out.printf("Non-Smokers -> Avg: %.2f, Range: %.2f%n", nonsmoker_avg, range_nonsmoker);

        if(smoker_avg > nonsmoker_avg && range_smoker > range_nonsmoker){
            System.out.println("The hypothesis is supported: Smokers have higher average charges and a greater range of charges than non-smokers.");
        } else {
            System.out.println("The hypothesis is not supported.");
        }


    }


}