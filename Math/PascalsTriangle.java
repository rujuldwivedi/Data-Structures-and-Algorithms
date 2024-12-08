import java.util.*;
public class PascalsTriangle
{
    public static List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                row.add(1);
                else
                row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(row);
        }
        return res;
    }
    public static void main(String args[])
    {
        int numRows = 5;
        List<List<Integer>> res = generate(numRows);
        for(int i=0;i<res.size();i++)
        {
            for(int j=0;j<res.get(i).size();j++)
            System.out.print(res.get(i).get(j) + " ");
            System.out.println();
        }
    }    
}
