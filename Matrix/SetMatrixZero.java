public class SetMatrixZero
{
    public static void setZeroes(int[][] matrix)
    {
        boolean row = false;
        boolean column = false;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(i==0)
                    row=true;
                    if(j==0)
                    column=true;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j]=0;
            }
        }
        if(row)
        {
            for(int j=0;j<matrix[0].length;j++)
            matrix[0][j]=0;
        }
        if(column)
        {
            for(int i=0;i<matrix.length;i++)
            matrix[i][0]=0;
        }
    }
    public static void main(String args[])
    {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }    
}
