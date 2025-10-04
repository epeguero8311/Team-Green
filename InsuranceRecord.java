public class InsuranceRecord {
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
