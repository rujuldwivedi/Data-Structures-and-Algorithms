import java.util.HashMap;
import java.util.Map;
public class MajorityElement
{
    public static int majorityElement(int[] nums)
    {
        int ans=0;
        int n = (int)Math.floor(nums.length/2);
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        mpp.put(nums[i],mpp.getOrDefault(nums[i], 0) + 1);
        for (Map.Entry<Integer,Integer> map : mpp.entrySet())
        {
            if (map.getValue() > n)
            {
                ans=map.getKey();
                break;
            }
        }
        return ans;
    }    
    public static void main(String args[])
    {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
