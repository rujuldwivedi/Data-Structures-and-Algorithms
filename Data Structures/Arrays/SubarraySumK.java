import java.util.*;

public class SubarraySumK
{
    
    /*
     * Here we'll do the following:
     * 1. Find the subarray with the given sum k
     * 2. Find largest subarray with equal number of 0s and 1s
     */

     // Function to find the subarray with the given sum k
     public static void subarraySumK(int[] arr, int k)
     {
         // Create a hashmap to store the sum and the index
         HashMap<Integer, Integer> map = new HashMap<>();
         int sum = 0;
         int start = 0;
         int end = 0;
         for(int i = 0; i < arr.length; i++)
         {
             sum += arr[i];
             if(sum == k)
             {
                 start = 0;
                 end = i;
                 break;
             }
             if(map.containsKey(sum - k))
             {
                 start = map.get(sum - k) + 1;
                 end = i;
                 break;
             }
             map.put(sum, i);
         }
         if(start == 0 && end == 0)
         {
             System.out.println("No subarray found with sum " + k + ".");
         }
         else
         {
             System.out.print("Subarray found with sum " + k +": ");
            System.out.println("From index " + start + " to " + end + ".");
         }
     }

     // Function to find the largest subarray with equal number of 0s and 1s
        public static void largestSubarray(int[] arr)
        {
            // Create a hashmap to store the sum and the index
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int start = 0;
            int end = 0;
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i] == 0)
                {
                    arr[i] = -1;
                    // Just to make the problem simpler, we'll convert 0s to -1s
                    // and then we'll find the subarray with sum 0
                }
                sum += arr[i];
                if(sum == 0)
                {
                    start = 0;
                    end = i;
                }
                if(map.containsKey(sum))
                {
                    if(i - map.get(sum) > end - start)
                    {
                        start = map.get(sum) + 1;
                        end = i;
                    }
                }
                else
                {
                    map.put(sum, i);
                }
            }
            if(start == 0 && end == 0)
            {
                System.out.println("No subarray found with equal number of 0s and 1s .");
            }
            else
            {
                System.out.print("Largest subarray found with equal number of 0s and 1s: ");
                System.out.println("From index " + start + " to " + end + ".");
            }
        }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 9;
        subarraySumK(arr, k);
        int[] arr1 = {0, 1, 0, 1, 1, 0, 0};
        largestSubarray(arr1);
    }
}
