package fontys.tailrecursion;

import java.util.Arrays;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class DemoMethodCallStack {

    public static void main(String[] args) {
        doSomething();
    }

    private static void doSomething() {
        doAnotherThing();
    }

    private static void doAnotherThing() {
        doFinalThing();
    }

    private static void doFinalThing() {
        Arrays.stream( Thread.currentThread()
                            .getStackTrace())
                            .forEach(s -> System.out.println( s.getMethodName() + "(" + s.getFileName() + ":" + s.getLineNumber() + ")"));
    }

}
