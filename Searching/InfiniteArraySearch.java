public class InfiniteArraySearch
{
    /*
     * Here we'll do the following:
     * 1. Search in an infinite array
     */

    // Function to search for an element in an infinite array
    public static int searchInInfiniteArray(int[] arr, int key)
    {
        // Initialize the low and high indexes
        int low = 0;
        int high = 1;

        // Find the high index
        while(arr[high] < key)
        {
            low = high;
            high = 2 * high;
        }

        // Perform binary search
        return binarySearch(arr, low, high, key);
    }

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
     * The slight issue with this approach is that it is not efficient as we are traversing the array twice.
     * Also this can't be applied to smaller arrays as we'll get index out of bounds exception
     * For the key in the right half of the array, we'd have to start from the right.
     */

    public static void main(String[] args)
    {
        // Initialize the array
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        // Initialize the key to be searched
        int key = 10;
        // Search for the key in the array
        int index = searchInInfiniteArray(arr, key);
        if(index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found");
    }
}
