import java.util.LinkedList;

/**
 * Created by Joseph Edmunds
 * 10/13/2015.
 * The class that links performs the induction and divide-and-conquer methods
 */
public class Spike {
    public LinkedList<Building> skyline = new LinkedList<>();

    /**
     * Constructor for a spike
     *
     * @param constructor The linked list that the spike will be made from
     */
    public Spike(LinkedList<Building> constructor) {
        skyline = constructor;
    }

    /**
     * Divides a linked list into two linked lists. Those two linked lists are then stored in a separate linked list
     * This method is necessary for the divide-and-conquer method
     *
     * @param toDivide The linked list to be split
     * @return The linked list containing the two halves of the original linked list
     */
    public LinkedList<LinkedList<Building>> divide(LinkedList<Building> toDivide) {
        LinkedList<LinkedList<Building>> halves = new LinkedList<>();
        LinkedList<Building> firstHalf = new LinkedList<>();
        LinkedList<Building> secondHalf = new LinkedList<>();
        int splitMark = toDivide.size() / 2;
        for (int i = 0; i < splitMark; i++)
            firstHalf.add(toDivide.get(i));
        for (int j = splitMark; j < toDivide.size(); j++)
            secondHalf.add(toDivide.get(j));
        halves.add(firstHalf);
        halves.add(secondHalf);
        return halves;
    }

    /**
     * Solves the skyline problem by induction, the iterative solution
     */
    public void induction() {
        LinkedList<Building> toSet = new LinkedList<>();
        Building start = skyline.get(0);
        for (int i = 1; i < skyline.size(); i++)
            start = start.combo(skyline.get(i));
        toSet.add(start);
        skyline = toSet;
    }

    /**
     * Solves using the divide-and-conquer, the recursive solution
     * The initial recursive call
     */
    public void recursion() {
        Spike initial = new Spike(recursion(divide(skyline).get(0), divide(skyline).get(1)));
        skyline = initial.skyline;
    }

    /**
     * The follow-up recursive calls
     * @param firstHalf The
     * @param secondHalf
     * @return
     */
    public LinkedList<Building> recursion(LinkedList<Building> firstHalf, LinkedList<Building> secondHalf) {
        if (firstHalf.size() == 1) {
            if (secondHalf.size() == 1) { //Both sides are same size, size 1
                LinkedList<Building> baseCase = new LinkedList<>();
                baseCase.add(firstHalf.get(0).combo(secondHalf.get(0)));
                return baseCase;
            } else return recursion(firstHalf, recursion(divide(secondHalf).get(0), divide(secondHalf).get((1))));
        } else
            return recursion(recursion(divide(firstHalf).get(0), divide(firstHalf).get(1)), recursion(divide(secondHalf).get(0), divide(secondHalf).get(1)));
    }

    /**
     *
     */
    public String printResult() {
        String out = "";
        for (int i = 0; i < skyline.size(); i++)
            out += skyline.get(i).toString();
        return out;
    }
}
