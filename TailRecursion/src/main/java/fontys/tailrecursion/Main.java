package fontys.tailrecursion;

/**
 * Demo tail recursion in Java. 
 * Based on "Functional Programming in Java by Venkat Subramaniam".
 * Be aware that this demo is not ready for BigInteger.
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */

public class Main {
    
    public static void main( String[] args ) {
        
        TailCall<Integer> call = Factorial.factorial( 5 );
        
        // Only ONE TailCall object created now, no stream generated yet,
        // no recursive call executed yet.
        
        Integer result = call.invoke();
        // Line 12 causes a stream of TailCall objects to be generated
        // The last TailCall object contains the final result.
        
        System.out.println( "Result is " + result );
    }    
}
