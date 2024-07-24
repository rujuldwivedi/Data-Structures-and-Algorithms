public class InsertionSort
{
    /*
     * Here we'll do the following:
     * 1. Insertion Sort
     */

    // Function to sort an array using insertion sort
    public static void insertionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /*
     * The time complexity of the above approach is O(n^2)
     */

    public static void main(String[] args)
    {
        int[] arr = { 3, 1, 2, 4, 0, 1, 3, 2 };
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
