public class LCSVariations
{

    /*
     * Here we'll do the following:
     * 1. Solve LCS Space Complexity Optimization
     * 2. Find the minimum insertions and deletions to convert string a to string b
     * 3. Find the length of supersequence of strings a and b
     * 4. Find the longest repeating subsequence
     * 5. Find the longest palindromic subsequence
     */

    // Function to solve LCS Space Complexity Optimization
    public static int lcsSpaceOptimization(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        int[] dp = new int[n+1];

        for(int i=0; i<=m; i++)
        {
            int prev = 0;
            for(int j=0; j<=n; j++)
            {
                int temp = dp[j];
                if(i==0 || j==0)
                {
                    dp[j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[j] = 1 + prev;
                }
                else
                {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                prev = temp;
            }
        }

        return dp[n];
    }

    // Function to find the minimum insertions and deletions to convert string a to string b
    public static int[] minInsertionsDeletions(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lcs = dp[m][n];
        int deletions = m - lcs;
        int insertions = n - lcs;

        return new int[]{insertions, deletions};
    }

    // Function to find the length of supersequence of strings a and b
    public static int supersequence(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lcs = dp[m][n];
        int supersequence = m + n - lcs;

        return supersequence;
    }

    // Function to find the longest repeating subsequence
    public static int longestRepeatingSubsequence(String s)
    {
        int m = s.length();

        int[][] dp = new int[m+1][m+1];

        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=m; j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                }
                else if(s.charAt(i-1) == s.charAt(j-1) && i!=j)
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][m];
    }

    // Function to find the longest palindromic subsequence
    public static int longestPalindromicSubsequence(String s)
    {
        String s2 = new StringBuilder(s).reverse().toString();

        return LCS.lcs(s, s2);
    }

    public static void main(String[] args)
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lcsSpaceOptimization(s1, s2));

        String a = "heap";
        String b = "pea";
        int[] result = minInsertionsDeletions(a, b);
        System.out.println("Insertions: " + result[0] + ", Deletions: " + result[1]);

        System.out.println(supersequence(s1, s2));

        String s = "AABEBCDD";
        System.out.println(longestRepeatingSubsequence(s));

        System.out.println(longestPalindromicSubsequence(s));
    }
}
