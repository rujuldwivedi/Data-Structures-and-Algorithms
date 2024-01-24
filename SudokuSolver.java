public class SudokuSolver
{
    public static boolean isSafe(int[][] board, int row, int col, int num)
    {
        for (int i = 0; i < board.length; i++)
        {
            if (board[i][col] == num)
            return false;
            if (board[row][i] == num)
            return false;
            int rowStart = 3 * (row / 3) + i / 3;
            int colStart = 3 * (col / 3) + i % 3;
            if (board[rowStart][colStart] == num)
            return false;
        }
        return true;
    }
    public static boolean solveSudoku(int[][] board, int row, int col)
    {
        if (row == board.length)
        return true;
        if (col == board[0].length)
        return solveSudoku(board, row + 1, 0);
        if (board[row][col] != 0)
        return solveSudoku(board, row, col + 1);
        for (int num = 1; num <= 9; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, row, col + 1))
                return true;
                board[row][col] = 0;
            }
        }
        return false;
    }
    public static void print(int[][] board)
    {
        if(solveSudoku(board, 0, 0) == true)
        {
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
                System.out.println();
            }
        }
        else
        System.out.println("No solution exists");
    }
    public static void main(String args[])
    {
        int[][] board = new int[][]
        {
            {9, 0, 2, 0, 7, 8, 0, 0, 0},
            {1, 8, 0, 0, 0, 0, 7, 6, 0},
            {0, 7, 0, 5, 0, 0, 0, 0, 0},
            
            {7, 5, 0, 0, 0, 6, 0, 8, 4},
            {4, 0, 6, 0, 0, 0, 1, 5, 7},
            {0, 1, 0, 0, 4, 5, 3, 9, 6},
            
            {0, 2, 0, 0, 0, 0, 5, 0, 9},
            {6, 0, 9, 0, 0, 7, 8, 3, 0},
            {0, 0, 0, 9, 8, 4, 0, 7, 0}
        };
        print(board);
    }
}