public class RemoveOuterParanthesis
{
    public static String removeOuterParentheses(String s)
    {
        StringBuilder ans = new StringBuilder();
        int c=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                if(c>0)
                ans.append(ch);
                c++;
            }
            else if(ch==')')
            {
                c--;
                if(c>0)
                ans.append(ch);
            }
        }
        return ans.toString();
    }  
    public static void main(String args[])
    {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }  
}
