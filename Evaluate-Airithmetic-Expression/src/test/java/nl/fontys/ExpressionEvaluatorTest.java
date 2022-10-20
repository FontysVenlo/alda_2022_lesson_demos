package nl.fontys;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hvd
 */
public class ExpressionEvaluatorTest {

    public ExpressionEvaluatorTest() {
    }

    @Test
    public void testEvaluate() {
        System.out.println( "test expression evaluation" );

        String expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        double expectedResult = 101;

        assertThat( ExpressionEvaluator.evaluate( expression ) ).as("Simple calculation should result in 101").isCloseTo(expectedResult, Assertions.offset( 0.01 ) );
        //fail("The test case is a prototype.");
    }

    @Test
    public void testUnary() {
        System.out.println( "test unary operator" );

        String expression = "( 1 + ( sqrt ( 25 ) * ( 4 * 5 ) ) )";
        double expectedResult = 101;

        assertThat( ExpressionEvaluator.evaluate( expression ) ).as("Simple calculation should result in 101").isCloseTo(expectedResult, Assertions.offset( 0.01 ) );
        //fail("The test case is a prototype.");
    }
}
