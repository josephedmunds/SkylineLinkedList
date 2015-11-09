import java.util.LinkedList;

/**
 * Created by Joseph Edmunds
 * 10/13/2015.
 * The class that drives the Skyline project
 */
public class Skyline {
    public static void main(String[] args) {
        int input[] = Utilities.acceptInput();
        int solvingMethod = input[0];
        int dataSet = input[1];
        LinkedList<Building> buildings = Utilities.retrieveData(dataSet);
        Spike skyline = new Spike(buildings);
        if (solvingMethod == 0) {
            skyline.induction();
        } else if (solvingMethod == 1) {
            skyline.recursion();
        }
        System.out.print(skyline.printResult());
    }
}
