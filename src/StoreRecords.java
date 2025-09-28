import java.util.*;
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
}

class InsuranceRecord {
    public int age;
    public double bmi;
    public int children;
    public double charges;
    public String region;
    public boolean smoker;

    public InsuranceRecord(int age, double bmi, int children, double charges, String region, boolean smoker, String sex) {
        this.age = age;
        this.bmi = bmi;
        this.children = children;
        this.charges = charges;
        this.region = region;
        this.smoker = smoker;
        this.sex = sex;
    }
}
//git
