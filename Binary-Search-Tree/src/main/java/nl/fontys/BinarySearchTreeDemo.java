package nl.fontys;

/**
 * Binary Search Tree demo.
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class BinarySearchTreeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BinarySearchTree<String, String> bst;
        
        bst = new BinarySearchTree<>();
        put(bst, "FBGADICEH");
        bst.print();
        
        System.out.println();
        
        bst = new BinarySearchTree<>();
        put(bst, "ABCDEFGHI");
        bst.print();
        
        System.out.println();
        
        bst = new BinarySearchTree<>();
        put(bst, "BADF");
        bst.print();
    }
    
    private static void put(BinarySearchTree<String, String> bst, String keys){
        for (int i = 0; i < keys.length(); i++) {
            bst.put("" + keys.charAt(i), null);
        }
    }
    
}
