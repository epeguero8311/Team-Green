import java.util.*;
public class Evens {
    //AAA Test for Task2
    //start
    public static void main(String [] args){
        List<InsuranceRecord> records = new ArrayList<>();
        records.add(new InsuranceRecord(20, "female", 25.0, 0, "northwest", false, 2000.0));
        records.add(new InsuranceRecord(40, "male", 30.0, 2, "southeast", true, 4000.0));
        records.add(new InsuranceRecord(60, "female", 35.0, 1, "southwest", false, 6000.0));

        Calculations calc = new Calculations(records);
    }
}
