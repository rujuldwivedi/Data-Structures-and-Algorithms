import java.util.*;

public class Sets
{
    public static void main(String[] args)
    {
        // Creating a HashSet
        Set<String> hashSet = new HashSet<>();
        
        // Adding elements
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("apple"); // Duplicate element, won't be added
        
        // Printing elements
        System.out.println("HashSet: " + hashSet); // Order not guaranteed
        
        // Creating a TreeSet
        Set<String> treeSet = new TreeSet<>();
        
        // Adding elements
        treeSet.add("orange");
        treeSet.add("banana");
        treeSet.add("apple");
        
        // Printing elements
        System.out.println("TreeSet: " + treeSet); // Sorted order
        
        // Creating a LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();
        
        // Adding elements
        linkedHashSet.add("orange");
        linkedHashSet.add("banana");
        linkedHashSet.add("apple");
        
        // Printing elements
        System.out.println("LinkedHashSet: " + linkedHashSet); // Insertion order maintained
    }
}