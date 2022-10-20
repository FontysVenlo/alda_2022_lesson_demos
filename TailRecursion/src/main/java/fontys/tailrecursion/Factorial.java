package fontys.tailrecursion;


/**
 * Code derived from book Venkat Subramaniam.
 * @author From Venkat Subramaniam - Functional Programming in Java - ch7
 */
public class Factorial {
    
    public static TailCall<Integer> factorial( final int ofNumber ) {
        return factorial( 1, ofNumber );
    }

    private static TailCall<Integer> factorial( final int intermediateResult, final int ofNumber ) {
        
        System.out.println("Invoked with :" + intermediateResult + " " + ofNumber);
        
        if ( ofNumber == 1 ) {
            return TailCall.done( intermediateResult );
        } else {
            return ( () -> factorial( intermediateResult * ofNumber, ofNumber - 1 ) );
        }
    }
}
