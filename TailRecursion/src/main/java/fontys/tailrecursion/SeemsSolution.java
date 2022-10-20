/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.tailrecursion;

/**
 * Tail recursive solution.
 * Be aware that this solution in Java still causes a growing call stack with
 * a number of elements equal to the recursion depth.
 * @author hvd
 */
public class SeemsSolution {

    public static void main( String[] args ) {
        int result = factorial( 1, 15 );
        System.out.println( "Result is " + result );
    }

    static int factorial( int intermediateResult, int n ) {
        if ( n == 0 ) {
            return intermediateResult;
        }
        return factorial( n * intermediateResult, n - 1 );
    }
}
