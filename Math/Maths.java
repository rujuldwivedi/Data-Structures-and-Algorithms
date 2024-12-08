public class Maths
{
    /*
     * Here we'll do the following:
     * 1. Find the factorial of a number
     * 2. Find the trailing zeroes in the factorial of a number
     * 3. Check if the number is palindrome or not
     */

    // Function to find the factorial of a number
    public static int factorial(int n)
    {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
    // Function to find the trailing zeroes in the factorial of a number
    public static int trailingZeroes(int n)
    {

        /*
        * We are trying to find the number of 5's in the factorial of a number.
        * As zeros are made up of 2's and 5's, and the number of 2's will always be sufficient
        * as every second number is even, we need to find the number of 5's.
        * We'll do this by dividing the number by 5, then by 25, then by 125 and so on. 
         */

        int count = 0;
        for (int i = 5; i >= n; i *= 5)
            count += n / i;
        return count;
    }
    // Function to check if the number is palindrome or not
    public static boolean isPalindrome(int n)
    {
        int temp = n, rev = 0;
        while (temp > 0)
        {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return n == rev;
    }
    public static void main(String[] args)
    {
        int n = 22;
        System.out.println("Factorial of " + n + " is " + factorial(n));
        System.out.println("Trailing zeroes in the factorial of " + n + " is " + trailingZeroes(n));
        System.out.println(n + " is palindrome: " + isPalindrome(n));    
    }
}