import java.util.*;
public class UltraMeow
{
    private static final int MOD = (int) 1e9 + 7;
    private static List<Long> fact;
    private static List<Long> invFact;
    private static void precomputeFactorials(int maxN)
    {
        fact = new ArrayList<>(Collections.nCopies(maxN + 1, 1L));
        invFact = new ArrayList<>(Collections.nCopies(maxN + 1, 1L));
        for(int i = 2; i <= maxN; i++)
        fact.set(i, fact.get(i - 1) * i % MOD);
        invFact.set(maxN, modularInverse(fact.get(maxN), MOD));
        for(int i = maxN - 1; i >= 1; i--)
        invFact.set(i, invFact.get(i + 1) * (i + 1) % MOD);
    }
    private static long modularInverse(long a, long mod)
    {
        long m0 = mod, t, q;
        long x0 = 0, x1 = 1;
        if(mod == 1)
        return 0;
        while(a > 1)
        {
            q = a / mod;
            t = mod;
            mod = a % mod;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }
        if(x1 < 0)
        x1 += m0;
        return x1;
    }
    private static long ultraMeow(int n)
    {
        long ans = 0;
        for(int sz = 0; sz <= n; sz++)
        {
            for(int num = sz + 1; num <= n + sz + 1; num++)
            {
                ans = (ans + combination(Math.min(num - 1, n), num - sz - 1)
                        * combination(Math.max(0, n - num), sz - (num - sz - 1)) % MOD
                        * num % MOD) % MOD;
            }
        }
        return ans;
    }
    private static long combination(int n, int k)
    {
        if(k < 0 || k > n)
        return 0;
        return fact.get(n) * invFact.get(k) % MOD * invFact.get(n - k) % MOD;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        precomputeFactorials(5000);
        while(t-- > 0)
        {
            int n = sc.nextInt();
            System.out.println(ultraMeow(n));
        }
        sc.close();
    }
}