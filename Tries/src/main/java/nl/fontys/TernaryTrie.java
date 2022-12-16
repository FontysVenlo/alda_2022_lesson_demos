package nl.fontys;

/**
 * Derived from Sedgewick & Wayne: Algorithms 4th Ed.
 *
 * @param <V>
 */
public class TernaryTrie<V> implements StringSymbolTable<V> {

    private class Node {
        private V value;
        private char c;
        private Node left, mid, right;
    }

    private Node root;

    @Override
    public void put(String key, V value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, V value, int charIndex) {
        char c = key.charAt(charIndex);

        if (node == null) {
            node = new Node();
            node.c = c;
        }

        if (c < node.c) {
            node.left = put(node.left, key, value, charIndex);
        } else if (c > node.c) {
            node.right = put(node.right, key, value, charIndex);
        } else if (charIndex < key.length() - 1) {
            node.mid = put(node.mid, key, value, charIndex + 1);
        } else {
            node.value = value;
        }
        return node;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    @Override
    public V get(String key) {
        Node node = get(root, key, 0);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node get(Node node, String key, int charIndex) {
        if (node == null) {
            return null;
        }
        char c = key.charAt(charIndex);
        if (c < node.c) {
            return get(node.left, key, charIndex);
        } else if (c > node.c) {
            return get(node.right, key, charIndex);
        } else if (charIndex < key.length() - 1) {
            return get(node.mid, key, charIndex + 1);
        } else {
            return node;
        }
    }
    
    @Override
    public void delete(String key) {
        root = delete(root, key, 0);
    }     
        
        
    private Node delete(Node node, String key, int charIndex) {
        
        if (node == null) {
            return null;
        }
        char c = key.charAt(charIndex);
        if (c < node.c) {
            node.left = delete(node.left, key, charIndex);
        } else if (c > node.c) {
            node.right = delete(node.right, key, charIndex);
        } else if (charIndex < key.length() - 1) {
            node.mid = delete(node.mid, key, charIndex + 1);
        } else {
            node.value = null;
        }
        
        // Clean trie after deletion of leaf node
        if (node.left == null && node.mid == null && node.right == null && node.value == null) {
            return null;
        } else {
            return node;
        }             
    }
}
