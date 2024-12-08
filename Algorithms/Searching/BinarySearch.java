public class BinarySearch
{
    /*
     * Here we'll do the following:
     * 1. Binary Search
     */

    /*
     * Iterative function to search for an element in a sorted array using binary search 
        public static int binarySearch(int[] arr, int key)
        {
            int low = 0;
            int high = arr.length - 1;
            while(low <= high)
            {
                int mid = low + (high - low) / 2;
                if(arr[mid] == key)
                    return mid;
                else if(arr[mid] > key)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
        }
     */

    // Recursive function to search for an element in a sorted array using binary search
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
            // If the middle element is greater than the key, then search in the left half of the array
            else if(arr[mid] > key)
                return binarySearch(arr, low, mid - 1, key);
            // If the middle element is less than the key, then search in the right half of the array
            else
                return binarySearch(arr, mid + 1, high, key);
        }
    }

    /*
     * The time complexity of binary search is O(log n) where n is the number of elements in the array.
     */

    public static void main(String[] args)
    {
        // Initialize the array
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Initialize the key to be searched
        int key = 10;
        // Search for the key in the array
        int index = binarySearch(arr, 0, arr.length - 1, key);
        // If the key is present in the array, then print the index of the key
        if(index != -1)
            System.out.println("Element found at index: " + index);
        // If the key is not present in the array, then print that the element is not found
        else
            System.out.println("Element not found");
    }
}
