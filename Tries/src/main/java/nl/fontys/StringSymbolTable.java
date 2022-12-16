package nl.fontys;

/**
 *  Derived from Sedgewick & Wayne: Algorithms 4th Ed.
 * @param <V> Type of Value
 */

public interface StringSymbolTable<V> {

    void put( String key, V value );

    V get( String key );

    void delete( String key );

}
