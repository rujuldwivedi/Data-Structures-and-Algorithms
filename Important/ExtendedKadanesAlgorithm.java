package Important;
public class ExtendedKadanesAlgorithm
{

    /*
     * Here we'll do the following:
     * 1. Solve the Extended Kadane's Algorithm problem (Maximum Sum Rectangle) using DP
     */

    // Function to solve the Extended Kadane's Algorithm problem
    public static int maxSumRectangle(int[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
            int[] temp = new int[m];
            for(int j=i; j<n; j++)
            {
                for(int k=0; k<m; k++)
                {
                    temp[k] += arr[j][k];
                }

                int currSum = temp[0];
                int maxSumTillNow = temp[0];

                for(int k=1; k<m; k++)
                {
                    currSum = Math.max(temp[k], currSum + temp[k]);
                    maxSumTillNow = Math.max(maxSumTillNow, currSum);
                }

                maxSum = Math.max(maxSum, maxSumTillNow);
            }
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[][] arr = {{1, 2, -1, -4, -20},
                       {-8, -3, 4, 2, 1},
                       {3, 8, 10, 1, 3},
                       {-4, -1, 1, 7, -6}};

        System.out.println(maxSumRectangle(arr));
    }
}
