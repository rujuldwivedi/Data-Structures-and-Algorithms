import java.util.Scanner;

public class WinterBreakGame
{
    static final int MOD = 998244353;

    public static long helper(long base, int exp, int mod)
    {
        long ans = 1;

        while(exp > 0)
        {
            if((exp & 1) == 1)
            ans = (ans * base) % mod;

            base = (base * base) % mod;

            exp >>= 1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        if(n == 1 || m == 1)
        {
            System.out.println(0);
            return;
        }

        long row = helper(2, n, MOD);
        long col = helper(2, m, MOD);

        long ans = ((row - 1) + (col - 1) + MOD) % MOD;

        System.out.println(ans);
    }
}
