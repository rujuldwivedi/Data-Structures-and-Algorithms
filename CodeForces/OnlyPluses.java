import java.util.Scanner;
public final class OnlyPluses
{
    static int max = 1;
    public static int onlyPluses(int a, int b, int c, int k)
    {
        if(k==-1)
        return max;
        max = a*b*c;
        return Math.max(onlyPluses(a+1,b,c,k-1),Math.max(onlyPluses(a,b+1,c,k-1),onlyPluses(a,b,c+1,k-1)));
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(onlyPluses(a,b,c,5));
        }
        sc.close();
    }
}