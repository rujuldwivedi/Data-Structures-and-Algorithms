public class MatrixChainMultiplication
{

    /*
     * Here we'll do the following:
     * 1. Solve the Matrix Chain Multiplication problem using DP
     */

    // Function to solve the Matrix Chain Multiplication problem
    public static int matrixChainMultiplication(int[] arr)
    {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int i=1; i<n-1; i++)
        {
            dp[i][i+1] = 0;
        }

        for(int l=2; l<n; l++)
        {
            for(int i=1; i<n-l; i++)
            {
                int j = i+l;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++)
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[i-1]*arr[k]*arr[j]);
                }
            }
        }

        return dp[1][n-1];
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4};
        System.out.println(matrixChainMultiplication(arr));
    }
}
