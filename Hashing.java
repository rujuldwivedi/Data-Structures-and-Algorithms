import java.util.*;

public class Hashing
{
    public static void main(String[] args)
    {
        // Create a new HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Add elements to the HashMap
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Print the HashMap
        System.out.println(map);

        // Get the value of the key 2
        System.out.println(map.get(2));

        // Check if the key 2 is present in the HashMap
        System.out.println(map.containsKey(2));

        // Check if the value "Two" is present in the HashMap
        System.out.println(map.containsValue("Two"));

        // Remove the key 2 from the HashMap
        map.remove(2);

        // Print the HashMap
        System.out.println(map);

        // Get the size of the HashMap
        System.out.println(map.size());

        // Check if the HashMap is empty
        System.out.println(map.isEmpty());

        // Create a new HashMap
        HashMap<Integer, String> map2 = new HashMap<>();

        // Add elements to the HashMap
        map2.put(4, "Four");
        map2.put(5, "Five");

        // Print the HashMap
        System.out.println(map2);

        // Add all the elements of map2 to map
        map.putAll(map2);

        // Print the HashMap
        System.out.println(map);

        // Clear the HashMap
        map.clear();

        // Print the HashMap
        System.out.println(map);

        // Create a new LinkedHashMap
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();

        // Add elements to the LinkedHashMap
        linkedMap.put(1, "One");
        linkedMap.put(2, "Two");
        linkedMap.put(3, "Three");

        // Print the LinkedHashMap
        System.out.println(linkedMap);

        // Create a new HashSet
        HashSet<Integer> set = new HashSet<>();

        // Add elements to the HashSet
        set.add(1);
        set.add(2);
        set.add(3);

        // Print the HashSet
        System.out.println(set);

        // Check if the element 2 is present in the HashSet
        System.out.println(set.contains(2));

        // Remove the element 2 from the HashSet
        set.remove(2);

        // Print the HashSet
        System.out.println(set);

        // Get the size of the HashSet
        System.out.println(set.size());

        // Check if the HashSet is empty
        System.out.println(set.isEmpty());

        // Create a new TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Add elements to the TreeSet
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);

        // Print the TreeSet
        System.out.println(treeSet);
    }
}
