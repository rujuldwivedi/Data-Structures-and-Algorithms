public class PalindromicPartitioning
{
    /*
     * Here we'll do the following:
     * 1. Solve the Palindromic Partitioning problem using Top-Down DP
     */

    // Function to check if a string is palindrome
    public static boolean isPalindrome(String s, int i, int j)
    {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Function to solve the Palindromic Partitioning problem
    public static int palindromicPartitioning(String s, int i, int j)
    {
        if(i >= j)
        {
            return 0;
        }

        if(isPalindrome(s, i, j))
        {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++)
        {
            int temp = 1 + palindromicPartitioning(s, i, k) + palindromicPartitioning(s, k+1, j);
            min = Math.min(min, temp);
        }

        return min;
    }

    public static void main(String[] args)
    {
        String s = "nitin121";
        System.out.println(palindromicPartitioning(s, 0, s.length()-1));
    }
}
