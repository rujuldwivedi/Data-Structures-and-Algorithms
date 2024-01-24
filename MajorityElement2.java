import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class MajorityElement2
{
    public static List<Integer> majorityElement(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        int k=nums.length/3;
        for (int i=0;i<nums.length;i++)
        mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        for (Map.Entry<Integer, Integer> map : mpp.entrySet())
        {
            if (map.getValue() > k)
            ans.add(map.getKey());
        }
        return ans;
    }
    public static void main(String args[])
    {
        int[] nums = {1,1,1,3,3,2,2,2};
        List<Integer> ans = majorityElement(nums);
        for(int i=0;i<ans.size();i++)
        System.out.print(ans.get(i) + " ");
    }
}