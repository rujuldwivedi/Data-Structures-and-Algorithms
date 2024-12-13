import java.io.*;

public class Circuit
{
    public static void solve(int n, int[] switches)
    {
        int total = 2 * n;
        
        int on = 0;

        for (int s : switches)
        on += s;
        
        int min = (on % 2 == 0) ? 0 : 1;
        
        int max = (on == total) ? 0 : Math.min(on, n);
        
        System.out.println(min + " " + max);
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++)
        {
            int n = Integer.parseInt(br.readLine());
            String[] switchStates = br.readLine().split(" ");
            
            int[] switches = new int[2*n];

            for (int j = 0; j < 2*n; j++)
            switches[j] = Integer.parseInt(switchStates[j]);
            
            solve(n, switches);
        }
    }
}