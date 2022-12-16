/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package org.fontysvenlo.perfectsum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Perfect Sum. Generate number combinations that exactly sum up to a certain
 * value. Source:
 * https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
 * Example from given source refactored by R.van den Ham.
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class PerfectSum {

    // sumPossible[i][j] is going to store true if sum j is 
    // possible with array elements from 0 to i. 
    boolean[][] sumPossible;
    int recursionDepth = 0;

    void display( ArrayList<Integer> result ) {
        for ( int i = 1; i < recursionDepth; i++ ) {
            System.out.print( "\t" );
        }
        System.out.println( "SET FOUND: " + result );
    }

    void displayMethodCallStack( int rowIndex, int sum, ArrayList<Integer> result ) {
        for ( int j = 1; j < recursionDepth; j++ ) {
            System.out.print( "\t" );
        }
        System.out.println( "printSubSets(input, " + rowIndex + ", " + sum + ", " + result );
    }

    // A recursive function to print all subsets with the 
    // help of sumPossible[][]. p stores current subset.
    // i is the index of the last element to consider.
    void printSubsets( int[] input, int rowIndex, int sum, ArrayList<Integer> result ) {

        recursionDepth++;
        displayMethodCallStack( rowIndex, sum, result );

        // To print a subset, evaluate two scenario's:
        // * The sum can be reached without using this element (IF-STATEMENT-3)
        //   -> in sumPossible matrix look at element above
        // * The sum can be reached with using this element (IF-STATEMENT-4)
        //   -> in sumPossible matrix, look at element row above, but for
        //      a reduced sum now.
        
        // The first row in the sumPossible matrix will only contain a TRUE value
        // at two positions: 
        // * Sum 0 can always be reached without using this element at all.
        //   -> IF-STATEMENT-2 -> not necessary to add element, just display the set
        // * Sum x can be reached if x is the value of this element itself
        //   -> IF-STATEMENT-1 -> add the element and display the set
        
        //==================
        //= IF-STATEMENT-1 =
        //==================
        // If we reached end and sum is non-zero. We print 
        // result[] only if input[0] is equal to sum OR sumPossible[0][sum] 
        // is true.
        if ( rowIndex == 0 && sum != 0 && sumPossible[ 0 ][ sum ] ) {
            result.add( input[ rowIndex ] );
            display( result );
            result.clear();
            recursionDepth--;
            return;
        }

        //==================
        //= IF-STATEMENT-2 =
        //==================
        // If sum becomes 0 
        if ( rowIndex == 0 && sum == 0 ) {
            display( result );
            result.clear();
            recursionDepth--;
            return;
        }

        //==================
        //= IF-STATEMENT-3 =
        //==================
        // If given sum can be achieved after ignoring 
        // current element.
        if ( sumPossible[ rowIndex - 1 ][ sum ] ) {
            // Create a new vector to store path 
            ArrayList<Integer> newResult = new ArrayList<>();
            newResult.addAll( result );
            printSubsets( input, rowIndex - 1, sum, newResult );
        }

        //==================
        //= IF-STATEMENT-4 =
        //==================
        // If given sum can be achieved after considering 
        // current element. 
        if ( sum >= input[ rowIndex ] && sumPossible[ rowIndex - 1 ][ sum - input[ rowIndex ] ] ) {
            result.add( input[ rowIndex ] );
            printSubsets( input, rowIndex - 1, sum - input[ rowIndex ], result );
        }

        recursionDepth--;
    }

    void buildSumMatrix( int[] input, int sum ) {
        int noOfRows = input.length;

        if ( noOfRows == 0 || sum < 0 ) {
            return;
        }

        // Sum 0 can always be achieved with 0 elements 
        sumPossible = new boolean[ noOfRows ][ sum + 1 ];
        for ( int rowIndex = 0; rowIndex < noOfRows; ++rowIndex ) {
            sumPossible[ rowIndex ][ 0 ] = true;
        }

        // Sum input[0] can be achieved with single element 
        if ( input[ 0 ] <= sum ) {
            sumPossible[ 0 ][ input[ 0 ] ] = true;
        }

        // Fill rest of the entries in sumPossible[][]  row is iterating rows, sumColumn is iterating columns
        //
        // input[row] > sumColumn would mean that one element is bigger itself than the requested sum,
        // the requested sum can only be reached without using this element.
        for ( int rowIndex = 1; rowIndex < noOfRows; ++rowIndex ) {
            for ( int sumColumn = 0; sumColumn < sum + 1; ++sumColumn ) {
                sumPossible[ rowIndex ][ sumColumn ] = ( input[ rowIndex ] <= sumColumn ) ? 
                        ( sumPossible[ rowIndex - 1 ][ sumColumn ] || sumPossible[ rowIndex - 1 ][ sumColumn - input[ rowIndex ] ] )
                        : sumPossible[ rowIndex - 1 ][ sumColumn ];
            }
        }
    }
    
    void printSumMatrix( int[] input, int sum){
        
        for (int sumColumn = 0; sumColumn <= sum; sumColumn++) {
            System.out.print("\t" + "sum " + sumColumn);
        }
        System.out.println();
        
        for ( int rowIndex = 0; rowIndex < sumPossible.length; rowIndex++ ) {
        
            System.out.print( input[rowIndex] + "\t");
            
            for ( int sumColumnIndex = 0; sumColumnIndex < sumPossible[ rowIndex ].length; sumColumnIndex++ ){
                System.out.print( sumPossible[rowIndex][sumColumnIndex] + "\t" );
            }
            System.out.println( );
        }
        System.out.println();
    }

    boolean isSumPossible( int sum, int numEl ) {

        int rowIndex = numEl - 1;
        int columnIndex = sum;

        return ( rowIndex < sumPossible.length )
                && ( columnIndex < sumPossible[ rowIndex ].length )
                && ( sumPossible[ rowIndex ][ columnIndex ] );
    }

    public static void main( String args[] ) {

        PerfectSum ps = new PerfectSum();

        int[] input = { 1, 2, 3, 4, 5 };
        //int[] input = { 2, 4, 2, 1, 1 };
        
        int sum = 10;

        ps.buildSumMatrix( input, sum );
        
        ps.printSumMatrix(input, sum);

        System.out.println( "INPUT: " + Arrays.toString( input ) );
        System.out.println( "REQUESTED SUM: " + sum );

        if ( ps.isSumPossible( sum, input.length ) ) {

            // Now recursively traverse sumPossible[][] to find all 
            // paths from sumPossible[n-1][sum] 
            ArrayList<Integer> result = new ArrayList<>();
            ps.printSubsets( input, input.length - 1, sum, result );
        } else {
            System.out.println( "There are no subsets with" + " sum " + sum );
        }
    }
}
