package GoogleOA;

import java.util.*;

public class ComplexSubsequences
{

    public static class Query
    {
        int L, R, X;
        Query(int L, int R, int X)
        {
            this.L = L;
            this.R = R;
            this.X = X;
        }
    }

    public static List<Integer> compressCoordinates(List<Query> queries)
    {
        Set<Integer> coordinates = new HashSet<>();
        for(Query query : queries)
        {
            coordinates.add(query.L);
            coordinates.add(query.R + 1);
        }
        List<Integer> coordList = new ArrayList<>(coordinates);
        coordList.sort(Integer::compareTo);
        return coordList;
    }

    public static List<Integer> longestSubsequence(int N, int K, List<Query> queries)
    {
        List<Integer> coords = compressCoordinates(queries);
        int M = coords.size();
        long[] diff = new long[M];
        
        for(Query query : queries)
        {
            int left = lowerBound(coords, query.L);
            int right = lowerBound(coords, query.R + 1);
            diff[left] += query.X;
            if(right < M)
            diff[right] -= query.X;
        }

        long[] values = new long[M];
        long current = 0;
        for (int i = 0; i < M; ++i)
        {
            current += diff[i];
            values[i] = current;
        }

        List<Integer> result = new ArrayList<>();
        long Z = 0;
        int length = 0;

        for(int i = 0; i < M; ++i)
        {
            if(values[i] > 0)
            {
                if(result.isEmpty())
                {
                    Z = values[i];
                    result.add(coords.get(i));
                    length++;
                }
                else if(values[i] == Z + length * K)
                {
                    result.add(coords.get(i));
                    length++;
                }
                else
                break;
            }
        }

        List<Integer> output = new ArrayList<>();
        output.add(result.size());
        for(int i = 0; i < result.size(); ++i)
        output.add((int) (Z + i * K));

        return output;
    }

    public static int lowerBound(List<Integer> list, int value)
    {
        int left = 0;
        int right = list.size();
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(list.get(mid) < value)
            left = mid + 1;
            else
            right = mid;
        }
        return left;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        List<Query> queries = new ArrayList<>();
        
        for(int i = 0; i < N; ++i)
        {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            int X = scanner.nextInt();
            queries.add(new Query(L, R, X));
        }

        List<Integer> result = longestSubsequence(N, K, queries);

        for(int value : result)
        System.out.print(value + " ");
        System.out.println();

        scanner.close();
    }
}
