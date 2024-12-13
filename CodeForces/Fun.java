import java.util.Scanner;

public class Fun
{
    public static void solve(Scanner scanner)
    {
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        
        long ans = 0;
        for (int a = 1; a <= n; a++)
        {
            for (int b = 1; a * b <= n && a + b <= x; b++)
            {
                ans += Math.min((n - a * b) / (a + b), x - a - b);
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0)
        solve(scanner);
        
        scanner.close();
    }
}
