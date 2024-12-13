import java.util.*;
public final class MakeThreeRegions
{
    public static int helper(String a, String b, int n)
    {
        int t = 0;
        for(int i = 0; i < n - 1; i++)
        {
            if(a.charAt(i) != a.charAt(i + 1) || a.charAt(i) != b.charAt(i) || a.charAt(i) != b.charAt(i + 1))
            {
                t = 1;
                break;
            }
        }
        if(t == 0)
        return 0;
        t = 0;
        for(int i = 1; i < n - 1; i++)
        {
            if(a.charAt(i) == '.')
            {
                if(a.charAt(i) == a.charAt(i - 1) && a.charAt(i) == a.charAt(i + 1) && a.charAt(i) == b.charAt(i)
                        && b.charAt(i - 1) != a.charAt(i) && b.charAt(i + 1) != a.charAt(i))
                        t++;
            }
        }
        for(int i = 1; i < n - 1; i++)
        {
            if(b.charAt(i) == '.')
            {
                if(b.charAt(i) == b.charAt(i - 1) && b.charAt(i) == b.charAt(i + 1) && a.charAt(i) == b.charAt(i)
                        && a.charAt(i - 1) != b.charAt(i) && a.charAt(i + 1) != b.charAt(i))
                        t++;
            }
        }
        return t;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String a = sc.nextLine();
            String b = sc.nextLine();
            System.out.println(helper(a, b, n));
        }
        sc.close();
    }
}
