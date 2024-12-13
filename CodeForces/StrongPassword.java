import java.util.*;

public final class StrongPassword
{
    public static char charNext(char c)
    {
        if (c == 'z')
        return 'a';
        return (char) (c + 1);
    }
    public static String helper(String s)
    {
        int n = s.length();
        for (int i = 0; i < n - 1; i++)
        {
            if (s.charAt(i) == s.charAt(i + 1))
            {
                char ch = charNext(s.charAt(i));
                return s.substring(0, i + 1) + ch + s.substring(i + 1);
            }
        }
        char ch = charNext(s.charAt(0));
        return ch + s;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0)
        {
            String s = sc.nextLine();
            System.out.println(helper(s));
        }
        sc.close();
    }
}
