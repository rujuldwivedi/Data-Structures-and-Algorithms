public class Sort012
{
    public static void swap(int[] arr, int a, int b)
    {
        int temp;
        temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void sortColors(int[] nums)
    {
       int s=0,e=nums.length-1;
       int mid=0;
       while(mid<=e)
       {
           if(nums[mid]==0)
           swap(nums,mid++,s++);
           else if(nums[mid]==1)
           mid++;
           else
           swap(nums,mid,e--);
       } 
    }
    public static void main(String args[])
    {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int i = 0; i < nums.length; i++)
        System.out.print(nums[i] + " ");
    }    
}
