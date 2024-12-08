import java.util.*;

public class SlidingWindow
{

    /*
     * Here we'll do the following:
     * 1. Find the maximum element in every subarray of size k
     */

     // Function to find the maximum element in every subarray of size k
        public static void maxInSubarray(int[] arr, int k)
        {
            ArrayDeque<Integer> dq = new ArrayDeque<>();

            int i;
            for(i=0; i<k; i++)
            {
                while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
                dq.removeLast();
                dq.addLast(i);
            }

            for(; i<arr.length; i++)
            {
                System.out.print(arr[dq.peek()] + " ");

                while(!dq.isEmpty() && dq.peek() <= i-k)
                dq.removeFirst();

                while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
                dq.removeLast();

                dq.addLast(i);
            }

            System.out.print(arr[dq.peek()]);

        }

    public static void main(String[] args)
    {
        int[] arr = { 4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5};
        int k = 3;

        maxInSubarray(arr, k);
    }
}
