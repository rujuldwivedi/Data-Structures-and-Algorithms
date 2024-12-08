public class MaxSubArray
{
    public static int maxSubArray(int[] nums)
    {
        int maxi = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            maxi = Math.max(maxi,sum);
            if(sum<0)
            sum=0;
        }
        return maxi;
    }
    public static void main(String args[])
    {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }    
}
