public class ActivitySelection
{

    /*
     * Here we'll do the following:
     * 1. Solve the Activity Selection problem using Greedy
     */

    // Function to solve the Activity Selection problem
    public static int activitySelection(int[] start, int[] end)
    {
        int n = start.length;
        int count = 1;
        int i = 0;

        for(int j=1; j<n; j++)
        {
            if(start[j] >= end[i])
            {
                count++;
                i = j;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(activitySelection(start, end));
    }
}
