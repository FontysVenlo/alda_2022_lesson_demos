package fontys.tailrecursion;

import java.util.stream.Stream;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class DemoStreamIterate {
    
    public static void main(String[] args) {
        
        // Stream class provides utility method iterate
        // First parameter is starting element
        // Second parameter is function that is applied on first parameter,
        // to generate next element in stream.
        
        Stream.iterate( 0, n -> n+1)
                .limit(10)
                .forEach( n -> System.out.println( n ));

        // Alternative way to stop the generation of stream elements...
        // Not useful in our tail recursion scenario
        
        Stream.iterate( 0, n -> n <= 10, n -> n+1)
                .forEach( n -> System.out.println( n ));
        
    }  
}
