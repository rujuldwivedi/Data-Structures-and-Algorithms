public class EuclidGCD
{
    /*
     * Here we'll do the following:
     * 1. Sieve of Eratosthenes
     * 2. Euclid's GCD Algorithm
     */

    // Function for the Sieve of Eratosthenes
    public static void sieveOfEratosthenes(int n)
    {
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
        for (int p = 2; p * p <= n; p++)
        {
            if (prime[p] == true)
            {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
                    // Here we are marking all the multiples of p as false
            }
        }
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
        //The complexity of this algorithm is O(n*log(log(n))).
    }
    // Function for Euclid's GCD Algorithm
    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args)
    {
        int n = 30;
        System.out.println("Prime numbers less than or equal to " + n + " are:");
        sieveOfEratosthenes(n);
        int a = 10, b = 15;
        System.out.println("\nGCD of " + a + " and " + b + " is " + gcd(a, b));
    }
}
