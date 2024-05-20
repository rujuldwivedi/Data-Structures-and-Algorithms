import java.util.*;

public class ArrayListsThread_Safe
{
    public static void main(String[] args)
    {
        List<Integer> arrayList = Collections.synchronizedList(new ArrayList<>());

        // Thread 1: Add elements to the ArrayList
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
            arrayList.add(i);
        });

        // Thread 2: Remove elements from the ArrayList
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
            arrayList.remove(0);
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try
        {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // Print the size of the ArrayList
        System.out.println("ArrayList size: " + arrayList.size()); // Expected: 0 or an error (due to concurrent modification)
    }
}
