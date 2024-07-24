import java.util.*;

public class HashMaps
{

    /*
     * Here we'll do the following:
     * Understand the inner workings of a hashmap by implementing our own hashmap from scratch.
     */

    static class MyHashMap
    {
        private static final int SIZE = 1000;
        private List<Entry>[] entries;

        @SuppressWarnings("unchecked")
        public MyHashMap()
        {
            entries = new List[SIZE];
        }

        public void put(int key, int value)
        {
            int index = key % SIZE;
            if (entries[index] == null)
            {
                entries[index] = new ArrayList<>();
            }
            for (Entry entry : entries[index])
            {
                if (entry.key == key)
                {
                    entry.value = value;
                    return;
                }
            }
            entries[index].add(new Entry(key, value));
        }

        public int get(int key)
        {
            int index = key % SIZE;
            if (entries[index] == null)
            {
                return -1;
            }
            for (Entry entry : entries[index])
            {
                if (entry.key == key)
                {
                    return entry.value;
                }
            }
            return -1;
        }

        public void remove(int key)
        {
            int index = key % SIZE;
            if (entries[index] == null)
            {
                return;
            }
            for (Entry entry : entries[index])
            {
                if (entry.key == key)
                {
                    entries[index].remove(entry);
                    return;
                }
            }
        }

        private static class Entry
        {
            private int key;
            private int value;

            public Entry(int key, int value)
            {
                this.key = key;
                this.value = value;
            }
        }
    }

    public static void main(String[] args)
    {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2)); // 2
        System.out.println(map.get(3)); // 3
        map.put(1, 4);
        System.out.println(map.get(1)); // 4
        map.remove(1);
        System.out.println(map.get(1)); // -1
    }
    
}

/*

 * Inner Workings:

 * A hashmap is a data structure that stores key-value pairs. It uses a technique called hashing to store the key-value pairs. The key is hashed to get an index in the array where the value is stored.
 * The key is hashed using a hash function. The hash function is a function that takes the key as input and returns an index in the array. The hash function should be deterministic,
 * i.e., it should return the same index for the same key. The hash function should be fast. The hash function should distribute the keys uniformly across the array.
 * The hash function should minimize collisions. A collision occurs when two keys hash to the same index. To handle collisions, we use a technique called chaining.
 * In chaining, we store a linked list at each index in the array. If two keys hash to the same index, we store them in the linked list at that index. To get the value of a key,
 * we hash the key to get the index and then traverse the linked list at that index to find the key. The time complexity of get, put, and remove operations in a hashmap is O(1) on average.
 * The space complexity of a hashmap is O(n), where n is the number of key-value pairs. The load factor of a hashmap is the ratio of the number of key-value pairs to the size of the array.
 * The load factor determines when the hashmap should be resized. When the load factor exceeds a certain threshold, the hashmap is resized to reduce collisions.
 * The resizing involves creating a new array with a larger size and rehashing all the key-value pairs. The time complexity of resizing is O(n), where n is the number of key-value pairs.

 * The hashmap implementation in Java uses an array of linked lists to handle collisions. It uses a hash function that takes the key and the size of the array as input.
 * It uses a load factor of 0.75. It resizes the array when the load factor exceeds 0.75.It uses a technique called open addressing to handle collisions.
 * In open addressing, if a key hashes to an index that is already occupied, we probe for the next available index. The probing technique can be linear probing, quadratic probing, or double hashing.
 * It uses linear probing to handle collisions. It uses a technique called rehashing to resize the array. In rehashing, we create a new array with a larger size and rehash all the key-value pairs.
 * It uses a technique called lazy deletion to handle deletions. In lazy deletion, we mark a key as deleted but do not remove it from the array. It uses a technique called tombstone to mark a key as deleted.
 * It uses a technique called backward shift deletion to handle deletions. In backward shift deletion, we shift the keys to the left when a key is deleted.

 * The hashmap implementation in Java is not thread-safe. If multiple threads access a hashmap concurrently, it may lead to data corruption. To make a hashmap thread-safe,
 * we can use the ConcurrentHashMap class. The ConcurrentHashMap class provides thread-safe operations on a hashmap. It uses a technique called lock striping to achieve thread safety.
 * The lock striping technique divides the hashmap into segments and locks each segment independently. This allows multiple threads to access different segments concurrently.
 * The time complexity of get, put, and remove operations in a ConcurrentHashMap is O(1) on average. The space complexity of a ConcurrentHashMap is O(n), where n is the number of key-value pairs.
 * 
 */