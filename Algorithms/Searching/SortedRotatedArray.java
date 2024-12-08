public class SortedRotatedArray
{
    /*
     * Here we'll do the following:
     * 1. Search for an element in a sorted rotated array
     */

    // Function to search for an element in a sorted rotated array
    public static int searchInSortedRotatedArray(int[] arr, int key)
    {
        // Initialize the low and high indexes
        int low = 0;
        int high = arr.length - 1;

        // Perform binary search
        return binarySearch(arr, low, high, key);
    }

    // Recursive function to search for an element in a sorted rotated array using binary search
    public static int binarySearch(int[] arr, int low, int high, int key)
    {
        // If the low index is greater than the high index, then the element is not present in the array
        if(low > high)
            return -1;
        else
        {
            // Find the middle index
            int mid = low + (high - low) / 2;
            // If the middle element is the key, then return the index of the middle element
            if(arr[mid] == key)
                return mid;
            // If the left half of the array is sorted
            if(arr[low] <= arr[mid])
            {
                // If the key lies in the left half of the array
                if(key >= arr[low] && key <= arr[mid])
                    return binarySearch(arr, low, mid - 1, key);
                // If the key lies in the right half of the array
                else
                    return binarySearch(arr, mid + 1, high, key);
            }
            // If the right half of the array is sorted
            else
            {
                // If the key lies in the right half of the array
                if(key >= arr[mid] && key <= arr[high])
                    return binarySearch(arr, mid + 1, high, key);
                // If the key lies in the left half of the array
                else
                    return binarySearch(arr, low, mid - 1, key);
            }
        }

        /*
         * We're basically cut-shorting the search space by half in each recursive call by discarding one half of the array and searching in the other half only.
         */
    }

    public static void main(String[] args)
    {
        // Initialize the array
        int[] arr = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Initialize the key to be searched
        int key = 10;
        // Search for the key in the array
        int index = searchInSortedRotatedArray(arr, key);
        // Print the index of the key
        System.out.println("The index of the key is: " + index);
    }
}
