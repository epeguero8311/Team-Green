public class driver {
    public static void main(String[] args) {
        //Task 1
        StoreRecords store = new StoreRecords();
        store.read_csv("insurance.csv");
        
        //Task 2
        Calculations.calculateAllStatistics(store);

        //Task 3
        AgeHistogram Age_Histogram = new AgeHistogram(store.getRecords());
        Age_Histogram.print_histogram();

        //Task 4
        Graphing.displayBMIHistograms(store);

        //Task 5
        ChildrenCount childrenCount = new ChildrenCount(store.getRecords());
        childrenCount.print_children_count();

        //Task 6
        int[] counts = Graphing.countSmokers(store.getRecords());
        Graphing.displaySmokerHistogram(counts[0], counts[1]);

        //Task 7
        Task7 task7 = new Task7(store.getRecords());
        task7.print_fairness();

        //Task 8
        AgeGroupComparison.compareAgeGroupCharges(store);     
        
        //Task 9
        Task9 task9 = new Task9(store.getRecords());
        task9.check_bmi_ranges();

        //Task 10

        //Task 11
        Task11 task11 = new Task11(store.getRecords());
        task11.check_smoker_hypothesis();

        //Task12
        SmokerAnalysis.analyze(store);

        //Task 13
        Task13 task13 = new Task13(store.getRecords());
        task13.check_smoker_bmi();

        //Task 14
        AgeDistribution.analyze(store);

        //Task 15
        Task15 task15 = new Task15(store.getRecords());
        task15.sort_regions_by_avg_charges();

        //Task 16
        SmokingByAge.analyze(store);

        //Task 17
        Task17 task17 = new Task17(store.getRecords());
        task17.compare_smoking_by_region();

        //task 18

        //Task 19
        Task19 task19 = new Task19(store.getRecords());
        task19.compare_children_by_region();

        //Task 20
        RegressionAnalysis.analyze(store);

        //Task 21
        Task21.main(args);

        //Task 22
        RegionRegressionAnalysis.analyze(store);


    }
}
