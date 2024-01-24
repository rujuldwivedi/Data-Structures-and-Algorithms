import java.util.ArrayList;
import java.util.List;
public class SpiralMatrix
{
    public static List<Integer> spiralOrder(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix == null || n==0)
        return ans;
        int u = 0;
        int d = n-1;
        int l = 0;
        int r = m-1;
        while(u<=d || l<=r)
        {
            for(int i=l;i<=r;i++)
            ans.add(matrix[u][i]);
            u++;
            for(int i=u;i<=d;i++)
            ans.add(matrix[i][r]);
            r--;
            if(u<=d)
            {
                for(int i=r;i>=l;i--)
                ans.add(matrix[d][i]);
                d--;
            }
            if(l<=r)
            {
                for(int i=d;i>=u;i--)
                ans.add(matrix[i][l]);
                l++;
            }
        }
        return ans;
    }    
    public static void main(String args[])
    {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ans = spiralOrder(matrix);
        for(int i=0;i<ans.size();i++)
        System.out.print(ans.get(i) + " ");
    }
}
