package nl.fontys;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public enum Direction {
    
    LEFT, RIGHT;
    
    public Direction opposite(){
        return ( this.equals( LEFT) ? RIGHT : LEFT);
    }
}
