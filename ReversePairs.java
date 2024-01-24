import java.util.ArrayList;
public class ReversePairs
{
    public static int merge(int[] nums,int low,int mid, int high)
    {
        int count=0;
        int j = mid+1;
        for(int i=low;i<=mid;i++)
        {
            while(j<=high && nums[i]>(2*(long)nums[j]))
            {
                count+=mid-i+1;
                j++;
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low,right = mid+1;
        while(left<=mid && right<=high)
        {
            if(nums[left]<=nums[right])
            temp.add(nums[left++]);
            else
            temp.add(nums[right++]);
        }
            while(left<=mid)
            temp.add(nums[left++]);
            while(right<=high)
            temp.add(nums[right++]);
            for(int i=low;i<=high;i++)
            nums[i] = temp.get(i-low);
            return count;
    }
    public static int mergeSort(int[] nums,int low,int high)
    {
        if(low>=high) 
        return 0;
        int mid = (low+high)/2;
        int temp = mergeSort(nums,low,mid);
        temp+= mergeSort(nums,mid+1,high);
        temp+= merge(nums,low,mid,high);
        return temp;
    }
    public static int reversePairs(int[] nums)
    {
        return mergeSort(nums,0,nums.length-1);
    }
    public static void main(String args[])
    {
        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }
}
