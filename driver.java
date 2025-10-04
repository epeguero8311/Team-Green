public class driver {
    public static void main(String[] args) {
        StoreRecords store = new StoreRecords();
        store.read_csv("insurance.csv");
        
        Calculations.calculateAllStatistics(store);

        Graphing.displayBMIHistograms(store);
        int[] counts = Graphing.countSmokers(store.getRecords());
        Graphing.displaySmokerHistogram(counts[0], counts[1]);

    }
}
