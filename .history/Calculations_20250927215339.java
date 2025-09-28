import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculations {

    public static void main(String[] args) {
        readCSV("insurance.csv"); // call your function
    }

    // Function to read CSV
    public static void readCSV(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            // Read line by line
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line); // For now, just print each line
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }
    }
}
