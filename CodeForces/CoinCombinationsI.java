import java.util.*;

public class CoinCombinationsI
{
    public static long helper(int[] arr, int k)
    {
        Arrays.sort(arr);

        long[] dp = new long[k+1];
        dp[0] = 1;

        for(int coin:arr)
        {
            for(int i=coin;i<=k;i++)
            dp[i] += dp[i-coin]%1000000007;
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

        System.out.println(helper(arr, k)%1000000007);
    }    
}
