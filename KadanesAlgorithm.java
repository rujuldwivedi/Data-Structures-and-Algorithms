public class KadanesAlgorithm
{

    /*
    * Here we'll do the following:
    * 1. Largest Contiguous Sum Subarray using Brute Force
    * 2. Largest Contiguous Sum Subarray using Kadane's Algorithm
     */    

    // Function to find the largest contiguous sum subarray using brute force
    public static int largestContiguousSumSubarrayBruteForce(int[] nums)
    {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            for (int j = i; j < n; j++)
            {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /*
     * The time complexity of the above approach is O(n^2)
     */

    // Function to find the largest contiguous sum subarray using Kadane's Algorithm
    public static int largestContiguousSumSubarrayKadane(int[] nums)
    {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += nums[i];
            if (sum < 0)
                sum = 0;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    /*
     * The time complexity of the above approach is O(n)
     */

    public static void main(String[] args)
    {
        int[] nums = { -5, 4, 6, -3, 4, -1 };
        System.out.println(largestContiguousSumSubarrayBruteForce(nums));
        System.out.println(largestContiguousSumSubarrayKadane(nums));
    }
}
