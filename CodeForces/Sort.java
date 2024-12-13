import java.util.Scanner;

public class Sort
{
    public static void solve(Scanner scanner)
    {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        String a = scanner.nextLine();
        String b = scanner.nextLine();

        int[][] pre = new int[n + 1][26];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 26; j++)
            {
                pre[i + 1][j] = pre[i][j];
            }
            pre[i + 1][a.charAt(i) - 'a']++;
            pre[i + 1][b.charAt(i) - 'a']--;
        }

        while (q-- > 0)
        {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt();

            int ans = 0;
            for (int c = 0; c < 26; c++)
            {
                ans += Math.max(0, pre[r][c] - pre[l][c]);
            }
            System.out.println(ans);
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0)
        {
            solve(scanner);
        }
        scanner.close();
    }
}
