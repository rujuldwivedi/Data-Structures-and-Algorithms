import java.util.*;

public final class LightSwitches
{
    public static int helper(Scanner sc)
    {
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];

        for(int i = 0; i < n; i++)
        arr[i] = sc.nextLong();

        long max = 0;
        for(long i : arr)
        max = Math.max(max, i);

        for(int i=0; i<n; i++)
        {
            arr[i] += (max-arr[i])/(k<<1)*(k<<1);
            if(arr[i]+k-1 < max)
            arr[i] += k<<1;
        }

        long l=0;
        long r=Long.MAX_VALUE;
        
        for(long i : arr)
        {
            l = Math.max(l, i);
            r = Math.min(r, i+k-1);
        }

        if(l<=r)
        return (int)l;
        else
        return -1;
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