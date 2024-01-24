public class RearrangeArray
{
    public static int[] rearrangeArray(int[] nums)
    {
        int[] positive = new int[nums.length/2];
        int[] negative = new int[nums.length/2];
        int a=0,b=0;
        for(int i:nums)
        {
            if(i>=0)
            positive[a++]=i;
            else
            negative[b++]=i;
        }
        a=0;
        for(int j=0;j<nums.length;j+=2)
        {
            nums[j]=positive[a];
            nums[j+1]=negative[a];
            a++;
        }
        return nums;
    }
    public static void main(String args[])
    {
        int[] nums = {-1,-2,-3,4,5,6};
        int[] result = rearrangeArray(nums);
        for(int i=0;i<result.length;i++)
        System.out.print(result[i] + " ");
    }    
}
