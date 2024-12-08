public class Koko
{
    public static boolean blackbox(int maxpiles,int[] piles,int h){
        int hours=0;
        for(int i=0;i<piles.length;i++)
        {
            int time=piles[i]/maxpiles;
            hours+=time;
            if(piles[i]%maxpiles!=0)
            hours++;
        }
        if(hours<=h)
        return true;
        return false;
    }
    public static int minEatingSpeed(int[] piles, int h)
    {
        int s=1;
        int e=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        e=Math.max(e,piles[i]);
        while(s<e)
        {
            int mid=s+(e-s)/2;
            if(blackbox(mid,piles,h))
            e=mid;
            else
            s=mid+1;
        }
        return s;    
    }    
    public static void main(String args[])
    {
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles,h));
    }
}
