import java.util.*;

public class RemovingDigits
{
    public static int helper(int n)
    {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1; i<=n; i++)
        {
            int num = i;

            while(num > 0)
            {
                int digit = num % 10;

                if(digit > 0)
                dp[i] = Math.min(dp[i], dp[i - digit] + 1);

                num /= 10;
            }
        }

        return dp[n];

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(helper(n));
    }
}
