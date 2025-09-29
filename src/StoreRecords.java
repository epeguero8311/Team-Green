import java.util.*;
import java.io.*;
/* 
 how to use this with your calculations.java file -> create object and load data from csv
    StoreRecords store = new StoreRecords();    
    store.read_csv("insurance.csv");  
*/
 


public class StoreRecords {
    public ArrayList<InsuranceRecord> records;

    public StoreRecords() {
        records = new ArrayList<InsuranceRecord>();
    }

    public void add_record(InsuranceRecord record) {
        records.add(record);
    }

    public ArrayList<InsuranceRecord> get_first_n_records(int N){
        ArrayList<InsuranceRecord> first_n_records = new ArrayList<InsuranceRecord>();
        for (int i = 0; i < N && i < records.size(); i++) {
            first_n_records.add(records.get(i));
        }
        return first_n_records;
    }

    public void read_csv(String filename){
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            if(scanner.hasNextLine()){
                scanner.nextLine(); // Skip header line
                while(scanner.hasNextLine()){
                    String[] parts = scanner.nextLine().split(",");

                    int age = Integer.parseInt(parts[0].trim());
                    String sex = parts[1].trim();
                    double bmi = Double.parseDouble(parts[2].trim());
                    int children = Integer.parseInt(parts[3].trim());
                    boolean smoker = parts[4].trim().equalsIgnoreCase("yes");
                    String region = parts[5].trim();
                    double charges = Double.parseDouble(parts[6].trim());

                    InsuranceRecord record = new InsuranceRecord(age, sex, bmi, children, charges, region, smoker);
                       records.add(record);
                } // Skip header line
            }

            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + filename);
        }
    }

    public ArrayList<InsuranceRecord> getRecords() {
        return records;
    }
}




class InsuranceRecord {
    public int age;
    public String sex; 
    public double bmi;
    public int children;
    public double charges;
    public String region;
    public boolean smoker;

    public InsuranceRecord(int age, String sex, double bmi, int children, double charges, String region, boolean smoker) {
        this.age = age;
        this.sex = sex;
        this.bmi = bmi;
        this.children = children;
        this.charges = charges;
        this.region = region;
        this.smoker = smoker;
    }
}

