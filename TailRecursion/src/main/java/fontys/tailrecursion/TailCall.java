package fontys.tailrecursion;

import java.util.stream.Stream;

/**
 * @author From Venkat Subramaniam - Functional Programming in Java - ch7
 * @param <T>
 */
@FunctionalInterface
public interface TailCall<T> {

    TailCall<T> apply();

    default boolean isComplete() {
        return false;
    }

    default T result() {
        return null;
    }

    default T invoke() {
        return Stream
                .iterate( this, TailCall::apply )
                .filter( TailCall::isComplete )
                .findFirst()
                .get()  // the get of an Optional
                .result();
    }

    static <T> TailCall<T> done( final T value ) {
        return new TailCall<T>() {
            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public T result() {
                return value;
            }

            @Override
            public TailCall<T> apply() {
                return null; // this override is not actually used
            }
        };
    }
}
