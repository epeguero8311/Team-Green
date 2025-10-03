import java.util.*;
public class Task9 {
    private ArrayList<InsuranceRecord> records;

    public Task9(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public void check_bmi_ranges(){
        double [] min_charges = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
        double [] max_charges = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};

        for(InsuranceRecord record : records){
            double bmi = record.bmi;
            double charge = record.charges;
            int group;

            if(bmi < 30){
                group = 0;
            } else if (bmi <= 45){
                group = 1;
            } else {
                group = 2;
            }

            if(charge < min_charges[group]){
                min_charges[group] = charge;
            }

            if(charge > max_charges[group]){
                max_charges[group] = charge;
            }
        }

        double [] ranges = new double[3];
        for(int i = 0; i < 3; i++){
            if(min_charges[i] != Double.MAX_VALUE && max_charges[i] != Double.MIN_VALUE) {
                ranges[i] = max_charges[i] - min_charges[i];
            } else {
                ranges[i] = 0;
            }
        }

        System.out.println("Charge Ranges by BMI Group:");
        System.out.printf("Group A (BMI < 30): Range = %.2f\n", ranges[0]);
        System.out.printf("Group B (30 <= BMI <= 45): Range = %.2f\n", ranges[1]);
        System.out.printf("Group C (BMI > 45): Range = %.2f\n", ranges[2]);

        if(ranges[1] > ranges[0] && ranges[1] > ranges[2]){
            System.out.println("The range of charges for BMI in 30-45 is greater than the other two ranges.");
        } else {
            System.out.println("The range of charges for BMI in 30-45 is not greater than the other two ranges.");
        }
    }
}
