import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ValuableCards
{
    public static int valuableCards(int n, int x, int[] arr)
    {
        List<Integer> list = new ArrayList<>();
        int[] index = new int[x + 1];
        for(int i = 1; i <= x; i++)
        {
            if(x % i == 0)
            {
                index[i] = list.size();
                list.add(i);
            }
            else
            index[i] = -1;
        }
        int len = list.size();
        int ans = 1;
        boolean[] valid = new boolean[len];
        valid[0] = true;
        for(int num : arr)
        {
            if(x % num != 0)
            continue;
            if(valid[index[x / num]])
            {
                ans += 1;
                valid = new boolean[len];
                valid[0] = true;
                valid[index[num]] = true;
                continue;
            }
            for(int j = len - 1; j >= 0; j--)
            {
                if(list.get(j) % num == 0 && valid[index[list.get(j) / num]])
                valid[j] = true;
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
            int x = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            System.out.println(valuableCards(n, x, arr));
        }
        sc.close();
    }
}