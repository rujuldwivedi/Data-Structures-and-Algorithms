import java.util.*;
public class Subsets
{
     public static void helper(int[] nums, int i, List<Integer> output, Set<List<Integer>> sol)
    {
        if (i == nums.length)
        {
            sol.add(new ArrayList<>(output)); 
            return;
        }
        output.add(nums[i]);
        helper(nums, i + 1, output, sol);
        output.remove(output.size() - 1);
        helper(nums, i + 1, output, sol);
    }
    public static List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> sol = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, output, sol);
        for (List<Integer> subset : sol)
        ans.add(subset);
        return ans;
    }
    public static void main(String args[])
    {
        int nums[]={1,2,3};
        List<List<Integer>> ans=subsets(nums);
        System.out.println(ans);
    }
}