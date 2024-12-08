public class MergeSort
{

    /*
     * Here we'll do the following:
     * 1. Merge Sort
     */

    // Function to sort an array using merge sort
    public static void mergeSort(int[] arr, int low, int high)
    {
        // If the low index is less than the high index, then the array has more than one element
        // else it has only one element and then it is already sorted
        if(low >=high)
            return;
        else
        {
            // Find the middle index of the array
            int mid = low + (high - low) / 2;

            // Recursively sort the two halves of the array
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            // Merge the two halves
            merge(arr, low, mid, high);
        }
    }

    // Function to merge the two halves of the array
    public static void merge(int[] arr, int low, int mid, int high)
    {
        // Find the sizes of the two halves
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create two temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy the elements of the left half to the left temporary array
        for(int i = 0; i < n1; i++)
            L[i] = arr[low + i];

        // Copy the elements of the right half to the right temporary array
        for(int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge the two temporary arrays

        // Initial indexes of the two halves
        int i = 0, j = 0;

        // Initial index of the merged array
        int k = low;

        while(i < n1 && j < n2)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[] if there are any
        while(i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[] if there are any
        while(j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /*
     * The time complexity of merge sort is O(nlogn) in all the cases.
     */

    public static void main(String[] args)
    {
        int[] arr = { 3, 1, 2, 4, 0, 1, 3, 2 };
        mergeSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
