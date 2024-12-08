public class MaximalRectangle
{

    /*
     * Here we'll do the following:
     * 1. Find the maximal rectangle in a binary matrix using Brute Force
     * 2. Find the maximal rectangle in a binary matrix using Stack
     */

    // Function to find the maximal rectangle in a binary matrix using Brute Force
    public static int maximalRectangleUsingBruteForce(int[][] matrix)
    {
        // Initialize the maximal rectangle area to 0
        int maximalRectangleArea = 0;

        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Initialize the heights array
        int[] heights = new int[columns];

        // Iterate through the rows of the matrix
        for(int i = 0; i < rows; i++)
        {
            // Iterate through the columns of the matrix
            for(int j = 0; j < columns; j++)
            {
                // Update the heights array
                heights[j] = matrix[i][j] == 1 ? heights[j] + 1 : 0;
            }

            // Update the maximal rectangle area
            maximalRectangleArea = Math.max(maximalRectangleArea, MaxAreaHistogram.maxAreaHistogramUsingStack(heights));
        }

        // Return the maximal rectangle area
        return maximalRectangleArea;
    }

    // Function to find the maximal rectangle in a binary matrix using Stack
    public static int maximalRectangleUsingStack(int[][] matrix)
    {
        int currRow[] = matrix[0];

        // Using the MaxAreaHistogram class to find the maximum area of a histogram using Stack
        int maxAns = MaxAreaHistogram.maxAreaHistogramUsingStack(currRow);

        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 1)
                {
                    currRow[j] += 1;
                }
                else
                {
                    currRow[j] = 0;
                    // This is done because if any of the row has 0, then the area will be 0 as there can't be any gaps in the rectangle
                }
            }

            maxAns = Math.max(maxAns, MaxAreaHistogram.maxAreaHistogramUsingStack(currRow));
        }

        return maxAns;

    }

    public static void main(String[] args)
    {
        // Test the maximal rectangle in a binary matrix using Brute Force
        int[][] matrix = {
            {1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1}
        };

        System.out.println("The maximal rectangle in the binary matrix using Brute Force is: " + maximalRectangleUsingBruteForce(matrix));

        // Test the maximal rectangle in a binary matrix using Stack
        System.out.println("The maximal rectangle in the binary matrix using Stack is: " + maximalRectangleUsingStack(matrix));
    }
}
