public class MinimumPlatforms
{
    /*
     * Here we'll do the following:
     * 1. Solve the Minimum Platforms problem using Greedy
     */

    // Function to solve the Minimum Platforms problem
    public static int minPlatforms(int[] arrival, int[] departure)
    {
        int n = arrival.length;
        int count = 1;
        int i = 1;
        int j = 0;

        MergeSort.mergeSort(arrival, 0, arrival.length-1);
        MergeSort.mergeSort(departure, 0, departure.length-1);

        while(i < n)
        {
            if(arrival[i] <= departure[j])
            {
                count++;
            }
            else
            {
                j++;
            }
            i++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minPlatforms(arrival, departure));
    }
}
