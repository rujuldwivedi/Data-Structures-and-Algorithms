public class QuickSort
{
    /*
     * Here we'll do the following:
     * 1. Quick Sort
     */

    // Function to sort an array using quick sort
    public static void quickSort(int[] arr, int low, int high)
    {
        // If the low index is less than the high index, then the array has more than one element
        // else it has only one element and then it is already sorted
        if(low >= high)
            return;
        else
        {
            //This will return the index of the pivot element while placing it at its correct position
            int pi = partition(arr, low, high);
            //Recursively sort the elements before the pivot element
            quickSort(arr, low, pi - 1);
            //Recursively sort the elements after the pivot element
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to partition the array
    public static int partition(int[] arr, int low, int high)
    {

        /*
         * Here we'll take the last element as the pivot element and place it at its
         * correct position in the sorted array. We'll place all the elements smaller
         * than the pivot element to the left of the pivot and all the elements greater
         * than the pivot element to the right of the pivot.
         * 
         */

        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j)
        {
            while (arr[i] <= pivot && i < high)
                i++;
            while (arr[j] > pivot && j > low)
                j--;
            if (i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        return j;
    }

    /*
     * The time complexity of the above approach is O(n*logn) as the partition functions takes O(n) time and the quickSort function takes O(log n) time.
     * The quick sort algorithm is not stable as it changes the relative order of equal elements.
     */

    public static void main(String[] args)
    {
        int[] arr = { 3, 1, 2, 4, 0, 1, 3, 2 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
