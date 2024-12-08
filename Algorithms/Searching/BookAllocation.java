public class BookAllocation
{
    /*
     * Here we'll do the following:
     * 1. Allocate minimum number of pages to each student such that the maximum number of pages allocated to a student is minimized
     */

    // Function to allocate minimum number of pages to each student such that the maximum number of pages allocated to a student is minimized
    public static int allocateMinimumPages(int[] arr, int k)
    {
        // Initialize the low and high indexes
        int low = 0;
        int high = 0;

        // Initialize the result
        int result = -1;

        // Find the sum of all the pages in the array
        for(int i = 0; i < arr.length; i++)
            high += arr[i];

        // Perform binary search
        while(low <= high)
        {
            // Find the middle index
            int mid = low + (high - low) / 2;

            // If the current number of pages is feasible
            if(isFeasible(arr, arr.length, k, mid))
            {
                // Update the result
                result = mid;
                // Search for a smaller number of pages
                high = mid - 1;
            }
            // If the current number of pages is not feasible
            else
                // Search for a larger number of pages
                low = mid + 1;
        }

        // Return the result
        return result;
    }

    // Function to check if the current number of pages is feasible
    public static boolean isFeasible(int[] arr, int n, int k, int ans)
    {
        // Initialize the students required
        int studentsRequired = 1;
        // Initialize the sum of pages read by the current student
        int sum = 0;

        // Traverse the array
        for(int i = 0; i < n; i++)
        {
            // If the sum of pages read by the current student and the current number of pages is greater than the answer
            if(sum + arr[i] > ans)
            {
                // Increment the number of students required
                studentsRequired++;
                // Update the sum of pages read by the current student
                sum = arr[i];
            }
            // If the sum of pages read by the current student and the current number of pages is less than or equal to the answer
            else
                // Update the sum of pages read by the current student
                sum += arr[i];
        }

        // If the number of students required is less than or equal to the given number of students
        if(studentsRequired <= k)
            return true;
        else
            return false;
    }

    /*
     * Side question:
     * Aggressive Cows
     * 
     * Here's the code: 
     public static int aggressiveCows(int[] arr, int n, int c)
     {
      Arrays.sort(arr);
     int low = 0;
     int high = arr[n - 1] - arr[0];
     int result = -1;
     while(low <= high)
     {
     int mid = low + (high - low) / 2;
     if(isFeasible(arr, n, c, mid))
     {
     result = mid;
     high = mid - 1;
     }
     else
     low = mid + 1;
     }
     return result;
     } 
     public static boolean isFeasible(int[] arr, int n, int c, int ans)
     {
     int cowsPlaced = 1;
     int pos = arr[0];
     for(int i = 1; i < n; i++)
     {
     if(arr[i] - pos >= ans)
     {
     cowsPlaced++;
     pos = arr[i];
     }
     }
     if(cowsPlaced >= c)
     return true;
     else
     return false;
     }
     */

    public static void main(String[] args)
    {
        // Initialize the array
        int[] arr = {12, 34, 67, 90};
        // Initialize the number of students
        int k = 2;

        // Allocate minimum number of pages to each student such that the maximum number of pages allocated to a student is minimized
        System.out.println("The minimum number of pages allocated to each student such that the maximum number of pages allocated to a student is minimized is: " + allocateMinimumPages(arr, k));
    }
}
