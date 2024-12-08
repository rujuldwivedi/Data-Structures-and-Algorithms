public class JosephusProblem
{
       /*
        * Here we'll do the following:
        * 1. Find number of ways in a nxm grid
        * 2. Josephus Problem
        */

    // Function for finding the number of ways in a nxm grid
    public static int ways(int n, int m)
    {
        if (n == 1 || m == 1)
            return 1;
        return ways(n - 1, m) + ways(n, m - 1);
    }
    // Function for finding the survivor in Josephus Problem
    public static int josephus(int n, int k)
    {

        /*
         * The problem is as follows:
         * There are n people in a circle and we have to find the position of the survivor
         * The people are numbered from 0 to n-1
         * We're given a number k and we have to remove the kth person from the circle
         * The next person is then counted as 1 and the process continues until only one person is left
         * The function below is a recursive function which finds the position of the survivor
         */

        if (n == 1)
            return 0;
        return (josephus(n - 1, k) + k) % n;
        // Here the '+k' represents the new index of the next recursive call and '%n' is used to wrap around the circle
    }
    public static void main(String[] args)
    {
        int n = 3, m = 3;
        System.out.println("Number of ways in a " + n + "x" + m + " grid is " + ways(n, m));
        int n1 = 5, k = 3;
        System.out.println("The survivor in Josephus Problem is at position " + josephus(n1, k));    
    }
}
