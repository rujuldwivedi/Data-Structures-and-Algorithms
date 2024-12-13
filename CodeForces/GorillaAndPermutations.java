import java.util.Scanner;
public final class GorillaAndPermutations
{
    public static int[] gorillaAndPermutations(int n, int m, int k)
    {
        int i=0;
        int[] arr = new int[n];
        for(;i<=n-m-1;i++)
        arr[i] = n-i;
        for(;i<n;i++)
        arr[i] = i-n+m+1;
        return arr;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = gorillaAndPermutations(n, m, k);
            for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
            System.out.println();
        }
        sc.close();
    }
}