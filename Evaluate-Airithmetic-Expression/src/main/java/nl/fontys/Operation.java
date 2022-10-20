package nl.fontys;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/**
 * Derived from Effective Java 2nd ed.
 *
 * @author Joshua Bloch
 *
 */
public enum Operation implements DoubleUnaryOperator, DoubleBinaryOperator {

    PLUS( "+" ) {
        @Override
        public double applyAsDouble( double x, double y ) {
            return x + y;
        }
    },
    MINUS( "-" ) {
        @Override
        public double applyAsDouble( double x, double y ) {
            return x - y;
        }
    },
    TIMES( "*" ) {
        @Override
        public double applyAsDouble( double x, double y ) {
            return x * y;
        }
    },
    DIVIDE( "/" ) {
        @Override
        public double applyAsDouble( double x, double y ) {
            return x / y;
        }
    },
    SQRT( "sqrt" ) {
        @Override
        public double applyAsDouble( double x ) {
            return Math.sqrt( x );
        }
        @Override
        public boolean isUnary(){
            return true;
        }
    };

    private final String symbol;

    Operation( String symbol ) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // Implementing a fromString method on an enum type - Page 154
    private static final Map<String, Operation> stringToEnum
            = new HashMap<String, Operation>();

    static { // Initialize map from constant name to enum constant
        for ( Operation op : values() ) {
            stringToEnum.put( op.toString(), op );
        }
    }

    // Returns Operation for string, or null if string is invalid
    public static Operation fromString( String symbol ) {
        return stringToEnum.get( symbol );
    }

    @Override
    public double applyAsDouble( double operand ) {
        throw new IllegalArgumentException( "This is not a unary operator" );
    }

    @Override
    public double applyAsDouble( double left, double right ) {
        throw new IllegalArgumentException( "This is not a binary operator" );
    }
    
    public boolean isUnary(){
        return false;
    }
}
