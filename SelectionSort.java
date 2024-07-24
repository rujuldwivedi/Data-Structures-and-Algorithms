public class SelectionSort
{
    /*
     * Here we'll do the following:
     * 1. Selection Sort
     */

    // Function to sort an array using selection sort
    public static void selectionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /*
     * The time complexity of the above approach is O(n^2)
     */

    public static void main(String[] args)
    {
        int[] arr = { 3, 1, 2, 4, 0, 1, 3, 2 };
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
