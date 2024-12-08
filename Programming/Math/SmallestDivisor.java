public class SmallestDivisor
{
    public static boolean valid(int[] a, int m, int h)
    {
        for(int i=0;i<a.length;i++)
        {
            h -= (a[i] + m-1)/m;
            if(h < 0)
            return false;
        }
        return true;
    }
    public static int smallestDivisor(int[] a, int h)
    {
        int l = 1;
        int r = a[0];
        for(int i=0;i<a.length;i++)
        {
            if (a[i] > r)
            r = a[i];
        }
        while(l < r)
        {
            int m = l + (r-l)/2;
            if(valid(a, m, h))
            r = m;
            else
            l = m + 1;
        }
        return l;
    }    
    public static void main(String args[])
    {
        int[] a = {1,2,5,9};
        int h = 6;
        System.out.println(smallestDivisor(a, h));
    }
}