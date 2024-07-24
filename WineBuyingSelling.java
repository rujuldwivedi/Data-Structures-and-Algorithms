public class WineBuyingSelling
{
    
        /*
        * Here we'll do the following:
        * 1. Solve the Wine Buying and Selling problem using Recursion
        */
    
        // Function to solve the Wine Buying and Selling problem
        public static int wineBuyingSelling(int[] wines, int i, int j, int year)
        {
            if(i > j)
            {
                return 0;
            }
    
            int left = wines[i] * year + wineBuyingSelling(wines, i+1, j, year+1);
            int right = wines[j] * year + wineBuyingSelling(wines, i, j-1, year+1);
    
            return Math.max(left, right);
        }
    
        public static void main(String[] args)
        {
            int[] wines = {2, 4, 6, 2, 5};
            System.out.println(wineBuyingSelling(wines, 0, wines.length-1, 1));
        }
}
