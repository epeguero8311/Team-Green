public class driver {
    public static void main(String[] args) {
        StoreRecords store = new StoreRecords();
        store.read_csv("insurance.csv");
        
        Calculations.calculateAllStatistics(store);

        Graphing.displayBMIHistograms(store);
        int[] counts = Graphing.countSmokers(store.getRecords());
        Graphing.displaySmokerHistogram(counts[0], counts[1]);

        //(SWE 8, 10, 12, 14) , (Tester 7, 9, 11, 13) Questions that need an average, mean function can be reused in Calculations.java

        // 7. We think this data is "fair" if the number of records from each region differ by no more than 5%.  Is the data fair?
                //Count how many records are from each region then find the minimum and maximum counts.  
                //If the max is no more than 1.05 times the minimum, then the data is fair.

        // 9. We think the range of charges for bmi in 30-45 are greater than the other two ranges of BMIs.  Is this true?
                //Split records into 3 groups. A: BMI < 30, B: 30 <= BMI <= 45, C: BMI > 45.
                //Find the range of charges for each group (max - min).  
                //See if range for group B is greater than ranges for groups A and C.

        // 10. We think that having more children is a lower charge per child.  Is this true?
                //Group the records by number of children (1, 2, 3, 4, 5). (Skip 0 children, cant divide by 0) 
                //For each group find the average charge per child (total charges / total children).

        // 11. Our hypothesis is that smokers have higher charges and a wider range of charges than non-smokers.  Is this hypothesis true for our dataset?
                //Find the average and range of charges for smokers and non-smokers. Then compare.

        // 12. We think smokers in the south are charged at least 25% more than other smokers.  Is this correct?
                //Sort for smokers in the south and smokers not in the south.  
                //Find the average charge for each group and compare.

        // 13. Do smokers average lower bmi than non-smokers?
                //Sort BMI for smokers and non-smokers.  Find the average for each group and compare.

        // 14. A histogram is a distribution.  What is the age distribution for smokers?
                //A hisogram of the ages of smokers. Answer with the shape of disribution (normal, skewed, uniform, etc).
                //Could try to use histogram code from Graphing.java
        

    }
}
