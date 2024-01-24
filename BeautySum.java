public class BeautySum
{
    public static int freq(int arr[])
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            continue;
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        return max-min;
    }
    public static int beautySum(String s)
    {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            int arr[]=new int[26];
            int j=i;
            while(j<s.length())
            {
                arr[s.charAt(j++)-'a']++;
                ans+=freq(arr);
            }
        }
        return ans;
    }  
    public static void main(String args[])
    {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }  
}
