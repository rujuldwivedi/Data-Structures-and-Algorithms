import java.util.*;

public class MedianOfRunningStreams
{

    /*
     * Here we'll do the following:
     * 1. Find the median of running streams.
     */

    // Function to find the median of running streams
    public static double[] findMedian(int[] arr)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double[] medians = new double[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            if(maxHeap.isEmpty() || arr[i] < maxHeap.peek())
            {
                maxHeap.add(arr[i]);
            }
            else
            {
                minHeap.add(arr[i]);
            }

            if(maxHeap.size() > minHeap.size() + 1)
            {
                minHeap.add(maxHeap.poll());
            }
            else if(minHeap.size() > maxHeap.size())
            {
                maxHeap.add(minHeap.poll());
            }

            if(maxHeap.size() == minHeap.size())
            {
                medians[i] = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            else
            {
                medians[i] = maxHeap.peek();
            }
        }

        return medians;
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 15, 10, 20, 3};

        double[] medians = findMedian(arr);

        for(int i = 0; i < medians.length; i++)
        {
            System.out.println(medians[i]);
        }
    }
}
