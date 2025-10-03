import java.util.*;
public class Task13 {
    private ArrayList<InsuranceRecord> records;
    public Task13(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public void check_smoker_bmi(){
        ArrayList<Double> smoker_bmi = new ArrayList<>();
        ArrayList<Double> nonsmoker_bmi = new ArrayList<>();


        for(InsuranceRecord record : records){
            if(record.smoker){
                smoker_bmi.add(record.bmi);
            } else {
                nonsmoker_bmi.add(record.bmi);
            }
        }

        double avg_smoker_bmi = Calculations.getStatistics(smoker_bmi).get("mean");
        double avg_nonsmoker_bmi = Calculations.getStatistics(nonsmoker_bmi).get("mean");

        System.out.printf("Smokers -> Avg BMI: %.2f%n", avg_smoker_bmi);
        System.out.printf("Non-Smokers -> Avg BMI: %.2f%n", avg_nonsmoker_bmi);

        if(avg_smoker_bmi < avg_nonsmoker_bmi){
            System.out.println("Yes: Smokers avergage a lower BMI than non-smokers.");
        } else {
            System.out.println("No: Smokers do not average a lower BMI than non-smokers.");
        }
    }
}
