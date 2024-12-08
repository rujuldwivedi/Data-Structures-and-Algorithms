import java.util.*;
public class Sum3
{
    public static List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i > 0 && nums[i-1] == nums[i])
            continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0)
                {
                    hs.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if(sum < 0)
                j++;
                else
                k--;
            }
        }
        ans.addAll(hs);
        return ans;
    }    
    public static void main(String args[])
    {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);
        for(int i=0;i<ans.size();i++)
        System.out.print(ans.get(i) + " ");
    }
}
