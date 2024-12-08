import java.util.*;

public class UnionIntersection
{
    /*
     * Here we'll do the following:
     * 1. Count distinct elements in an array
     * 2. Find the union of two arrays
     * 3. Find the intersection of two arrays
     */

    // Function to count distinct elements in an array
    public static int countDistinct(int[] arr)
    {
        // Create a new HashSet
        HashSet<Integer> set = new HashSet<>();

        // Add all the elements of the array to the HashSet
        for (int i = 0; i < arr.length; i++)
        {
            set.add(arr[i]);
        }

        // Return the size of the HashSet
        return set.size();
    }

    // Function to find the union of two arrays
    public static void findUnion(int[] arr1, int[] arr2)
    {
        // Create a new HashSet
        HashSet<Integer> set = new HashSet<>();

        // Add all the elements of the first array to the HashSet
        for (int i = 0; i < arr1.length; i++)
        {
            set.add(arr1[i]);
        }

        // Add all the elements of the second array to the HashSet
        for (int i = 0; i < arr2.length; i++)
        {
            set.add(arr2[i]);
        }

        // Print the union of the two arrays
        System.out.println("Union of the two arrays: " + set);
    }

    // Function to find the intersection of two arrays
    public static void findIntersection(int[] arr1, int[] arr2)
    {
        // Create a new HashSet
        HashSet<Integer> set = new HashSet<>();

        // Create a new HashSet to store the intersection
        HashSet<Integer> intersection = new HashSet<>();

        // Add all the elements of the first array to the HashSet
        for (int i = 0; i < arr1.length; i++)
        {
            set.add(arr1[i]);
        }

        // Check if the element is present in the HashSet
        // If it is, add it to the intersection HashSet
        for (int i = 0; i < arr2.length; i++)
        {
            if (set.contains(arr2[i]))
            {
                intersection.add(arr2[i]);
            }
        }

        // Print the intersection of the two arrays
        System.out.println("Intersection of the two arrays: " + intersection);
    }

    public static void main(String[] args)
    {
        // Create two arrays
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        // Count distinct elements in the first array
        System.out.println("Number of distinct elements in the first array: " + countDistinct(arr1));

        // Find the union of the two arrays
        findUnion(arr1, arr2);

        // Find the intersection of the two arrays
        findIntersection(arr1, arr2);
    }
}
