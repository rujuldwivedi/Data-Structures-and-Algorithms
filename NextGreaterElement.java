import java.util.*;

public class NextGreaterElement
{
    public static int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < nums2.length; i++)
        {
            while(!st.isEmpty() && st.peek() < nums2[i])
            mpp.put(st.pop(), nums2[i]);
            st.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++)
        nums1[i] = mpp.getOrDefault(nums1[i], -1);
        return nums1;
    }
    public static void main(String[] args)
    {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ans = nextGreaterElement(nums1, nums2);
        for(int i = 0; i < ans.length; i++)
        System.out.print(ans[i] + " ");
    }
}