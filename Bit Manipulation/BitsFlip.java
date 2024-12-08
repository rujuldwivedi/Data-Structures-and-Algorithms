public class BitsFlip
{
    public static int minBitFlips(int start, int goal)
    {
        int ans=start^goal;//to store which bits are different in ans, that is, ans stores all 1 or set bits when only one of start or goal is 1 and the other 0
        int c=0;
        while(ans!=0)
        {
            int temp=ans&(-ans);//storing the rightmost set bit
            ans-=temp;//removing one set of different bits
            c++;//increasing count and repeating the process
        }
        return c;
    } 
    public static void main(String args[])
    {
        int start=2;
        int goal=3;
        System.out.println(minBitFlips(start,goal));
    }   
}
