import java.util.*;

public class NearestSmallerElement
{

    /*
     * Here we'll do the following:
     * 1. Find the nearest smaller element to the left of each element in an array
     * 2. Find the nearest smaller element to the right of each element in an array
     */

    // Function to find the nearest smaller element to the left of each element in an array
    public static int[] nearestSmallerElementToLeft(int[] arr)
    {
        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Create an array to store the result
        int[] result = new int[arr.length];

        // Traverse the array from left to right
        for(int i = 0; i < arr.length; i++)
        {
            // If the stack is empty, then there is no smaller element to the left
            if(stack.isEmpty())
            {
                result[i] = -1;
            }
            // If the stack is not empty and the top element is smaller than the current element
            else if(!stack.isEmpty() && stack.peek() < arr[i])
            {
                result[i] = stack.peek();
            }
            // If the stack is not empty and the top element is greater than or equal to the current element
            else if(!stack.isEmpty() && stack.peek() >= arr[i])
            {
                // Pop elements from the stack until the top element is smaller than the current element
                while(!stack.isEmpty() && stack.peek() >= arr[i])
                {
                    stack.pop();
                }

                // If the stack is empty, then there is no smaller element to the left
                if(stack.isEmpty())
                {
                    result[i] = -1;
                }
                // If the stack is not empty, then the top element is the nearest smaller element to the left
                else
                {
                    result[i] = stack.peek();
                }
            }

            // Push the current element into the stack
            stack.push(arr[i]);
        }

        return result;
    }

    // Function to find the nearest smaller element to the right of each element in an array
    public static int[] nearestSmallerElementToRight(int[] arr)
    {
        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Create an array to store the result
        int[] result = new int[arr.length];

        // Traverse the array from right to left
        for(int i = arr.length - 1; i >= 0; i--)
        {
            // If the stack is empty, then there is no smaller element to the right
            if(stack.isEmpty())
            {
                result[i] = -1;
            }
            // If the stack is not empty and the top element is smaller than the current element
            else if(!stack.isEmpty() && stack.peek() < arr[i])
            {
                result[i] = stack.peek();
            }
            // If the stack is not empty and the top element is greater than or equal to the current element
            else if(!stack.isEmpty() && stack.peek() >= arr[i])
            {
                // Pop elements from the stack until the top element is smaller than the current element
                while(!stack.isEmpty() && stack.peek() >= arr[i])
                {
                    stack.pop();
                }

                // If the stack is empty, then there is no smaller element to the right
                if(stack.isEmpty())
                {
                    result[i] = -1;
                }
                // If the stack is not empty, then the top element is the nearest smaller element to the right
                else
                {
                    result[i] = stack.peek();
                }
            }

            // Push the current element into the stack
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args)
    {
        // Input array
        int[] arr = {4, 5, 2, 10, 8};

        // Find the nearest smaller element to the left of each element in the array
        int[] left = nearestSmallerElementToLeft(arr);

        // Find the nearest smaller element to the right of each element in the array
        int[] right = nearestSmallerElementToRight(arr);

        // Print the result
        System.out.println("Nearest smaller element to the left of each element in the array:");
        for(int i = 0; i < left.length; i++)
        {
            System.out.print(left[i] + " ");
        }
        System.out.println();

        System.out.println("Nearest smaller element to the right of each element in the array:");
        for(int i = 0; i < right.length; i++)
        {
            System.out.print(right[i] + " ");
        }
        System.out.println();
    }
}
