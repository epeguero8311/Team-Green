import java.util.*;
import java.io.*;

public class Task21 {
    public static void main(String [] args){
        ArrayList<Double> children = new ArrayList<>();
        ArrayList<Double> charges = new ArrayList<>();

        try{
            Scanner sc = new Scanner(new File("insurance.csv"));
            sc.nextLine();
            while(sc.hasNextLine()){
                String [] row = sc.nextLine().split(",");
                children.add(Double.parseDouble(row[3].trim()));
                charges.add(Double.parseDouble(row[6].trim()));
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            return;
        }
    }
}
