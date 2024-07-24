public class PermutationsOfString
{
    /*
    * Here we'll do the following:
    * 1. Check if a string is a palindrome
    * 2. Print the super set of a string
    * 3. Print all permutations of a string
    */   

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String s)
    {
        if (s.length() == 0 || s.length() == 1)
            return true;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return isPalindrome(s.substring(1, s.length() - 1));
        return false;
    }

    /*
     * The time complexity of the above function is O(n) where n is the length of the string
     */

    /*
     * The above function can also be written as:
     * public static boolean isPalindrome(String s)
     * {
     *    int i = 0, j = s.length() - 1;
     *   while (i < j)
     *  {
     *    if (s.charAt(i) != s.charAt(j))
     *      return false;
     *   i++;
     * j--;
     * }
     * return true;
     * }
     */

     /*
      * The time complexity of the above function is O(n) where n is the length of the string
      */

    // Function to print the super set of a string
    public static void superSet(String s, String ans)
    {
        if (s.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        superSet(s.substring(1), ans + s.charAt(0));
        // The above line includes the first character of the string
        superSet(s.substring(1), ans);
        // The above line excludes the first character of the string
    }

    /*
     * The time complexity of the above function is O(2^n) where n is the length of the string
     */

     /*
      * The above function can also be written as:
        * public static void superSet(String s, int index, String ans)
        * {
        *    if (index == s.length())
        *    {
        *        System.out.println(ans);
        *        return;
        *    }
        *    superSet(s, index + 1, ans + s.charAt(index));
        *    superSet(s, index + 1, ans);
        * }
      */

      /*
       * The time complexity of the above function is O(2^n) where n is the length of the string
       */

    // Function to print all permutations of a string
    public static void permutations(String s, String ans)
    {

        /*
         * We'll use the following approach:
         * 1. If the length of the string is 0, we'll print the answer
         * 2. We'll iterate through the string and for each character, we'll find the permutations of the rest of the string
         * 3. We'll then append the character to the answer and call the function recursively
         */

        if (s.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            String rest = left + right;
            permutations(rest, ans + ch);
        }
    }

    /*
     * The time complexity of the above function is O(n!) where n is the length of the string
     */

     /*
      * The above function can also be written as:
        * public static void permutations(String s, int l, int r)
        * {
        *    if (l == r)
        *    {
        *        System.out.println(s);
        *        return;
        *    }
        *    for (int i = l; i <= r; i++)
        *    {
        *        s = swap(s, l, i);
        *        permutations(s, l + 1, r);
        *        s = swap(s, l, i);
        *    }
        * }
        * public static String swap(String s, int i, int j)
        * {
        *    char[] arr = s.toCharArray();
        *    char temp = arr[i];
        *    arr[i] = arr[j];
        *    arr[j] = temp;
        *    return String.valueOf(arr);
        * }
      */

    public static void main(String[] args)
    {
        String s = "abba";
        System.out.println("Is the string " + s + " a palindrome? " + isPalindrome(s));
        String s1 = "abc";
        System.out.println("The super set of " + s1 + " is:");
        superSet(s1, "");
        System.out.println("The permutations of " + s1 + " are:");
        permutations(s1, "");
    }
}
