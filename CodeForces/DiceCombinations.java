import java.util.*;
public final class DiceCombinations
{

    public static long helper(int n, long[] dp)
    {
        dp[0] = 1;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=6;j++)
            {    
                if(j>i)
                continue;

                dp[i] += dp[i-j]%1000000007;
            }
        }

        return dp[n]%1000000007;

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

         int n = sc.nextInt();

        long[] dp = new long[n+1];

        Arrays.fill(dp, 0);

        long ans = helper(n, dp)%1000000007;

        System.out.println(ans);

        sc.close();
    }
}