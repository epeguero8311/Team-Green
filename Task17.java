import java.util.*;
public class Task17 {
    private ArrayList<InsuranceRecord> records; 
    public Task17(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public void compare_smoking_by_region(){
        ArrayList<Integer> southern_ages = new ArrayList<>();
        ArrayList<Integer> northern_ages = new ArrayList<>();

        for(InsuranceRecord record : records){
            if(record.smoker){
                if(record.region.equalsIgnoreCase("southwest") || record.region.equalsIgnoreCase("southeast")){
                    southern_ages.add(record.age);
                } else if(record.region.equalsIgnoreCase("northwest") || record.region.equalsIgnoreCase("northeast")){
                    northern_ages.add(record.age);
                }
            }
        }

        ArrayList<Double> southern_ages_double = new ArrayList<>();
        for (Integer age : southern_ages) {
            southern_ages_double.add(age.doubleValue());
        }
        ArrayList<Double> northern_ages_double = new ArrayList<>();
        for (Integer age : northern_ages) {
            northern_ages_double.add(age.doubleValue());
        }
        double avg_southern_age = Calculations.getStatistics(southern_ages_double).get("mean");
        double avg_northern_age = Calculations.getStatistics(northern_ages_double).get("mean");

        System.out.printf("Southern Smokers -> Avg Age: %.2f%n", avg_southern_age);
        System.out.printf("Northern Smokers -> Avg Age: %.2f%n", avg_northern_age);

        if(avg_southern_age > avg_northern_age){
            System.out.println("Southernern smokers are older on average than northern smokers.");
        } else if (avg_southern_age < avg_northern_age){
            System.out.println("Northern smokers are older on average than southern smokers.");
        } else{
            System.out.println("Southern and northern smokers have the same average age.");
        }
    }
}
