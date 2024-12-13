import java.util.*;

public final class QuestionMarks
{
    public static int helper(Scanner sc)
    {
        int n = sc.nextInt();
        sc.nextLine();
		String s = sc.nextLine();
        int ans=0;
        int[] freq = new int[26];
        for(char ch:s.toCharArray())
        {
            if(ch!='?')
            freq[ch-'A']++;
        }
        
        for(int i=0;i<26;i++)
        {
            if(freq[i]<=n)
            ans+=freq[i];
            else
            ans+=n;
        }
        return ans;
    }
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- != 0)
		System.out.println(helper(sc));
		sc.close();
	}
}