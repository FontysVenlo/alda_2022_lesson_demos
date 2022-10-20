package nl.fontys;

import static nl.fontys.Direction.LEFT;

/**
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class TowersOfHanoi {

    public static void main(String[] args) {
        moveTower( 3, LEFT );
    }

    static void moveTower(int size, Direction direction) {
        
        // Three pillars in circular setup: 
        // Moving from the left most pillar to the LEFT means moving to the right most pillar.
        // Moving from the right most pillar to the RIGHT, means moving to the left most pillar.
        
        if (size == 0) {
            return;
        }
        moveTower( size - 1, direction.opposite() );
        moveDisk( size, direction);
        moveTower( size - 1, direction.opposite() );
    }

    static void moveDisk(int diskNumber, Direction direction) {
        System.out.println("Move disk " + diskNumber + " to the " + direction);
    }
}
