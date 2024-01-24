import java.util.Arrays;

class DP
{
    public static int coins(int[] sum, int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<sum.length; i++)
        {
            for(int j=sum[i]; j<=n; j++)
            dp[j] += dp[j-sum[i]];
        }
        return dp[n];
    }
    public static int knapsack(int[] sum, int n)
    {
        int[][] dp = new int[sum.length+1][n+1];
        for(int i=0; i<=sum.length; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 && j==0)
                dp[i][j] = 1;
                else if(i==0)
                dp[i][j] = 0;
                else if(j==0)
                dp[i][j] = 1;
                else if(sum[i-1] <= j)
                dp[i][j] = dp[i][j-sum[i-1]] + dp[i-1][j];
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        return dp[sum.length][n];
    }
    public static void lcs(String s1, String s2)
    {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<=s1.length(); i++)
        {
            for(int j=0; j<=s2.length(); j++)
            {
                if(i==0 || j==0)
                dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
                else
                dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
    public static int editDistance(String s1, String s2)
    {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<=s1.length(); i++)
        {
            for(int j=0; j<=s2.length(); j++)
            {
                if(i==0)
                dp[i][j] = j;
                else if(j==0)
                dp[i][j] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
                else
                {
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min( insert, Math.min(delete, replace) );
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void cuttingRod(int[] arr, int n)
    {
        int[][] dp = new int[arr.length+1][n+1];
        for(int i=0; i<=arr.length; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j==0)
                dp[i][j] = 0;
                else if(i <= j)
                dp[i][j] = Math.max( dp[i-1][j], arr[i-1] + dp[i][j-i] );
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[arr.length][n]);
    }
    public static int maxSum(int[] arr, int n, int k)
    {
        int[][] dp = new int[n+1][k+1];
        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=k; j++)
            {
                if(i==0 || j==0)
                dp[i][j] = 0;
                else if(i <= j)
                dp[i][j] = Math.max( dp[i-1][j], arr[i-1] + dp[i][j-i] );
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][k];
    }
    public static int kadane(int[] arr)
    {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        for(int i=0;i<n;i++)
        {
            currMax += arr[i];
            if(max < currMax)
            max = currMax;
            if(currMax < 0)
            currMax = 0;
        }
        return max;
    }
    public static int maximumSumRectangle(int R, int C, int M[][])
    {
        int sum[] = new int[R];
        int maxSum = Integer.MIN_VALUE;
        for(int colStart = 0;colStart < C;colStart++)
        {
            Arrays.fill(sum,0);
            for(int colEnd = colStart; colEnd < C;colEnd++)
            {
                for(int row = 0;row < R;row++)
                sum[row] += M[row][colEnd];
                int currMaxSum = kadane(sum);
                maxSum = Math.max(maxSum,currMaxSum);
            }
        }
        return maxSum;
    }
    public static void matrixChain(int[] arr)
    {
        int[][] dp = new int[arr.length][arr.length];
        for(int i=0; i<arr.length; i++)
        dp[i][i] = 0;
        for(int l=2; l<arr.length; l++)
        {
            for(int i=1; i<arr.length-l+1; i++)
            {
                int j = i+l-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++)
                {
                    int q = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    if(q < dp[i][j])
                    dp[i][j] = q;
                }
            }
        }
        System.out.println(dp[1][arr.length-1]);
    }
    public static void palindromePartition(String s)
    {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++)
        dp[i][i] = 0;
        for(int l=2; l<=s.length(); l++)
        {
            for(int i=0; i<s.length()-l+1; i++)
            {
                int j = i+l-1;
                if(l==2)
                dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
                else
                {
                    if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1];
                    else
                    dp[i][j] = 1 + Math.min( dp[i+1][j], dp[i][j-1] );
                }
            }
        }
        System.out.println(dp[0][s.length()-1]);
    }
    public static void main(String[] args)
    {
        int[] sum = {1,2,3};
        int n = 4;
        System.out.println(coins(sum, n));
        System.out.println(knapsack(sum, n));
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        lcs(s1, s2);
        System.out.println(editDistance(s1, s2));
        int[] arr = {1,5,8,9,10,17,17,20};
        cuttingRod(arr, 8);
        int[] arr1 = {1,5,8,9,10,17,17,20};
        System.out.println(maxSum(arr1, 8, 8));
        System.out.println(maximumSumRectangle(4, 5, new int[][]{{1,2,-1,-4,-20},{-8,-3,4,2,1},{3,8,10,1,3},{-4,-1,1,7,-6}}));
        int[] arr2 = {1,2,3,4};
        matrixChain(arr2);
        String s = "ababbbabbababa";
        palindromePartition(s);
    }
}