package fontys.tailrecursion;

/**
 * Traditional, non-tail-recursive, solution to calculate factorial.
 * @author hvd
 */
public class TraditionalFactorial {
    
    public static void main( String[] args ) {
        int result = factorial( 6 );
        System.out.println( "Result is " + result );
    }
    
    static int factorial(int n){
        if ( n == 0 ) {
            return 1;
        }
        return n * factorial( n - 1 );
    }
}
