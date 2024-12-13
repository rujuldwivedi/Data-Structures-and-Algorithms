package GoogleOA;

import java.util.*;

public class ArrayAndQueries
{

    public static long solve(int N, List<Integer> A, int M, int L)
    {
        int n = A.size();
        long lo = 0, hi = 0, mid = 0, minmax = 0, operations = 0, difference = 0;

        for(int i : A)
        {
            lo = Math.min(lo, (long) i);
            hi = Math.max(hi, (long) i);
        }

        lo -= (long) M;
        hi++;

        while(lo <= hi)
        {
            mid = (lo + hi) / 2;

            operations = 0;
            List<Long> newA = new ArrayList<>();
            for(int i : A)
            newA.add((long) i);

            for(int i = 0; i < n; i++)
            {
                difference = newA.get(i) - mid;
                if(difference > 0)
                {
                    int len = i + L;
                    for(int j = i; j < Math.min(n, len); j++)
                    newA.set(j, newA.get(j) - difference);
                    operations += difference;
                }
            }

            if(operations > M)
            lo = mid + 1;
            else
            {
                minmax = mid;
                hi = mid - 1;
            }
        }

        return minmax;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
            List<Integer> A = new ArrayList<>();
            for(int i = 0; i < N; i++)
            A.add(sc.nextInt());
            int M = sc.nextInt();
            int L = sc.nextInt();
            System.out.println(solve(N, A, M, L));
        }
        sc.close();
    }
}