import java.util.*;

public class Infix
{

    /*
     * Here we'll do the following:
     * 1. Convert Infix to Postfix
     * 2. Convert Infix to Prefix
     */

     /*

      * Infix expressions are the expressions that we normally use,
      * e.g. 5 + 5, 3 * 4, etc., where the operators are written in-between their operands.
      * The infix expressions are hard to parse by the computers and
      * convert to machine-readable form as they require more processing to evaluate.
      * The infix expressions are easier for humans to read, write and understand.
      * Some example expressions in infix notation are:
      * 1. a + b * c
      * 2. (a + b) * c
      * 3. a * (b + c) / d
      * 4. (a + b) * (c + d)

      */

      /* 

       * Since infix to postfix is most commonly used, we'll lay down the steps for it:
       * 1. If the scanned character is an open parenthesis, push it to the stack.
       * 2. If the scanned character is an operand, add it to the postfix string (or print it).
       * 3. If the scanned character is an operator, pop all the operators from the stack
       * which are greater than or equal to in precedence than that of the scanned operator.
       * After doing that, push the scanned operator to the stack.
       * 4. If the scanned character is a closing parenthesis, pop all the operators
       * from the stack and add them to the postfix string until an open parenthesis is encountered.
       * Pop the open parenthesis as well.
       * 5. Repeat steps 2-5 until the infix string is scanned completely.
       * 6. Pop all the remaining operators from the stack and add them to the postfix string.
       * 7. The final postfix string is the required answer.
       
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

    // Function to convert Infix to Postfix
    public static String infixToPostfix(String infix)
    {
        // Initialize the postfix string
        String postfix = "";

        // Initialize the stack
        Stack<Character> stack = new Stack<>();

        // Iterate through the infix string
        for(int i = 0; i < infix.length(); i++)
        {
            // Get the current character
            char c = infix.charAt(i);

            // Check if the current character is an operand
            if(Character.isLetterOrDigit(c))
            {
                postfix += c;
            }
            // Check if the current character is an opening parenthesis
            else if(c == '(')
            {
                stack.push(c);
            }
            // Check if the current character is a closing parenthesis
            else if(c == ')')
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                {
                    postfix += stack.pop();
                }
                stack.pop();
            }
            // Check if the current character is an operator
            else
            {
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the remaining elements from the stack
        while(!stack.isEmpty())
        {
            postfix += stack.pop();
        }

        // Return the postfix string
        return postfix;
    }

    // Function to convert Infix to Prefix
    public static String infixToPrefix(String infix)
    {
        // Initialize the prefix string
        String prefix = "";

        // Reverse the infix string
        infix = new StringBuilder(infix).reverse().toString();

        // Initialize the stack
        Stack<Character> stack = new Stack<>();

        // Iterate through the reversed infix string
        for(int i = 0; i < infix.length(); i++)
        {
            // Get the current character
            char c = infix.charAt(i);

            // Check if the current character is an operand
            if(Character.isLetterOrDigit(c))
            {
                prefix += c;
            }
            // Check if the current character is a closing parenthesis
            else if(c == ')')
            {
                stack.push(c);
            }
            // Check if the current character is an opening parenthesis
            else if(c == '(')
            {
                while(!stack.isEmpty() && stack.peek() != ')')
                {
                    prefix += stack.pop();
                }
                stack.pop();
            }
            // Check if the current character is an operator
            else
            {
                while(!stack.isEmpty() && precedence(c) < precedence(stack.peek()))
                {
                    prefix += stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the remaining elements from the stack
        while(!stack.isEmpty())
        {
            prefix += stack.pop();
        }

        // Reverse the prefix string
        prefix = new StringBuilder(prefix).reverse().toString();

        // Return the prefix string
        return prefix;
    }

    public static void main(String[] args)
    {
        // Test the infixToPostfix function
        String infix = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + infixToPostfix(infix));

        // Test the infixToPrefix function
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}
