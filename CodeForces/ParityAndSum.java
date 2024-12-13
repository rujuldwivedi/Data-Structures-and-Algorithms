import java.util.*;

public final class ParityAndSum
{
    public static int helper(Scanner sc)
    {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
        
        TreeMap<Integer, Integer> evens = new TreeMap<>();
        int maxOdd = -1;
        for(int i : arr)
        {
            if(i%2 != 0)
            maxOdd = Math.max(maxOdd, i);
            else
            evens.put(i, evens.getOrDefault(i, 0) + 1);
        }

        if(maxOdd == -1)
        return 0;

        int ans = 0;
        while(!evens.isEmpty())
        {
            ans++;
            Integer even = evens.lowerKey(maxOdd);
            if(even == null)
            maxOdd += evens.lastKey();
            else
            {
                int count = evens.get(even);
                if(count == 1)
                evens.remove(even);
                else
                evens.put(even, count - 1);
                maxOdd = Math.max(maxOdd, maxOdd + even);
            }
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