import java.util.*;

public class DenominationsOfCoins
{
    public static int helper(int[] arr, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Set<Integer> set = new HashSet<>();
        
        pq.add(0);
        set.add(0);

        int count = 0;
        int curr = 0;

        while(!pq.isEmpty())
        {
            curr = pq.poll();

            count++;

            if(count == k)
            return curr;

            for(int coin : arr)
            {
                int amt = curr + coin;

                if(!set.contains(amt))
                {
                    set.add(amt);
                    pq.add(amt);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println(helper(arr, k) + 1);
    }
}