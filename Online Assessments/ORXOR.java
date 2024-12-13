package GoogleOA;

import java.util.*;

public class ORXOR
{

    public static int computeF(List<Integer> B, int K)
    {
        int or1 = 0, or2 = 0;
        for(int i = 0; i < K; ++i)
        or1 |= B.get(i);
        for(int i = K; i < 2 * K; ++i)
        or2 |= B.get(i);
        return or1 ^ or2;
    }

    public static int maxF(List<Integer> A, int N, int K)
    {
        int max_value = 0;

        int totalSubsequences = 1 << N;
        for(int i = 0; i < totalSubsequences; ++i)
        {
            List<Integer> B = new ArrayList<>();
            for(int j = 0; j < N; ++j)
            {
                if((i & (1 << j)) != 0)
                B.add(A.get(j));
            }
            if(B.size() == 2 * K)
            max_value = Math.max(max_value, computeF(B, K));
        }
        return max_value;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            List<Integer> A = new ArrayList<>();
            for(int i = 0; i < N; ++i)
            A.add(scanner.nextInt());

            int result = maxF(A, N, K);
            System.out.println(result);
        }

        scanner.close();
    }
}
