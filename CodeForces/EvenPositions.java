import java.util.*;

public final class EvenPositions
{
    public static int helper(int n, String s)
    {
        int temp = 0;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            temp++;
            if(s.charAt(i)==')')
            {
                ans += temp-1;
                ans += temp/2-1;
                temp = 0;
            }
        }
        return ans;
    }
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(helper(n, s));
        }
        sc.close();
	}
}
