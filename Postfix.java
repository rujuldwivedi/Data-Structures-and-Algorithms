import java.util.*;

public class Postfix
{

    /*
     * Here we'll do the following:
     * 1. Convert Postfix to Infix
     * 2. Convert Postfix to Prefix
     */

     /*

      * Postfix expressions are the expressions in which the operators follow their operands,
        * e.g. 5 5 +, 3 4 *, etc., where the operators are written after their operands.
        * The postfix expressions are easier to parse by the computers and
        * convert to machine-readable form as they require less processing to evaluate.
        * The postfix expressions are harder for humans to read, write and understand.
        * Some example expressions in postfix notation are:
        * 1. a b c * +
        * 2. a b + c *
        * 3. a b c + d /
        * 4. a b + c d + *

      */

      /*

        * Below are the steps/rules to evaluate a postfix expression:
        * 1. Scan the postfix expression from left to right.
        * 2. If the scanned character is an operand, push it to the stack.
        * 3. If the scanned character is an operator, pop two elements from the stack.
        * The first element popped is the second operand
        * and the second element popped is the first operand.
        * Perform the operation and push the result back to the stack.
        * 4. Repeat steps 2-3 until the postfix string is scanned completely.
        * 5. The final element remaining in the stack is the result of the postfix expression.
        
        */

      /*
       * Between prefix and postfix, the prefix notation is more efficient as it does not require any parenthesis to denote the order of operations.
       */

     // Function to get the precedence of an operator
        public static int precedence(char c)
        {
            switch(c)
            {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
            }
            return -1;
        }

    // Function to convert Postfix to Infix
    public static String postfixToInfix(String postfix)
    {
        // Initialize the stack
        Stack<String> stack = new Stack<>();

        // Iterate through the postfix string
        for(int i = 0; i < postfix.length(); i++)
        {
            // Get the current character
            char c = postfix.charAt(i);

            // Check if the current character is an operand
            if(Character.isLetterOrDigit(c))
            {
                stack.push(c + "");
            }
            // Check if the current character is an operator
            else
            {
                // Pop two operands from the stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                // Combine the operands and the operator
                String combined = "(" + operand1 + c + operand2 + ")";

                // Push the combined string back to the stack
                stack.push(combined);
            }
        }

        // Return the final infix expression
        return stack.pop();
    }

    // Function to convert Postfix to Prefix
    public static String postfixToPrefix(String postfix)
    {
        // Initialize the stack
        Stack<String> stack = new Stack<>();

        // Iterate through the postfix string
        for(int i = 0; i < postfix.length(); i++)
        {
            // Get the current character
            char c = postfix.charAt(i);

            // Check if the current character is an operand
            if(Character.isLetterOrDigit(c))
            {
                stack.push(c + "");
            }
            // Check if the current character is an operator
            else
            {
                // Pop two operands from the stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                // Combine the operands and the operator
                String combined = c + operand1 + operand2;

                // Push the combined string back to the stack
                stack.push(combined);
            }
        }

        // Return the final prefix expression
        return stack.pop();
    }

    public static void main(String[] args)
    {
        String postfix = "ab+ef*g*-";

        // Test the postfixToInfix function
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + postfixToInfix(postfix));

        // Test the postfixToPrefix function
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + postfixToPrefix(postfix));
    }

}
