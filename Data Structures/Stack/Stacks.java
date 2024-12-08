import java.util.Stack;
import java.util.HashMap;
class Stacks
{
    public static int[] nextGreater(int[] nums1, int[] nums2)
    {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] next = new int[n2];
        int[] ans = new int[n1];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<n2;i++)
        {
            while(!stack.isEmpty() && nums2[stack.peek()]<nums2[i])
            {
                int popped = stack.pop();
                next[popped]=nums2[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
        next[stack.pop()]=-1;
        HashMap<Integer,Integer> mpp = new HashMap<Integer,Integer>();
        for(int i=0;i<n2;i++)
        mpp.put(nums2[i],next[i]);
        for(int i=0;i<n1;i++)
        ans[i]=mpp.get(nums1[i]);
        return ans;
    }
    public static void main(String args[])
    {
        int [] arr1 = {1,4,7,2};
        int [] arr2 = {3,7,2,1,4};
        int[] ans = new int[arr1.length];
        ans = nextGreater(arr1,arr2);
        for(int i=0;i<ans.length;i++)
        System.out.print(ans[i]+" ");
    }
}