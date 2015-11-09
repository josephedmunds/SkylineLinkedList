import java.util.LinkedList;

/**
 * Created by Joseph Edmunds
 * 10/15/2015.
 * The base data structure of the project, that will hold data for a building
 */
public class Building {
    LinkedList<Integer> sky = new LinkedList<>();

    /**
     * Constructor for a one building skyline
     *
     * @param left   The position of the left end of the building
     * @param height The height of the building
     * @param right  The position of the right end of the building
     */
    public Building(int left, int height, int right) {
        //Initialize the skyline to be of height zero, to allow for comparison
        for (int i = 0; i < left; i++) {
            sky.add(0);
        }
        //Add the building to the skyline
        for (int j = left; j < right; j++) {
            sky.add(height);
        }
    }

    /**
     * Constructor for a linked list of buildings
     * @param setSky The linked list of buildings
     */
    public Building(LinkedList<Integer> setSky) {
        sky = setSky;
    }

    /**
     * Combines two buildings into a combo of the two
     * @param toAdd The building that is being added
     * @return The sum of the two buildings
     */
    public Building combo(Building toAdd) {
        LinkedList<Integer> summed = new LinkedList<>();
        int loopCount;
        if (sky.size() > toAdd.sky.size())
            loopCount = sky.size();
        else
            loopCount = toAdd.sky.size();
        for (int i = 0; i < loopCount; i++) {
            if (i >= toAdd.sky.size())
                summed.add(sky.get(i));
            else if (i >= sky.size())
                summed.add(toAdd.sky.get(i));
            else {
                if (toAdd.sky.get(i) > sky.get(i))
                    summed.add(toAdd.sky.get(i));
                else
                    summed.add(sky.get(i));
            }
        }
        Building created = new Building(summed);
        return created;
    }

    /**
     * Formats the output into (p,h,p,h...) style
     *
     * @return The formatted string
     */
    public String toString() {
        int currentHeight = sky.get(0);
        int currentIndex = 0;
        String out = "(";
        LinkedList<Integer> height = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        for (int i = 0; i < sky.size(); i++) {
            if (sky.get(i) != currentHeight) {
                currentIndex = i;
                currentHeight = sky.get(i);
                height.add(currentHeight);
                index.add(currentIndex);
            }
        }
        height.add(currentHeight);
        index.add(currentIndex);
        for (int i = 0; i < index.size(); i++)
            out += index.get(i) + ", " + height.get(i) + ", ";
        out += sky.size() + ", 0)";
        return out;
    }
}