import java.util.*;
public final class KDistinctCentres
{
    static class Pair
    {
        int x;
        int y;
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static void helper(Scanner sc)
    {
        int xCoor = sc.nextInt();
        int yCoor = sc.nextInt();
        int k = sc.nextInt();

        List<Pair> ans = new ArrayList<>(k);
        
        if(k%2==0)
        {
            for(int i=1;i<=k/2;i++)
            {
                Pair pair1 = new Pair(xCoor - i, yCoor - i);
                Pair pair2 = new Pair(xCoor + i, yCoor + i);
                ans.add(pair1);
                ans.add(pair2);
            }
        }
        else
        {
            Pair pair = new Pair(xCoor, yCoor);
            ans.add(pair);
            for(int i=1;i<=k/2;i++)
            {
                Pair pair1 = new Pair(xCoor - i, yCoor - i);
                Pair pair2 = new Pair(xCoor + i, yCoor + i);
                ans.add(pair1);
                ans.add(pair2);
            }
        }
            
            for(Pair pair:ans)
            {
                System.out.print(pair.x+" ");
                System.out.println(pair.y);
            }
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
