public class StockBuySell
{
    public static int maxProfit(int[] prices)
    {
        int mini = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++)
        {
            profit = Math.max(profit, prices[i] - mini);
            mini = Math.min(mini,prices[i]);
        }
        return profit;
    }
    public static void main(String args[])
    {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
