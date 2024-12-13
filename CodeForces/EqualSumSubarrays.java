import java.util.*;
public final class EqualSumSubarrays
{
    public static void helper(Scanner sc)
    {
        int n = sc.nextInt();
        
        List<Integer> p = new ArrayList<>(n);
        
        for(int i = 0; i < n; i++)
        p.add(sc.nextInt());
        
        List<Integer> q = new ArrayList<>(n);
        
        for(int i = 1; i < n; i++)
        q.add(p.get(i));
        q.add(p.get(0));
        

        for(int i = 0; i < n; i++)
        System.out.print(q.get(i) + " ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inputs");
        
        int t = sc.nextInt();

        System.out.println();
        System.out.println("Outputs");

        while(t-- > 0)
        helper(sc);

        sc.close();
    }
}
