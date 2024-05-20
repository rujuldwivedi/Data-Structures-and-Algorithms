import java.util.*;

class MergeSort
{
    //Using Merge Sort
    public int[] sortArray(int[] nums)
    {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public void mergeSort(int []arr, int low, int high)
    {
        if(low >= high)
        return;
        int mid = low + (high-low)/2;
        mergeSort(arr, low, mid); //Sort left half
        mergeSort(arr, mid+1, high); //Sort right half
        merge(arr, low, high, mid); //Merge the two halves
    }
    public void merge(int []arr, int low, int high, int mid)
    {
        ArrayList<Integer> temp = new ArrayList<>(); //Temporary array to store the sorted elements
        int left = low; //Pointer for left half
        int right = mid+1; //Pointer for right half
        while(left <= mid && right <= high)
        {
            if(arr[left] <= arr[right])
            //If element in left half is smaller than element in right half, add the left element
            {
                temp.add(arr[left]);
                left++;
            }
            else
            //If element in right half is smaller than element in left half, add the right element
            {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid)
        //If there are any elements left in the left half, add them
        {
            temp.add(arr[left]);
            left++;
        }
        while(right <= high)
        //If there are any elements left in the right half, add them
        {
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<= high; i++)
        //Copy the sorted elements back to the original array
        arr[i] = temp.get(i-low);
        //Note: i-low is used to get the index of the element in the temporary array
        //How it works: i is the index of the original array, low is the starting index of the subarray
        //so i-low gives the index of the element in the temporary array
    }
    public static void main(String[] args)
    {
        MergeSort obj = new MergeSort();
        int []arr = {5, 2, 3, 1};
        System.out.println(Arrays.toString(obj.sortArray(arr)));
        System.out.println("Time: "+ System.nanoTime());
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Time: "+ System.nanoTime());
    }
}