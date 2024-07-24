public class Stocks1
{

    /*
     * Here we'll do the following:
     * 1. Best Time to Buy and Sell Stock I
     */

    // Function to find the maximum profit using Brute Force
    public static int maxProfitBruteForce(int[] prices)
    {
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    /*
     * The time complexity of the above approach is O(n^2)
     */

    // Function to find the maximum profit using Kadane's Algorithm
    public static int maxProfitKadane(int[] prices)
    {
        int n = prices.length;
        int maxProfit = 0, profit = 0;
        for (int i = 1; i < n; i++)
        {
            profit += prices[i] - prices[i - 1];
            if (profit < 0)
                profit = 0;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    /*
     * The time complexity of the above approach is O(n)
     */

    public static void main(String[] args)
    {
        int[] prices = { 3, 5, 1, 7, 4, 9, 3};
        System.out.println(maxProfitBruteForce(prices));
        System.out.println(maxProfitKadane(prices));
    }
}
