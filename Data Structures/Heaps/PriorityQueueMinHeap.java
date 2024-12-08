import java.util.*;

public class PriorityQueueMinHeap
{

    /*
     * Here we'll do the following:
     * 1. Implement Priority Queue using Heap.
     * 2. Implement Priority Queue, but operating with max heap.
     * 3. Print Kth largest element in an array.
     */

     // Function to implement Priority Queue using Min Heap and then using Max Heap
    public static void implementation()
    {
        // Default Priority Queue is Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(400);

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());

        while(!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }

        // Priority Queue but using Max Heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq2.add(10);
        pq2.add(30);
        pq2.add(20);
        pq2.add(400);

        System.out.println(pq2.peek());
        System.out.println(pq2.poll());
        System.out.println(pq2.peek());

        while(!pq2.isEmpty())
        {
            System.out.println(pq2.poll());
        }
    }

    // Function to print Kth largest element in an array
    public static void kthLargestElement(int[] arr, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++)
        {
            pq.add(arr[i]);

            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        System.out.println("The "+k+"th largest element is: "+pq.peek());
    }

    /*
     * For kth minimum element, we can use Max Heap.
     */

    public static void main(String[] args)
    {
        implementation();

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        kthLargestElement(arr, 4);
    }
}
