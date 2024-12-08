public class CheckSort
{
    public boolean check(int[] nums)
    {
        int n = nums.length;
        int rotated = 0;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > nums[(i + 1) % n])
            {
                if (rotated == 1)
                return false;
                rotated++;
            }
            else if (nums[i] == nums[(i + 1) % n])
            continue;
        }
        return true;
    }    
    public static void main(String args[])
    {
        int[] nums = {2,2,3,4};
        CheckSort obj = new CheckSort();
        if(obj.check(nums))
        System.out.println("Sorted");
        else
        System.out.println("Not Sorted");
    }
}
