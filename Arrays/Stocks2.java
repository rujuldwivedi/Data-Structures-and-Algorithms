public class Stocks2
{
        
        /*
        * Here we'll do the following:
        * 1. Best Time to Buy and Sell Stock II
        * The difference between this and Stocks1 is that here we can buy and sell multiple times
        */

        // Function to find the maximum profit using Kadane's Algorithm
        public static int maxProfitKadane(int[] prices)
        {
            int n = prices.length;
            int maxProfit = 0;
            for (int i = 1; i < n; i++)
            {
                if (prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }

        /*
        * The time complexity of the above approach is O(n)
        */
    
        public static void main(String[] args)
        {
            int[] prices = { 5, 2, 7, 3, 6, 1, 2, 4};
            System.out.println(maxProfitKadane(prices));
        }    
}
