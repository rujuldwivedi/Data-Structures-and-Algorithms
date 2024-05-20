public class HOF
{
    @FunctionalInterface
    // A functional interface is an interface that has
    //only one abstract method and is used
    //as the type of a lambda expression.
    interface IntFunction
    {
        // Functional interface to represent a function that takes an integer as input and returns an integer
        int apply(int x);
    }

    interface IntComparator
    {
        // Functional interface to represent a function that compares two integers
        int compare(int x, int y);
    }

    public static IntComparator getComparator()
    {
        // Function to return a function that compares two integers
        return (x, y) -> y - x;
    }

    public static IntFunction getSquare()
    {
        // Function to return a function that calculates the square of a number
        return x -> x * x;
    }

    public static int sumOfSquares(int n, IntFunction func)
    {
        // Function to calculate the sum of squares of numbers from 1 to n
        int sum = 0;
        for (int i = 1; i <= n; i++)
        {
            sum += func.apply(i);
        }
        return sum;
    }

    public static void main(String[] args)
    {   
        System.out.println("Sum of squares of numbers from 1 to 5: " + sumOfSquares(5, x -> x * x));
        IntFunction square = getSquare();
        System.out.println("Square of 5: " + square.apply(5));

        IntComparator comparator = getComparator();
        System.out.println("Comparing 5 and 10: " + comparator.compare(5, 10));
        //Now for descending order
        System.out.println("Comparing 10 and 5: " + comparator.compare(10, 5));
    }
    
}
