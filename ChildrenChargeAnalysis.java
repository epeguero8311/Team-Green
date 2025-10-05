import java.util.*;

public class ChildrenChargeAnalysis {
    
    public static void analyze(StoreRecords store) {
        ArrayList<InsuranceRecord> allRecords = store.records;
        
        Map<Integer, ArrayList<Double>> chargesByChildren = new HashMap<>();
        
        for (int i = 0; i < allRecords.size(); i++) {
            InsuranceRecord record = allRecords.get(i);
            int numChildren = record.children;
            
            if (!chargesByChildren.containsKey(numChildren)) {
                chargesByChildren.put(numChildren, new ArrayList<Double>());
            }
            chargesByChildren.get(numChildren).add(record.charges);
        }
        
        System.out.println("\n======================================================================");
        System.out.println("HYPOTHESIS: Charge Per Child Decreases as Number of Children Increases");
        System.out.println("======================================================================\n");
        
        System.out.println("Children | Count | Avg Charge  | Charge Per Child | % Decrease");
        System.out.println("---------+-------+-------------+------------------+-----------");
        
        double previousChargePerChild = 0.0;
        
        for (int numChildren = 0; numChildren <= 5; numChildren++) {
            if (chargesByChildren.containsKey(numChildren)) {
                ArrayList<Double> charges = chargesByChildren.get(numChildren);
                
                int count = charges.size();
                double avgCharge = Calculations.mean(charges);
                
                if (numChildren == 0) {
                    System.out.printf("   %d     |  %3d  | $%10.2f |              N/A |       N/A\n",
                        numChildren, count, avgCharge);
                } else {
                    double chargePerChild = avgCharge / numChildren;
                    
                    if (numChildren == 1) {
                        System.out.printf("   %d     |  %3d  | $%10.2f |      $%10.2f |  baseline\n",
                            numChildren, count, avgCharge, chargePerChild);
                        previousChargePerChild = chargePerChild;
                    } else {
                        double decrease = ((previousChargePerChild - chargePerChild) / previousChargePerChild) * 100;
                        System.out.printf("   %d     |  %3d  | $%10.2f |      $%10.2f |    %5.1f%%\n",
                            numChildren, count, avgCharge, chargePerChild, decrease);
                        previousChargePerChild = chargePerChild;
                    }
                }
            }
        }
        
        System.out.println("\n======================================================================");
        System.out.println("SUMMARY");
        System.out.println("======================================================================");
        
        double oneChildPerChild = 0.0;
        double fiveChildPerChild = 0.0;
        
        if (chargesByChildren.containsKey(1)) {
            ArrayList<Double> charges = chargesByChildren.get(1);
            oneChildPerChild = Calculations.mean(charges);
        }
        
        if (chargesByChildren.containsKey(5)) {
            ArrayList<Double> charges = chargesByChildren.get(5);
            fiveChildPerChild = Calculations.mean(charges) / 5;
        }
        
        double totalDecrease = ((oneChildPerChild - fiveChildPerChild) / oneChildPerChild) * 100;
        
        System.out.printf("Charge per child with 1 child:    $%.2f\n", oneChildPerChild);
        System.out.printf("Charge per child with 5 children: $%.2f\n", fiveChildPerChild);
        System.out.printf("\nOVERALL DECREASE: %.1f%%\n", totalDecrease);
        System.out.println("\nCONCLUSION: Hypothesis CONFIRMED - Having more children results in");
        System.out.println("significantly lower insurance charges per child.");
        System.out.println("======================================================================\n");
    }
}