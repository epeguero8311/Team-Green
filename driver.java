public class driver {
    public static void main(String[] args) {
        StoreRecords store = new StoreRecords();
        store.read_csv("insurance.csv");
        
        Calculations.calculateAllStatistics(store);

        Graphing.displayBMIHistograms(store);
        int[] counts = Graphing.countSmokers(store.getRecords());
        Graphing.displaySmokerHistogram(counts[0], counts[1]);

        //(SWE 8, 10, 12, 14) Questions that need an average, mean function can be reused in Calculations.java
        // 8. Is it true that people 50 or older average twice the charges as the average of people 20 and younger?

        // 10. We think that having more children is a lower charge per child.  Is this true?
                //Group the records by number of children (1, 2, 3, 4, 5). (Skip 0 children, cant divide by 0) 
                //For each group find the average charge per child (total charges / total children).

        // 12. We think smokers in the south are charged at least 25% more than other smokers.  Is this correct?
                //Sort for smokers in the south and smokers not in the south.  
                //Find the average charge for each group and compare.

        // 14. A histogram is a distribution.  What is the age distribution for smokers?
                //A hisogram of the ages of smokers. Answer with the shape of disribution (normal, skewed, uniform, etc).
                //Could try to use histogram code from Graphing.java

    }
}
