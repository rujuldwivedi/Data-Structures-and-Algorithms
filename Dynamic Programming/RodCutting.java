public class RodCutting
{

    /*
     * Here we'll do the following:
     * 1. Solve the Rod Cutting problem using DP
     */

    // Function to solve the Rod Cutting problem
    public static int rodCutting(int[] prices, int n)
    {
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++)
        {
            int max = Integer.MIN_VALUE;
            for(int j=0; j<i; j++)
            {
                max = Math.max(max, prices[j] + dp[i-j-1]);
            }
            dp[i] = max;
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(rodCutting(prices, n));
    }
}
