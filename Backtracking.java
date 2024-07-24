public class Backtracking
{
    /*
     * Here we'll do the following:
     * 1. Solve N-Queens problem
     * 2. Solve Sudoku
     * 3. Solve Rat in a Maze
     * 4. Solve Knight's Tour
     */

    // Function to solve N-Queens problem
    public static void nQueens(int[][] board, int row)
    {

        /*
         * We'll use the following approach:
         * 1. If all queens are placed successfully, print the board
         * 2. Try placing the queen in all columns in the current row. Recur to place the rest of the queens
         * 3. If placing queen in the current column leads to a solution, then return true
         * 4. If placing queen in the current column does not lead to a solution, then backtrack and remove the queen
         * 5. If all columns are tried and no solution is found, then return false
         * 6. If all rows are tried, then return true
         */

        if (row == board.length)
        {
            for (int i = 0; i < board.length; i++)
            {
                for (int j = 0; j < board.length; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < board.length; i++)
        {
            if (isSafe(board, row, i))
            {
                board[row][i] = 1;
                nQueens(board, row + 1);
                board[row][i] = 0;
            }
        }
    }
    public static boolean isSafe(int[][] board, int row, int col)
    {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    /*
     * The time complexity of the above function is O(n!) where n is the number of queens
     */

    // Function to solve Sudoku
    public static boolean solveSudoku(int[][] board)
    {

        /*
         * We'll use the following approach:
         * 1. Find an empty cell
         * 2. If there is no empty cell, return true
         * 3. For digits from 1 to 9, check if the digit can be placed in the cell
         * 4. If the digit can be placed, place the digit and recur to solve the rest of the board
         * 5. If the digit cannot be placed, backtrack and try the next digit
         * 6. If no digit can be placed, return false
         * 7. If all digits are tried, return true
         */

        int row = -1, col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
                break;
        }
        if (isEmpty)
            return true;
        for (int i = 1; i <= board.length; i++)
        {
            if (isSafe(board, row, col, i))
            {
                board[row][col] = i;
                if (solveSudoku(board))
                    return true;
                board[row][col] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] board, int row, int col, int num)
    {
        for (int i = 0; i < board.length; i++)
            if (board[row][i] == num || board[i][col] == num)
                return false;
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++)
        {
            for (int j = colStart; j < colStart + sqrt; j++)
            {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    /*
     * The time complexity of the above function is O(n^(n^2)) where n is the number of rows/columns in the board
     */

    // Function to solve Rat in a Maze
    public static boolean solveMaze(int[][] maze, int x, int y, int[][] sol)
    {

        /*
         * We'll use the following approach:
         * 1. If x, y is the destination, return true
         * 2. If x, y is safe, mark x, y as part of solution path
         * 3. Move forward in x direction and recur
         * 4. If moving in x direction doesn't give solution, then move down in y direction and recur
         * 5. If none of the above movements work, then backtrack and unmark x, y as part of solution path
         * 6. If none of the above movements work, return false
         * 7. If all movements work, return true
         * 8. If x, y is not safe, return false
         * 9. If x, y is not within bounds, return false
         */

        if (x == maze.length - 1 && y == maze.length - 1)
        {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y))
        {
            sol[x][y] = 1;
            if (solveMaze(maze, x + 1, y, sol))
                return true;
            if (solveMaze(maze, x, y + 1, sol))
                return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    /*
     * The time complexity of the above function is O(2^(n^2)) where n is the number of rows/columns in the maze
     */

    // Function to solve Knight's Tour
    public static boolean solveKnightTour(int[][] board)
    {

        /*
         * We'll use the following approach:
         * 1. Create a solution matrix of the same size as the board
         * 2. Initialize the solution matrix with -1
         * 3. xMove[] and yMove[] define next move of Knight
         * 4. Since the Knight is initially at the first block, mark the first block as visited
         * 5. Start from 0, 0 and explore all eight possible moves from the current position
         * 6. If the Knight can move to position x, y, mark this as part of the solution
         * 7. If the Knight can move to position x, y, recursively check if this move leads to a solution
         * 8. If the move chosen in the above step doesn't lead to a solution, then unmark this move and try other moves
         * 9. If none of the moves work, return false
         * 10. If all the moves work, return true
         * 11. If x, y is not within bounds, return false
         * 12. If x, y is not safe, return false
         * 13. If x, y is already visited, return false
         */

        int[][] sol = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
                sol[i][j] = -1;
        }
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 0;
        if (!solveKnightTourUtil(board, 0, 0, 1, sol, xMove, yMove))
        {
            System.out.println("Solution does not exist");
            return false;
        }
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
        return true;
    }
    public static boolean solveKnightTourUtil(int[][] board, int x, int y, int move, int[][] sol, int[] xMove, int[] yMove)
    {
        if (move == board.length * board.length)
            return true;
        for (int i = 0; i < 8; i++)
        {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];
            if (isSafe(board, nextX, nextY, sol))
            {
                sol[nextX][nextY] = move;
                if (solveKnightTourUtil(board, nextX, nextY, move + 1, sol, xMove, yMove))
                    return true;
                sol[nextX][nextY] = -1;
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] board, int x, int y, int[][] sol)
    {
        return x >= 0 && x < board.length && y >= 0 && y < board.length && sol[x][y] == -1;
    }

    /*
     * The time complexity of the above function is O(8^(n^2)) where n is the number of rows/columns in the board
     */

    public static void main(String[] args)
    {
        int[][] board = new int[4][4];
        nQueens(board, 0);
        int[][] sudoku = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                          {5, 2, 0, 0, 0, 0, 0, 0, 0},
                          {0, 8, 7, 0, 0, 0, 0, 3, 1},
                          {0, 0, 3, 0, 0, 0, 1, 8, 0},
                          {9, 0, 0, 8, 6, 3, 0, 0, 5},
                          {0, 5, 0, 0, 9, 0, 6, 0, 0},
                          {1, 3, 0, 0, 0, 0, 2, 5, 0},
                          {0, 0, 0, 0, 0, 0, 0, 7, 4},
                          {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solveSudoku(sudoku);
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}};
        int[][] sol = new int[maze.length][maze.length];
        solveMaze(maze, 0, 0, sol);
        int[][] knightBoard = new int[8][8];
        solveKnightTour(knightBoard);
    }
}