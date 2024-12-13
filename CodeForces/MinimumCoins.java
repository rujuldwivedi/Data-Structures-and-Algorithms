import java.util.*;

public class MinimumCoins
{
    public static long helper(int[] arr, int k)
    {
        long[] dp = new long[k+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1;i<=k;i++)
        {
            long coins = Integer.MAX_VALUE;

            for(int coin:arr)
            {
                if(coin>i)
                continue;
                
                coins = Math.min(coins, dp[i-coin] + 1);
            }

            dp[i] = coins;
        }

        return dp[k];

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        long res = helper(arr, k);

        long ans = (res == Integer.MAX_VALUE ? -1 : res);

        System.out.println(ans);
    }    
}
