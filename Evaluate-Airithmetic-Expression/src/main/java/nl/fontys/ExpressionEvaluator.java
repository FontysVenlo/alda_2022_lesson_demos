package nl.fontys;

import java.util.Stack;

/**
 * Example from Algorithms, Sedgewick and Wayne, 4th edition, 2011 
 * @author hvd
 */
public class ExpressionEvaluator {

    public static double evaluate( String expression ) {

        // Operator stack for +,-,*,/,sqrt
        Stack<Operation> operators = new Stack<>();
        Stack<Double> values = new Stack<>();

        for ( String element : expression.split(" ") ) {
            
            if ( element.equals( "(") ) {
                // Do nothing
            } else {
                Operation operator = Operation.fromString( element );

                if ( operator != null ) {
                    // It's an operator
                    operators.add( operator );
                } else if ( element.equals( ")" ) ) {
                    // Some calculation work to do
                    Operation op = operators.pop();
                    double calculatedValue = 0;
                    
                    if ( op.isUnary()) {
                        calculatedValue = op.applyAsDouble(values.pop() );
                    } else {
                        calculatedValue = op.applyAsDouble(values.pop(), values.pop() );
                    }
                    
                    values.push( calculatedValue );
                    
                } else {
                    // It must be a new value
                    values.push( Double.parseDouble( element ) );
                }
            }
        }
        return values.pop();
    }

}
