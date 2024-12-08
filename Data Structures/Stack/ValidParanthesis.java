import java.util.*;

public class ValidParanthesis
{

    /*
     * Here we'll do the following:
     * 1. Check if the given string of paranthesis is valid or not using Recursion
     * 2. Check if the given string of paranthesis is valid or not using Stack
     */

    // Function to check if the given string of paranthesis is valid or not using Recursion
    public static boolean isValidParanthesisUsingRecursion(String s)
    {
        // If the length of the string is 0, then it is valid
        if(s.length() == 0)
        {
            return true;
        }

        // If the length of the string is odd, then it is invalid
        if(s.length() % 2 != 0)
        {
            return false;
        }

        // If the first character is a closing paranthesis, then it is invalid
        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
        {
            return false;
        }

        // If the first character is an opening paranthesis, then find the corresponding closing paranthesis
        char c = ' ';
        if(s.charAt(0) == '(')
        {
            c = ')';
        }
        else if(s.charAt(0) == '[')
        {
            c = ']';
        }
        else if(s.charAt(0) == '{')
        {
            c = '}';
        }

        // Find the index of the corresponding closing paranthesis
        int index = s.indexOf(c);

        // If the index is -1, then it is invalid
        if(index == -1)
        {
            return false;
        }

        // Recursively check the remaining string
        return isValidParanthesisUsingRecursion(s.substring(1, index) + s.substring(index + 1));
    }

    // Function to check if the given string of paranthesis is valid or not using Stack
    public static boolean isValidParanthesisUsingStack(String s)
    {
        // Create a stack
        Stack<Character> stack = new Stack<>();

        // Traverse the string
        for(int i = 0; i < s.length(); i++)
        {
            // If the current character is an opening paranthesis, then push it into the stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                stack.push(s.charAt(i));
            }
            // If the current character is a closing paranthesis
            else
            {
                // If the stack is empty, then it is invalid
                if(stack.isEmpty())
                {
                    return false;
                }

                // If the current character is ')' and the top element of the stack is not '(', then it is invalid
                if(s.charAt(i) == ')' && stack.peek() != '(')
                {
                    return false;
                }

                // If the current character is ']' and the top element of the stack is not '[', then it is invalid
                if(s.charAt(i) == ']' && stack.peek() != '[')
                {
                    return false;
                }

                // If the current character is '}' and the top element of the stack is not '{', then it is invalid
                if(s.charAt(i) == '}' && stack.peek() != '{')
                {
                    return false;
                }

                // Pop the top element of the stack
                stack.pop();
            }
        }

        // If the stack is empty, then it is valid
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        // Test the functions on the given examples
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        // Check if the given string of paranthesis is valid or not using Recursion
        System.out.println("Is the given string of paranthesis valid using Recursion? " + isValidParanthesisUsingRecursion(s1)); // true
        System.out.println("Is the given string of paranthesis valid using Recursion? " + isValidParanthesisUsingRecursion(s2)); // true
        System.out.println("Is the given string of paranthesis valid using Recursion? " + isValidParanthesisUsingRecursion(s3)); // false
        System.out.println("Is the given string of paranthesis valid using Recursion? " + isValidParanthesisUsingRecursion(s4)); // false
        System.out.println("Is the given string of paranthesis valid using Recursion? " + isValidParanthesisUsingRecursion(s5)); // true

        // Check if the given string of paranthesis is valid or not using Stack
        System.out.println("Is the given string of paranthesis valid using Stack? " + isValidParanthesisUsingStack(s1)); // true
        System.out.println("Is the given string of paranthesis valid using Stack? " + isValidParanthesisUsingStack(s2)); // true
        System.out.println("Is the given string of paranthesis valid using Stack? " + isValidParanthesisUsingStack(s3)); // false
        System.out.println("Is the given string of paranthesis valid using Stack? " + isValidParanthesisUsingStack(s4)); // false
        System.out.println("Is the given string of paranthesis valid using Stack? " + isValidParanthesisUsingStack(s5)); // true
    }
}
