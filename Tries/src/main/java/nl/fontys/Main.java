package nl.fontys;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class Main {
    
    public static void main(String[] args) {
        
        //StringSymbolTable<Integer> trie = new RWayTrie<>();
        StringSymbolTable<Integer> trie = new TernaryTrie<>();
        
        trie.put("shells", 15);
        trie.put("by", 4);
        trie.put("are", 12);
        trie.put("the", 8);
        trie.put("sells", 11);
        trie.put("sea", 14);
        trie.put("surely", 13);
        trie.put("shore", 7);
        trie.put("she", 10);
        trie.put("sur", 0);
        
        System.out.println("Value belonging to shells is : " + trie.get("shells"));
        System.out.println("Value belonging to she is : " + trie.get("she"));
        System.out.println("Value belonging to shore is : " + trie.get("shore"));

        System.out.println("DELETION OF SHE AND SHORE");
        trie.delete("she");
        trie.delete("shore");
        
        System.out.println("Value belonging to shells is : " + trie.get("shells"));
        System.out.println("Value belonging to she is : " + trie.get("she"));
        System.out.println("Value belonging to shore is : " + trie.get("shore"));
    }
}
