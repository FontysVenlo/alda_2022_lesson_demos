package nl.fontys;

import static nl.fontys.Direction.LEFT;

/**
 *
 * @author hvd
 */
public class TowersOfHanoiMethodCallStack {

    public static void main(String[] args) {
        moveTower(3, LEFT, "");
    }

    static void moveTower(int size, Direction direction, String indentation) {

        // Three pillars in circular setup: 
        // Moving from the left most pillar to the LEFT means moving to the right most pillar.
        // Moving from the right most pillar to the RIGHT, means moving to the left most pillar.
        
        System.out.println(indentation + "moveTower(" + size + ", " + direction + ")");
        indentation += "|\t";

        if (size == 0) {
            return;
        }
        moveTower(size - 1, direction.opposite(), indentation);
        moveDisk(size, direction, indentation);
        moveTower(size - 1, direction.opposite(), indentation);
    }

    static void moveDisk(int diskNumber, Direction direction, String indentation) {
        System.out.print(indentation + "moveDisk(" + diskNumber + ", " + direction + ")");
        System.out.println(" -> Move disk " + diskNumber + " to the " + direction);
    }
}
