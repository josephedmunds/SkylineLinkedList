import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Joseph Edmunds
 * 10/15/2015.
 * A file that contains utility methods used in the project
 */
public class Utilities {
    /**
     * Accepts the user input to determine which method will be used to solve the skyline problem
     *
     * @return 0 or 1. O to solve by induction, 1 to solve by divide-and-conquer
     */
    public static int[] acceptInput() {
        int[] input = new int[2];
        System.out.printf("To solve by induction, enter 0.\nTo solve by divide-and-conquer, enter 1.\n");
        Scanner scanMan = new Scanner(System.in);
        input[0] = scanMan.nextInt();
        System.out.printf("Select data set: \n");
        input[1] = scanMan.nextInt();
        return input;
    }

    /**
     * Reads in the data from the input file into a linked list
     *
     * @param dataSet The file containing the data
     * @return The linked list of formatted data
     */
    public static LinkedList<Building> retrieveData(int dataSet) {
        LinkedList<Building> buildSkyline = new LinkedList<>();
        Scanner scanMan;
        try {
            File data = new File("src/sky" + dataSet + ".dat");
            scanMan = new Scanner(data);
            while (scanMan.hasNextLine()) {
                buildSkyline.add(new Building(scanMan.nextInt(), scanMan.nextInt(), scanMan.nextInt()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return buildSkyline;
    }
}
