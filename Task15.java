import java.util.*;
public class Task15 {
    private ArrayList<InsuranceRecord> records;
    public Task15(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public void sort_regions_by_avg_charges(){
        HashMap<String, ArrayList<Double>> region_charges = new HashMap<>();

        for(InsuranceRecord record : records){
            region_charges.putIfAbsent(record.region, new ArrayList<>());
            region_charges.get(record.region).add(record.charges);
        }


        HashMap<String, Double> region_avg = new HashMap<>();

        for(String region : region_charges.keySet()){
            double avg = Calculations.getStatistics(region_charges.get(region)).get("mean");
            region_avg.put(region, avg);
        }

        List<Map.Entry<String, Double>> sorted_regions = new ArrayList<>(region_avg.entrySet());
        sorted_regions.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        System.out.println("Regions sorted by average charges (highest to lowest):");

        for(Map.Entry<String, Double> entry : sorted_regions){
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
