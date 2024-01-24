import java.util.ArrayList;
import java.util.List;
public class GenerateParanthesis
{
    public static void helper(List<String> ans, int i, int j, String s, int n)
    {
        if (s.length()==n*2)
        {
            ans.add(s);
            return;
        }
        if (i<n)//to keep under n
        helper(ans, i + 1, j, s + "(", n);
        if (j<i)//to keep the paranthesis balanced
        helper(ans, i, j + 1, s + ")", n);
    }
    public static List<String> generateParenthesis(int n)
    {
        List<String> ans = new ArrayList<String>();
        helper(ans, 0, 0, "", n);
        return ans;
    } 
    public static void main(String args[])
    {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        for (String s : ans)
        System.out.println(s);
    }   
}
