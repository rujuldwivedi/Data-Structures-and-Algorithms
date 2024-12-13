package GoogleOA;

import java.util.*;

public class StringMachine
{
    public static boolean isSubsequence(String s1, String s2)
    {
        int j = 0;
        for(int i = 0; i < s2.length() && j < s1.length(); ++i)
        {
            if(s1.charAt(j) == s2.charAt(i))
            ++j;
        }
        return j == s1.length();
    }

    public static int solve(int N, String S1, int M, String S2, List<Integer> P)
    {
        StringBuilder Q = new StringBuilder();
        for(int i = 0; i < M; ++i)
        Q.append(' ');

        for (int t = 0; t < M; ++t)
        {
            Q.setCharAt(P.get(t) - 1, S2.charAt(P.get(t) - 1));

            if (isSubsequence(S1, Q.toString()))
            return t + 1;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0)
        {
            int N = scanner.nextInt();
            String S1 = scanner.next();
            int M = scanner.nextInt();
            String S2 = scanner.next();

            List<Integer> P = new ArrayList<>();
            for (int i = 0; i < M; ++i)
            P.add(scanner.nextInt());

            System.out.println(solve(N, S1, M, S2, P));
        }

        scanner.close();
    }
}
