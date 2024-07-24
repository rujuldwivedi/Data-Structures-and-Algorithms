import java.util.*;

public class CountDistinctElements
{

    /*
     * Here we'll do the following:
     * 1. Count the number of distinct elements in a window of size k
     */

        // Function to count the number of distinct elements in a window of size k
        public static void countDistinctElements(int[] arr, int k)
        {
            // Create a hashmap to store the frequency of the elements
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < k; i++)
            {
                if(map.containsKey(arr[i]))
                {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
                else
                {
                    map.put(arr[i], 1);
                }
            }
            System.out.println(map.size());
            for(int i = k; i < arr.length; i++)
            {
                if(map.get(arr[i - k]) == 1)
                {
                    map.remove(arr[i - k]);
                }
                else
                {
                    map.put(arr[i - k], map.get(arr[i - k]) - 1);
                }

                /*
                 * The above two blocks are for handling the removal of the element which is going out of the window
                 * The below block is for handling the addition of the element which is coming into the window
                 */

                if(map.containsKey(arr[i]))
                {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
                else
                {
                    map.put(arr[i], 1);
                }
                System.out.println(map.size());
            }
        }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 1, 3, 1, 1, 3};
        int k = 4;
        countDistinctElements(arr, k);
    }
}
