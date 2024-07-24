import java.util.*;

public class MaxAreaHistogram
{

    /*
     * Here we'll do the following:
     * 1. Find the maximum area of a histogram using Brute Force
     * 2. Find the maximum area of a histogram using Stack
     */

    // Function to find the maximum area of a histogram using Brute Force
    public static int maxAreaHistogramUsingBruteForce(int[] heights)
    {
        // Initialize the maximum area to 0
        int maxArea = 0;

        // Iterate through the heights array
        for(int i = 0; i < heights.length; i++)
        {
            // Initialize the minimum height to the current height
            int minHeight = heights[i];

            // Iterate through the heights array again
            for(int j = i; j < heights.length; j++)
            {
                // Update the minimum height
                minHeight = Math.min(minHeight, heights[j]);

                // Update the maximum area
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }

        // Return the maximum area
        return maxArea;
    }

    // Function to find the maximum area of a histogram using Stack
    public static int maxAreaHistogramUsingStack(int[] heights)
    {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
     
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i = n - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
            
                right[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
        }
        
        int maxArea = 0;
        
        for(int i = 0; i < n; i++)
        {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        
        return maxArea;
    }
    
     /*

    * Here's another approach:
     
    public static int maxAreaHistogramUsingStack(int[] heights)
    {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= heights.length; i++)
        {
            int height = (i == heights.length) ? 0 : heights[i];

            if(stack.isEmpty() || height >= heights[stack.peek()])
            {
                stack.push(i);
            }
            else
            {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }

        return maxArea;
    }
     
     */

    public static void main(String[] args)
    {
        // Test the functions
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(maxAreaHistogramUsingBruteForce(heights)); // Output: 10
        System.out.println(maxAreaHistogramUsingStack(heights)); // Output: 10
    }
}
