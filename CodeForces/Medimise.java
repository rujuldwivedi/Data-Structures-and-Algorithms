import java.util.*;

public final class Medimise
{
    public static final long INF = Long.MAX_VALUE;
    
    private static boolean isValid(long med, long[] arr, long[] dp, int n, int k, long rem, long req)
    {
        for(int i = 0; i < n; i++)
        dp[i] = -INF;

        for(int j = 0; j < n; j++)
        {
            long cur = (arr[j] >= med) ? 1 : 0;
            int r = j / k;
            int c = j % k;
            if(r > 0)
            dp[j] = Math.max(dp[j], dp[j-k]);
            if(c > 0 && c < rem)
            dp[j] = Math.max(dp[j], cur + dp[j-1]);
            if(c == 0)
            dp[j] = Math.max(dp[j], cur);
        }
        return dp[n - 1] >= req;
    }
    
    public static int helper(Scanner sc)
    {
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long[] arr = new long[n];
        
        for (int i = 0; i < n; i++)
        arr[i] = sc.nextLong();
        
        long rem = (n % k != 0 ? n%k : k);
        long req = rem/2 + 1;

        long[] dp = new long[n];

        for (int i = 0; i < n; i++)
        dp[i] = -INF;

        long l = 0;
        long r = 2000000000;
        while (r-l > 1)
        {
            long mid = (l+r)/2;
            if (isValid(mid, arr, dp, n, k, rem, req))
            l = mid;
            else
            r = mid;
        }
        return (int)l;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0)
        System.out.println(helper(sc));
        sc.close();
    }
}
