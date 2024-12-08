public class StackArray
{

    /*
     * Here we'll do the following:
     * 1. Implement a stack using an array so that other classes can use it
     */

    int top;
    int[] stack;

    // Create a default constructor
    StackArray()
    {
        top = -1;
        stack = new int[1000];
    }

    // Create a constructor to initialize the stack
    StackArray(int size)
    {
        top = -1;
        stack = new int[size];
    }

    // Function to push an element into the stack
    public void push(int data)
    {
        if(top == stack.length - 1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = data;
    }

    // Function to pop an element from the stack
    public int pop()
    {
        if(top == -1)
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // Function to get the top element of the stack
    public int peek()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    // Function to check if the stack is empty
    public boolean isEmpty()
    {
        return top == -1;
    }

    // Function to get the size of the stack
    public int size()
    {
        return top + 1;
    }

    // Function to print the stack
    public void print()
    {
        for(int i = 0; i <= top; i++)
        {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        System.out.println();
    }
}
