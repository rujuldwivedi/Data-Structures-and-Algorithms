public class CoinChange
{

    /*
     * Here we'll do the following:
     * 1. Solve the coin change problem using DP
     */

     // Function to solve the coin change problem
    public static int coinChange(int[] coins, int amount)
    {
        // Create a dp array to store the minimum number of coins required to make the amount
        int[] dp = new int[amount + 1];

        // Initialize the dp array with a value greater than the amount
        for (int i = 0; i < dp.length; i++)
        {
            dp[i] = amount + 1;
        }

        // Base case
        dp[0] = 0;

        // Iterate through the dp array
        for (int i = 1; i < dp.length; i++)
        {
            // Iterate through the coins array
            for (int j = 0; j < coins.length; j++)
            {
                // Check if the coin is less than or equal to the amount
                if (coins[j] <= i)
                {
                    // Update the dp array
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // Check if the last element of the dp array is greater than the amount
        if (dp[amount] > amount)
        {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 5, 7};
        int amount = 18;
        System.out.println(coinChange(coins, amount));
    }
}