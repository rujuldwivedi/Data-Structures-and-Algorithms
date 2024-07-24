import java.util.Stack;

public class Prefix
{

    /*
     * Here we'll do the following:
     * 1. Convert Prefix to Infix
     * 2. Convert Prefix to Postfix
     */

     /*

      * Prefix expressions are the expressions in which the operators precede their operands,
      * e.g. + 5 5, * 3 4, etc., where the operators are written before their operands.
      * The prefix expressions are easier to parse by the computers and
      * convert to machine-readable form as they require less processing to evaluate.
      * The prefix expressions are harder for humans to read, write and understand.
      * Some example expressions in prefix notation are:
      * 1. + a b c
      * 2. * a + b c
      * 3. / * a + b c d
      * 4. * + a b + c d

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

    // Function to convert Prefix to Infix
    public static String prefixToInfix(String prefix)
    {
        // Initialize the stack
        Stack<String> stack = new Stack<>();

        // Iterate through the prefix string in reverse
        for(int i = prefix.length() - 1; i >= 0; i--)
        {
            // Get the current character
            char c = prefix.charAt(i);

            // Check if the current character is an operand
            if(Character.isLetterOrDigit(c))
            {
                stack.push(c + "");
            }
            // Check if the current character is an operator
            else
            {
                // Pop two operands from the stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // Combine the operands and the operator
                String combined = "(" + operand1 + c + operand2 + ")";

                // Push the combined string back to the stack
                stack.push(combined);
            }
        }

        // Return the infix expression
        return stack.pop();
    }

    // Function to convert Prefix to Postfix
    public static String prefixToPostfix(String prefix)
    {
        // Initialize the stack
        Stack<String> stack = new Stack<>();

        // Iterate through the prefix string in reverse
        for(int i = prefix.length() - 1; i >= 0; i--)
        {
            // Get the current character
            char c = prefix.charAt(i);

            // Check if the current character is an operand
            if(Character.isLetterOrDigit(c))
            {
                stack.push(c + "");
            }
            // Check if the current character is an operator
            else
            {
                // Pop two operands from the stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // Combine the operands and the operator
                String combined = operand1 + operand2 + c;

                // Push the combined string back to the stack
                stack.push(combined);
            }
        }

        // Return the postfix expression
        return stack.pop();
    }

    public static void main(String[] args)
    {
        String prefix = "*+AB-CD";

        // Test the prefixToInfix function
        System.out.println("Postfix: " + prefix);
        System.out.println("Infix: " + prefixToInfix(prefix));

        // Test the prefixToPostfix function
        System.out.println("Postfix: " + prefix);
        System.out.println("Postfix: " + prefixToPostfix(prefix));
    }
}
