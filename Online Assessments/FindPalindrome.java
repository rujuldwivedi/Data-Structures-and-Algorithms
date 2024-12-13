package GoogleOA;

import java.util.*;

public class FindPalindrome
{

    public static final int MAXN = 200001;

    @SuppressWarnings("unchecked")
    public static List<Integer>[] tree = new ArrayList[MAXN];
    public static char[] C = new char[MAXN];
    public static String[] S = new String[MAXN];
    public static boolean[] isPalindromic = new boolean[MAXN];

    public static void dfs(int u, int parent)
    {
        S[u] = Character.toString(C[u]);
        
        for(int v : tree[u])
        {
            if(v != parent)
            {
                dfs(v, u);
                S[u] += S[v];
            }
        }
        
        int len = S[u].length();
        isPalindromic[u] = true;
        for(int i = 0; i < len / 2; ++i)
        {
            if (S[u].charAt(i) != S[u].charAt(len - 1 - i))
            {
                isPalindromic[u] = false;
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for(int i = 1; i <= N; ++i)
        tree[i] = new ArrayList<>();

        for(int i = 1; i < N; ++i)
        {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        for(int i = 1; i <= N; ++i)
        C[i] = scanner.next().charAt(0);

        dfs(1, -1);

        int Q = scanner.nextInt();

        while(Q-- > 0)
        {
            int u = scanner.nextInt();
            if(isPalindromic[u])
            System.out.println(1);
            else
            System.out.println(0);
        }

        scanner.close();
    }
}
