public class BubbleSort
{
    /*
    * Here we'll do the following:
    * 1. Bubble Sort
    */   

    // Function to sort an array using bubble sort
    public static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    /*
    * The time complexity of the above approach is O(n^2)
    */

    public static void main(String[] args)
    {
        int[] arr = { 3, 1, 2, 4, 0, 1, 3, 2 };
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
