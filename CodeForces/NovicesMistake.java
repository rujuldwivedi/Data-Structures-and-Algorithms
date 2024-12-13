import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NovicesMistake
{
    public static List<int[]> novicesMistake(int n)
    {
        List<int[]> ans = new ArrayList<>();
        for(int i = 1; i <= 10000; i++)
        {
            String s = Integer.toString(n);
            int len = s.length();
            while (s.length() < 8)
            s += s;
            for(int j = i * len - 1; j >= i * len - 8; j--)
            {
                if(j >= 1 && j <= 10000)
                {
                    int k = i * len - j;
                    String t = s.substring(0, k);
                    if(Integer.parseInt(t) == n * i - j)
                    ans.add(new int[]{i, j});
                }
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        while(tt-- > 0)
        {
            int n = sc.nextInt();
            List<int[]> ans = novicesMistake(n);
            System.out.println(ans.size());
            for (int[] pair : ans)
            System.out.println(pair[0] + " " + pair[1]);
        }
        sc.close();
    }
}