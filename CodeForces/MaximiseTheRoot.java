import java.util.*;

public final class MaximiseTheRoot
{
    private static long helper(int node, List<List<Integer>> adj, long[] v)
    {
        long mini = (long) 1e9;
        for(int it : adj.get(node))
        mini = Math.min(mini, helper(it, adj, v));
        if(node == 0)
        return mini + v[0];
        if(mini == (long) 1e9)
        return v[node];
        if(v[node] >= mini)
        return mini;
        return (mini + v[node]) / 2;
    }
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            List<List<Integer>> adj = new ArrayList<>(n);
            for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
            long[] v = new long[n];
            for(int i = 0; i < n; i++)
            v[i] = sc.nextLong();
            for(int i = 1; i < n; i++)
            {
                int p = sc.nextInt() - 1;
                adj.get(p).add(i);
            }
            long ans = helper(0, adj, v);
            System.out.println(ans);
        }
        sc.close();
	}
}
