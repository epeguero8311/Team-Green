import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        StoreRecords store = new StoreRecords();
        store.read_csv("insurance.csv");
        
        Calculations.calculateAllStatistics(store);

        Graphing.displayBMIHistograms(store);
        int[] counts = Graphing.countSmokers(store.getRecords());
        Graphing.displaySmokerHistogram(counts[0], counts[1]);

        //  5. Write code that determines the total number of records for each number of children.
        //     # This should be in the calculations file 
        //     # maybe a total function that returns a dictionary with the number of children as the key 
        //     # and the total number of records as the value

        // 7. We think this data is "fair" if the number of records from each region differ by no more than 5%.  Is the data fair?
        // 8. Is it true that people 50 or older average twice the charges as the average of people 20 and younger?
        // 9. We think the range of charges for bmi in 30-45 are greater than the other two ranges of BMIs.  Is this true?
        // 10. We think that having more children is a lower charge per child.  Is this true?
        // 11. Our hypothesis is that smokers have higher charges and a wider range of charges than non-smokers.  Is this hypothesis true for our dataset?
        // 12. We think smokers in the south are charged at least 25% more than other smokers.  Is this correct?
        // 13. Do smokers average lower bmi than non-smokers?


    }
}
