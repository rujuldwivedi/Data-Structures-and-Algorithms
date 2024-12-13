import java.util.Scanner;

public class Scale
{

    public static void solve(Scanner scanner)
    {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        
        String[] s = new String[n];
        for (int i = 0; i < n; i++)
        {
            s[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i += k)
        {
            for (int j = 0; j < n; j += k)
            {
                System.out.print(s[i].charAt(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- != 0)
        {
            solve(scanner);
        }
        
        scanner.close();
    }
}
