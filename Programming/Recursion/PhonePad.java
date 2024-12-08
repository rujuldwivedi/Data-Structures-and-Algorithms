import java.util.ArrayList;
import java.util.List;
public class PhonePad
{
    public static List<String> helper(String input, String output)
    {
        if(input.length()==0)
        {
            List<String> ans = new ArrayList<>();
            ans.add(output);
            return ans;
        }
        List<String> ans = new ArrayList<>();
        String ros = input.substring(1);
        int digit = input.charAt(0)-'0';
        if(digit==7)
        {
            for(int i=((digit)*2)+1;i<(digit*3)-2;i++)
            {
                char ch = (char)(i+'a');
                ans.addAll(helper(ros,output+ch));
            }
        }
        else if(digit==8)
        {
            for(int i=19;i<22;i++)
            {
                char ch = (char)(i+'a');
                ans.addAll(helper(ros,output+ch));
            }
        }
        else if(digit==9)
        {
            for(int i=((digit-1)*3)-2;i<(digit*3)-1;i++)
            {
                char ch = (char)(i+'a');
                ans.addAll(helper(ros,output+ch));
            }
        }
        else
        {
            for(int i=(digit-2)*3;i<(digit-1)*3;i++)
            {
                char ch = (char)(i+'a');
                ans.addAll(helper(ros,output+ch));
            }
        }
        return ans;
    }
    public static List<String> letterCombinations(String digits)
    {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty())
        return ans;
        ans=helper(digits,"");
        return ans;
    }
    public static void main(String args[])
    {
        String digits = "23";
        List<String> ans = letterCombinations(digits);
        System.out.println(ans);
    }
}
