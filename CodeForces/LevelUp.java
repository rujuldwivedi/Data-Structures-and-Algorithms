import java.util.*;
public final class LevelUp
{
    static final int N = 200020;
    static int[] arr = new int[N];
    @SuppressWarnings("unchecked")
    static ArrayList<Integer>[] val = new ArrayList[N];
    @SuppressWarnings("unchecked")
    static ArrayList<Integer>[] lvl = new ArrayList[N];
    static int[] ft = new int[N];
    
    public static void add(int p, int value)
    {
        for (p++; p < N; p += p & -p)
        ft[p] += value;
    }
    
    public static int get(int p)
    {
        int sum = 0;
        for(; p > 0; p -= p & -p)
        sum += ft[p];
        return sum;
    }

    public static int get(int l, int r)
    {
        return get(r) - get(l);
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        for(int i = 0; i < N; i++)
        {
            val[i] = new ArrayList<>();
            lvl[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
            val[arr[i]].add(i);
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            temp.add(i);
            lvl[i].add(0);
        }
        
        for(int i = 0; i < n; i++)
        add(i, 1);
        
        for(int level = 1; level <= n; level++)
        {
            ArrayList<Integer> ntemp = new ArrayList<>();
            for(int x : temp)
            {
                int cur = lvl[x].get(lvl[x].size() - 1);
                int low = cur, high = n + 1;
                
                while(high - low > 1)
                {
                    int mid = (low + high) / 2;
                    if (get(cur, mid) >= x) high = mid;
                    else low = mid;
                }
                
                if(high <= n)
                {
                    lvl[x].add(high);
                    ntemp.add(x);
                }
            }
            
            temp = ntemp;
            
            for (int i : val[level])
            add(i, -1);
        }
        
        while(q-- > 0)
        {
            int i = sc.nextInt();
            int x = sc.nextInt();
            i--;
            if(lvl[x].size() <= arr[i] || lvl[x].get(arr[i]) > i)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
        
        sc.close();
    }
}
