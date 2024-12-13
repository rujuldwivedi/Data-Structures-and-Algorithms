import java.util.*;

public class GridPaths
{
    public static final int MOD = 1000000007;

    public static long helper(int n, int[][] grid)
    {
        long[] prefix = new long[n];

        prefix[0] = (grid[0][0] == 1) ? 1 : 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0)
                prefix[j] = 0;

                else if (j > 0)
                {
                    prefix[j] += prefix[j - 1];
                    prefix[j] %= MOD;
                }
            }
        }

        return prefix[n - 1];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();

        int[][] grid = new int[n][n];

        for(int i = 0; i < n; i++) 
        {
            String st = sc.nextLine();

            for(int j = 0; j < n; j++)
            grid[i][j] = (st.charAt(j) == '.') ? 1 : 0;
        }

        System.out.println(helper(n, grid));
    }
}

