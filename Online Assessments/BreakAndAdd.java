package GoogleOA;

import java.util.*;

public class BreakAndAdd
{

    public static int[] p, ind;

    public static void makeSet(int v)
    {
        p[v] = v;
        ind[v] = 0;
    }

    public static int findSet(int v)
    {
        if (v == p[v]) return v;
        p[v] = findSet(p[v]);
        return p[v];
    }

    public static void unionSets(int a, int b)
    {
        a = findSet(a);
        b = findSet(b);
        if(a != b)
        {
            if(ind[a] < ind[b])
            {
                int temp = a;
                a = b;
                b = temp;
            }
            p[b] = a;
            if(ind[a] == ind[b]) 
            ind[a]++;
        }
    }

    public static boolean compareTo(List<Integer> a, List<Integer> b)
    {
        return a.get(2) > b.get(2);
    }

    public static long solve(int n, List<List<Integer>> edges)
    {
        Collections.sort(edges, new Comparator<List<Integer>>()
        {
            @Override
            public int compare(List<Integer> a, List<Integer> b)
            {
                return Integer.compare(b.get(2), a.get(2));
            }
        });

        long totalWt = 0;
        for(List<Integer> edge : edges)
        totalWt += edge.get(2);

        p = new int[n];
        ind = new int[n];
        for(int i = 0; i < n; i++)
        makeSet(i);

        long mstWt = 0;
        for(List<Integer> edge : edges)
        {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            if(findSet(u) != findSet(v))
            {
                mstWt += edge.get(2);
                unionSets(u, v);
            }
        }
        return totalWt - mstWt;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 

        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> edges = new ArrayList<>();
            for(int i = 0; i < m; i++)
            {
                List<Integer> edge = new ArrayList<>();
                edge.add(sc.nextInt());
                edge.add(sc.nextInt());
                edge.add(sc.nextInt());
                edges.add(edge);
            }
            System.out.println(solve(n, edges));
        }
        sc.close(); 
    }
}