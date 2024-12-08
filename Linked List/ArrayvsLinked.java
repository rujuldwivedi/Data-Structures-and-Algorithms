import java.util.*;

public class ArrayvsLinked
{
    public static void main(String[] args)
    {
        // ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("ArrayList: " + arrayList);

        // LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("LinkedList: " + linkedList);

        // Adding elements at the beginning
        long startTime = System.nanoTime();
        arrayList.add(0, 0); // Adding 0 at the beginning
        long arrayListEndTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.add(0, 0); // Adding 0 at the beginning
        long linkedListEndTime = System.nanoTime() - startTime;

        System.out.println("ArrayList time for adding at beginning: " + arrayListEndTime + " nanoseconds");
        System.out.println("LinkedList time for adding at beginning: " + linkedListEndTime + " nanoseconds");

        // Removing elements from the end
        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() - 1); // Removing last element
        arrayListEndTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.remove(linkedList.size() - 1); // Removing last element
        linkedListEndTime = System.nanoTime() - startTime;

        System.out.println("ArrayList time for removing from end: " + arrayListEndTime + " nanoseconds");
        System.out.println("LinkedList time for removing from end: " + linkedListEndTime + " nanoseconds");

        // Getting elements by index
        startTime = System.nanoTime();
        int element1 = arrayList.get(1); // Getting element at index 1
        System.out.println("Element at index 1 in ArrayList: " + element1);
        arrayListEndTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        int element2 = linkedList.get(1); // Getting element at index 1
        System.out.println("Element at index 1 in LinkedList: " + element2);
        linkedListEndTime = System.nanoTime() - startTime;

        System.out.println("ArrayList time for getting by index: " + arrayListEndTime + " nanoseconds");
        System.out.println("LinkedList time for getting by index: " + linkedListEndTime + " nanoseconds");
    }
}