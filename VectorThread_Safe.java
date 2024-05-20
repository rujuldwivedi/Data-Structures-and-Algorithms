import java.util.*;

public class VectorThread_Safe
{
    public static void main(String[] args)
    {
        Vector<Integer> vector = new Vector<>();

        // Thread 1: Add elements to the vector
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
            vector.add(i);
        });

        // Thread 2: Remove elements from the vector
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
            vector.remove(0);
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
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        // Print the size of the vector
        System.out.println("Vector size: " + vector.size()); // Expected: 0
    }
}
