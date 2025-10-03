import java.util.*;

public class ChildrenCount{
    private ArrayList<InsuranceRecord> records;

    public ChildrenCount(ArrayList<InsuranceRecord> records) {
        this.records = records;
    }

    public void print_children_count(){
        HashMap<Integer, Integer> children_counts = new HashMap<>();

        for (InsuranceRecord record : records) {
            children_counts.put(record.children, children_counts.getOrDefault(record.children, 0) + 1);
        }

        ArrayList<Integer> children_numbers = new ArrayList<>(children_counts.keySet());
        Collections.sort(children_numbers);

        for(int children : children_numbers) {
            System.out.printf("%d children: ", children);
            for(int i = 0; i < children_counts.get(children); i++) {
                System.out.print("*");
            }
            System.out.println(" (" + children_counts.get(children) + ")");
        }
    }
}