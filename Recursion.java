public class Recursion
{
       /*
        * Here we'll do the following:
        * 1. Sum of n natural numbers
        * 2. Finding a^b
        */

    // Function for finding the sum of n natural numbers
    public static int sum(int n)
    {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }
    // Function for finding a^b
    public static int power(int a, int b)
    {
        if (b == 0)
            return 1;
        return a * power(a, b - 1);
    }

    /*
     * The time complexity of the sum function is O(n).
     * The time complexity of the power function is O(b).
     */

    /* 
     * Alternatively, we can use the following approach for finding a^b:
     * public static int power(int a, int b)
     * {
     *    if (b == 0)
     *       return 1;
     *   if ((b & 1) == 0)
     *      return power(a, b >> 1) * power(a, b >> 1);
     *  return a * power(a, b >> 1) * power(a, b >> 1);
     * }
     * 
     * The time complexity of this function is O(log(b)).
     */
    public static void main(String[] args)
    {
        int n = 5;
        System.out.println("Sum of first " + n + " natural numbers is " + sum(n));
        int a = 3, b = 4;
        System.out.println(a + " raised to the power " + b + " is " + power(a, b));    
    }
}
