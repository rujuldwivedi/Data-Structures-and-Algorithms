import java.util.Stack;
public class NextGreaterElement 
{
    public static int[] nextGreater(int[] nums)
    {
        int max=Integer.MIN_VALUE;
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=max)
            {
                max=nums[i];
                j=i;
            }
        }
        int[] arr=new int[nums.length];
        int k=0;
        for(int i=j+1;i<nums.length;i++)
        {
            arr[i-j-1]=nums[i];
            k++;
        }
        for(int i=0;i<=j;i++)
        {
           arr[k]=nums[i];
           k++;
        }
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[nums.length];
        ans[nums.length-1]=-1;
        st.push(arr[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=arr[i])
            st.pop();
            if(st.isEmpty())
            {
                ans[i]=-1;
                st.push(arr[i]);
            }
            else
            {
                ans[i]=st.peek();
                st.push(arr[i]);
            }
        }
        k=0;
        for(int i=nums.length-j-1;i<nums.length;i++)
        {
            arr[k]=ans[i];
            k++;
        }
        j=0;
        for(int i=k;i<nums.length;i++)
        {
           arr[i]=ans[j];
           j++;
        }
        return arr;
    }
    public static void main(String[] args)
    {
        int[] arr={1,2,1};
        int[] ans=nextGreater(arr);
        for(int i=0;i<ans.length;i++)
        System.out.print(ans[i]+" ");
    } 
}
