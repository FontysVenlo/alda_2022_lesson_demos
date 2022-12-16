package nl.fontys;

/**
 * Derived from Sedgewick & Wayne: Algorithms 4th Ed.
 * 
 * @param <V>
 */
public class RWayTrie<V> implements StringSymbolTable<V> {

    private static class Node<T> {

        private T value;
        private final Node<T>[] next = new Node[R];
    }

    private static final int R = 256;  // Size alphabet
    private Node<V> root = new Node<>();

    @Override
    public void put(String key, V value) {
        root = put(root, key, value, 0);
    }

    private Node<V> put(Node<V> node, String key, V value, int charIndex) {

        if (node == null) {
            node = new Node<>();
        }
        if (charIndex == key.length()) {
            node.value = value;
            return node;
        }
        char c = key.charAt(charIndex);
        node.next[c] = put(node.next[c], key, value, charIndex + 1);
        return node;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    @Override
    public V get(String key) {
        Node<V> node = get(root, key, 0);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node<V> get(Node<V> node, String key, int charIndex) {
        if (node == null) {
            return null;
        }
        if (charIndex == key.length()) {
            return node;
        }
        char c = key.charAt(charIndex);
        return get(node.next[c], key, charIndex + 1);
    }

    @Override
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node<V> delete(Node<V> node, String key, int charIndex) {

        if (node == null) {
            return null;
        }

        // This if-else will traverse down to your key Node and 
        // sets its value to null.
        if (charIndex == key.length() ) {
            node.value = null;
        } else {
            char c = key.charAt(charIndex);
            // The new sub-trie node.next[c] is the old one from which
            // the key-value pair is removed.
            node.next[c] = delete(node.next[c], key, charIndex + 1);
        }
        
        // After the recursive call, 'traversal to root' again to clean up
        // unnecessary nodes.
        if ( node.value != null ) {
            return node;
        }
        
        // If there is at least one sub-trie in this Node's array,
        // the node itself is returned.
        for ( char c = 0; c < R; c++){
            if ( node.next[c] != null) {
                return node;
            }
        }

        // If this code is reached, there is no sub-trie anymore and this
        // branche in your tree can be cut.
        return null;
    }
}
