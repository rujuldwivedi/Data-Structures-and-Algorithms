import java.util.HashMap;
public class SubArraySumK
{
    public static int subarraySum(int[] nums, int k)
    {
        int c=0;
        int sum=0;
        HashMap <Integer,Integer> mpp = new HashMap <Integer,Integer> ();
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum == k)
            c++;
            if(mpp.containsKey(sum - k))
            c+=mpp.get(sum - k);
            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }
        return c;
    }    
    public static void main(String args[])
    {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }
}
