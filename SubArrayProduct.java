public class SubArrayProduct
{
    public static int maxProduct(int[] nums)
    {
        int n = nums.length;
        int l=1;
        int r=1;
        int ans=nums[0];
        for(int i=0;i<n;i++)
        {
            if(l==0)
            l=1;
            if(r==0)
            r=1;
            l*=nums[i];
            r*=nums[n-1-i];
            ans = Math.max(ans,Math.max(l,r));
        }
        return ans;    
    }  
    public static void main(String args[])
    {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }  
}
