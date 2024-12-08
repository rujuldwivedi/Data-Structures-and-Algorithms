class ListNode
{
    int key, val; // key and value
    ListNode next; // next node

    //Here we are initializing the key, value and next node for the hashmap because we are using chaining method to resolve the collisions
    //Chaining is a method of resolving collisions. A collision occurs when two keys hash to the same index in the hash table.
    //In chaining, each bucket is independent, and has some sort of list of entries with the same index.
    //So if the keys are same then we will add the value to the next node of the same key.
    //What this does is that it creates a linked list of all the values that have the same key.
    //Then when we want to get the value of a key we will traverse the linked list and get the value of the key.

    //For example:
    //Suppose we have a key 1 and value 1 and we add it to the hashmap.
    //Then we have another key 1 and value 2 and we add it to the hashmap.
    //Here the key is same but the value is different.
    //So we will add the value 2 to the next node of the key 1.
    //Then when we want to get the value of key 1 we will traverse the linked list and get the value of the key 1.
    //But what will the value be? It will be the value of the last node of the linked list.
    //So the value of key 1 will be 2.
    //And why is that? Because the value of the key 1 was updated to 2 in the last node of the linked list.

    //The time complexity of this method is O(1) for the best case and O(n) for the worst case.

    public ListNode(int key, int val, ListNode next) // constructor
    {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
class MyHashMap
{
    static final int size = 19997; // size of the hashmap
    //The size of the hashmap is 19997 because it is a prime number.
    //We could have used any prime number but we used 19997 because it is a large prime number.
    static final int mult = 12582917; // multiplier
    //The multiplier is 12582917 because it is also a prime number.
    //We could have used any prime number but we used 12582917 because it is also a large prime number.

    //The reason we are using prime numbers is because they are less likely to have common factors with other numbers.
    //This means that the hash function will be more likely to distribute the keys evenly across the hashmap.
    //And why is that? Because the hash function is the remainder of the key divided by the size of the hashmap.
    //Also why do we want to distribute the keys evenly across the hashmap? Because if the keys are not distributed evenly then the time complexity of the hashmap will be O(n) instead of O(1).

    ListNode[] data; // data array
    //This is the underlying data structure of the hashmap.
    public MyHashMap()
    {
        this.data = new ListNode[size]; // initializing the data array
    }
    private int hash(int key)
    {
        //The hash function is the remainder of the key multiplied by the multiplier divided by the size of the hashmap.
        //This helps to distribute the keys evenly across the hashmap.
        return (int)((long)key * mult % size); // hash function
    }
    public void put(int key, int val)
    {
        remove(key);
        // remove the key if it already exists because we are using chaining method to resolve the collisions sowe are basically updating the value of the key
        int h = hash(key);
        // get the hash of the key
        ListNode node = new ListNode(key, val, data[h]);
        // create a new node with the key, value and next node
        data[h] = node;
        // add the node to the data array
    }
    public int get(int key)
    {
        int h = hash(key);
        // get the hash of the key
        ListNode node = data[h];
        // get the node from the data array
        for(; node != null; node = node.next)
        {
            //Here we are traversing the linked list to get the value of the key.
            if(node.key == key)
            return node.val;
        }
        return -1;
    }
    public void remove(int key)
    {
        int h = hash(key);
        // get the hash of the key
        ListNode node = data[h];
        // get the node from the data array
        if(node == null)
        return;
        if(node.key == key)
        data[h] = node.next; // remove the node
        //How does this work?
        //If the key is the first node of the linked list then we will remove the first node.
        //And how do we do that? We will set the next node of the first node as the first node.
        else
        {
            //Here we are traversing the linked list to remove the node.
            for(; node.next != null; node = node.next)
            {
                if(node.next.key == key)
                //If the key is the next node of the linked list then we will remove the next node.
                {
                    node.next = node.next.next;
                    return;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        MyHashMap map = new MyHashMap();
        // create a new hashmap
        map.put(1, 1);
        // add key 1 and value 1
        map.put(1, 2);
        // add key 1 and value 2
        System.out.println(map.get(1));
        // get the value of key 1
        map.remove(1);
        // remove key 1
        System.out.println(map.get(1));
        // get the value of key 1
    }
}