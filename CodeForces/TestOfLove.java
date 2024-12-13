import java.util.Scanner;
public class TestOfLove
{
    public static String testOfLove(int n, int m, int k, String s)
    {
        s = "L" + s + "L";
        n += 2;
        boolean valid = true;
        int pos = 0;
        while(pos < n - 1)
        {
            if(s.charAt(pos) == 'L')
            {
                boolean found = false;
                for(int i = pos + 1; i < n && i <= pos + m; i++)
                {
                    if(s.charAt(i) == 'L')
                    {
                        pos = i;
                        found = true;
                        break;
                    }
                }
                if(!found)
                {
                    pos += m;
                    if(pos < n && s.charAt(pos) == 'C')
                    {
                        valid = false;
                        break;
                    }
                }
            }
            else
            {
                pos += 1;
                if(pos < n && s.charAt(pos) == 'C')
                {
                    valid = false;
                    break;
                }
                k -= 1;
            }
        }
        return (valid && k >= 0) ? "YES" : "NO";
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        while(tt-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            System.out.println(testOfLove(n, m, k, s));
        }
        sc.close();
    }
}