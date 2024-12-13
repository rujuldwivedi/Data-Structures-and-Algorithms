import java.util.*;
public final class RemovalsGame
{
    public static void helper(Scanner sc)
    {
        int n = sc.nextInt();

        int[] a = new int[n];

        for(int i=0;i<n;i++)
        a[i] = sc.nextInt();

        int[] b  = new int[n];

        int x = 1;
        int y = 1;

        for(int i=0;i<n;i++)
        {
            b[i] = sc.nextInt();

            if(a[i] != b[i])
            x=0;
            if(a[n-1-i] != b[i])
            y=0;
        }

        if(x == 0 && y == 0)
        System.out.println("Alice");
        else
        System.out.println("Bob");
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        helper(sc);
        sc.close();
    }
}