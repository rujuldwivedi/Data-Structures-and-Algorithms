public class ReverseWords
{
    public static String reverseWords(String s)
    {
        char[] arr = s.toCharArray();
        char[] ans = new char[s.length()];
        int i = arr.length - 1;
        int j = arr.length - 1;
        int c = 0;
        while(i>=0)
        {
            j=i;//still pointing to word before space
            while(j>=0 && arr[j]!=' ')
            j--;//points to word after spcae
            if(c>0)
            ans[c++] = ' ';
            for(int k=j+1; k<=i; k++)//iterator between two pointers before and after spaces thus iterating over words only
            ans[c++] = arr[k];
            while(j>=0 && arr[j]==' ')
            j--;//points to word before spcae
            i=j;
        }
        return new String(ans, 0, c);    
    }
    public static void main(String args[])
    {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
