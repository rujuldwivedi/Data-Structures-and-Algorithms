import java.util.Scanner;

public class MakeBothEqual
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int ans = 0;

        while(A != 0 && B != 0)
        {
            if(A > B)
            {
                ans += A / B;
                A %= B;
            }
            else
            {
                ans += B / A;
                B %= A;
            }
        }

        System.out.println(ans-1);
    }
}
