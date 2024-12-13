import java.util.Scanner;
import java.util.Arrays;
public final class AngryMonk
{
    public static int angryMonk(int[] arr)
    {
        int ans =0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]!=1)
            ans+=2*arr[i] - 1;
            else
            ans+=arr[i];
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            //int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[k];
            for(int i=0;i<k;i++)
            arr[i] = sc.nextInt();
            System.out.println(angryMonk(arr));
        }
        sc.close();
    }
}