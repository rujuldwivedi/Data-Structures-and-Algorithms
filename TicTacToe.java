import java.util.Scanner;
class TicTacToe
{
  static Scanner input = new Scanner(System.in);
    public static boolean haveWon(char[][] board, char player)
  {
    for (int row = 0; row < board.length; row++)
    {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player)
      return true;
    }
    for (int col = 0; col < board[0].length; col++)
    {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player)
      return true;
    }
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
    return true;
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
    return true;
    return false;
  }
  public static boolean isDraw(char[][] board)
  {
    for (int row = 0; row < board.length; row++)
    {
      for (int col = 0; col < board[row].length; col++)
      {
        if (board[row][col] == ' ')
        return false;
      }
    }
    return true;
  }
  public static void printBoard(char[][] board)
  {
    for (int row = 0; row < board.length; row++)
    {
        System.out.println();
      for (int col = 0; col < board[row].length; col++)
      {
        if(col != board[row].length - 1)
        System.out.print(board[row][col] + " | ");
        else
        System.out.print(board[row][col]);
      }
      System.out.println();
      if(row != board.length - 1)
      System.out.print("-- -- --");
    }
  }
  public static void Game()
  {
    char[][] board = new char[3][3];
    for (int row = 0; row < board.length; row++)
    {
      for (int col = 0; col < board[row].length; col++)
      {
        board[row][col] = ' ';
      }
    }
    printBoard(board);
    boolean isX = true;
    while (true)
    {
      char player = isX ? 'X' : 'O';
      System.out.print("Enter a row (1, 2, or 3) for player " + player + ": ");
      int row = input.nextInt();
      System.out.print("Enter a column (1, 2, or 3) for player " + player + ": ");
      int col = input.nextInt();
      if (board[row-1][col-1] == ' ')
      {
        board[row-1][col-1] = player;
        isX = !isX;
      }
      else
      {
        System.out.println("This cell is already occupied. Try a different cell");
      }
      printBoard(board);
      if (haveWon(board, player))
      {
        System.out.println(player + " won!");
        System.exit(0);
      }
      else if (isDraw(board))
      {
        System.out.println("No winner");
        System.exit(0);
      }
    }
  }
  public static void main(String[] args)
  {
    Game();
  }
}