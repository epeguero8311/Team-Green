import java.util.*;
public class Task19 {
    private ArrayList<InsuranceRecord> records;
    public Task19(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public void compare_children_by_region(){
        ArrayList<Integer> southern_children = new ArrayList<>();
        ArrayList<Integer> northern_children = new ArrayList<>();
        ArrayList<Integer> south_ages = new ArrayList<>();
        ArrayList<Integer> north_ages = new ArrayList<>();


        for(InsuranceRecord record : records){
            if(record.region.equalsIgnoreCase("southwest") || record.region.equalsIgnoreCase("southeast")){
                southern_children.add(record.children);
                south_ages.add(record.age);
            } else if(record.region.equalsIgnoreCase("northwest") || record.region.equalsIgnoreCase("northeast")){
                northern_children.add(record.children);
                north_ages.add(record.age);
            }
        }

        double avg_southern_children = Calculations.getStatistics(convertToDoubleList(southern_children)).get("mean");
        double avg_northern_children = Calculations.getStatistics(convertToDoubleList(northern_children)).get("mean");

        double avg_southern_age = Calculations.getStatistics(convertToDoubleList(south_ages)).get("mean");
        double avg_northern_age = Calculations.getStatistics(convertToDoubleList(north_ages)).get("mean");

        System.out.printf("Southern Region -> Avg Children: %.2f, Avg Age: %.2f%n", avg_southern_children, avg_southern_age);
        System.out.printf("Northern Region -> Avg Children: %.2f, Avg Age: %.2f%n", avg_northern_children, avg_northern_age);
    }
}
