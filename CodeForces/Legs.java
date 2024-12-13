import java.util.*;

public final class Legs
{
	public static int helper(int n)
	{
		int ans;
		if(n==2)
		ans = 1;
		else
		ans = (n>>2 == 0)?n>>2:(n+2)>>2;
		return ans;
	}
	
	public static void main(String args[])
	{	
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- != 0)
		{
			int n = sc.nextInt();
			System.out.println(helper(n));
		}
		sc.close();
	}
}