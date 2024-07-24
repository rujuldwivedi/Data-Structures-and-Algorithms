public class ModuloArithmetic
{
        /*
         * Here we'll do the following:
         * 1. Exponentiation by recursion
         * 2. Modular Exponentiation
         */

    // Function for Exponentiation by divide and conquer
    public static int power(int x, int n)
    {
        int ans = 1;
        while (n > 0)
        {
            if ((n & 1) == 1)
                ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }
    // Function for Modular Exponentiation
    public static int modPower(int x, int n, int m)
    {

        /*
         * We are calculating (x^n) % m.
         * We are using the property (a*b) % m = ((a % m) * (b % m)) % m.
         */
        
        int ans = 1;
        while (n > 0)
        {
            if ((n & 1) == 1)
                ans = (ans * x) % m;
            x = (x * x) % m;
            n >>= 1;
        }
        return ans;
    }

    /*
     * The time complexity of both the functions is O(log(n)).
     */

     /*
      * Here are some extra concepts:
        * 1. Big Integer: BigInteger class in Java is used for mathematical operations involving large integers.
        * 2. Catalan Number: The nth Catalan number is given by C(n) = (2n)! / ((n + 1)! * n!).
        * 3. Pigeonhole Principle: If n items are put into m containers, where n > m, then at least one container must contain more than one item.
        * 4. Inclusion-Exclusion Principle: It is a counting technique which solves the problem of finding the number of elements in the union of two or more sets.
      */

    public static void main(String[] args)
    {
        int x = 4278, n = 5;
        System.out.println(x + " raised to the power " + n + " is " + power(x, n));
        int m = 1000000007;
        System.out.println(x + " raised to the power " + n + " modulo " + m + " is " + modPower(x, n, m));
    }
}
