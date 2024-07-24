// import java.math.BigInteger;
public class BigO
{
    /*

    Code for BigInteger
    public static BigInteger algo1(BigInteger n)
    {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE))
        sum = sum.add(i);
        return sum;
    }
    public static BigInteger algo2(BigInteger n)
    {
        return n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
    }

    */

    /*

    Master's Theorem
    T(n) = aT(n/b) + f(n)
    T(n) = O(n^log_b(a)) if f(n) = O(n^c) where c < log_b(a)
    T(n) = O(n^c) if f(n) = O(n^c) where c = log_b(a)
    T(n) = O(f(n)) if f(n) = O(n^c) where c > log_b(a)

    */
    
    /*

    Table to pick algorithm according to constraint on n (<=10^8)
    n belongs to [10,11] -> O(n!),O(n^6)
    n belongs to [15,18] -> O(2^n * n^2)
    n < 100 -> O(n^4)
    n < 400 -> O(n^3)
    n < 2000 -> O(n^2 * log(n))
    n < 10^4 -> O(n^2)
    n < 10^6 -> O(n * log(n))
    n < 10^8 -> O(n), O(log(n))
    n > 10^8 -> O(1)

    */

    public static long algo1(long n)
    {
        long sum = 0;
        for (long i = 1; i <= n; i++)
            sum += i;
        return sum;
    }
    public static long algo2(long n)
    {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args)
    {
        // BigInteger n = new BigInteger("1000000000");
        long n = 1000000000;
        long start = System.currentTimeMillis();
        System.out.println(algo1(n));
        long end = System.currentTimeMillis();
        System.out.println("Time taken by algo1: " + (end - start) + "ms");
        start = System.currentTimeMillis();
        System.out.println(algo2(n));
        end = System.currentTimeMillis();
        System.out.println("Time taken by algo2: " + (end - start) + "ms");
    }
}
/*
The reason algo1 and algo2 are giving negative answers is because of integer overflow.
Integer overflow occurs when the result of an arithmetic operation is larger than the maximum value that the integer type can store.
In that case, the result wraps around and becomes negative.
To fix this, we can use a larger data type like long or BigInteger to store the result.
*/