public class StackImplementation extends StackArray
{

    /*
     * Here we'll do the following:
     * 1. Use the implementation of a stack using an array from StackArray class
     * 2. Implement a stack using a linked list
     * 3. Implementing all the operations of a stack
     */

    // Using stack array class to implement stack
    public static void implementStackArray()
    {
        // Create a stack
        StackArray stack = new StackArray(5);

        // Push elements into the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Print the top element of the stack
        System.out.println(stack.peek());

        // Pop elements from the stack
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    // Implementing Stack using a linked list using nodes from Node class
     Node top;

    // Create a default constructor
    StackImplementation()
    {
        top = null;
    }

    // Function to push an element into the stack
    public void push(int data)
    {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Function to pop an element from the stack
    public int pop()
    {
        if(top == null)
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    // Function to get the top element of the stack
    public int peek()
    {
        if(top == null)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Function to check if the stack is empty
    public boolean isEmpty()
    {
        return top == null;
    }

    // Function to get the size of the stack
    public int size()
    {
        int count = 0;
        Node temp = top;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args)
    {
        // Implement stack using array
        implementStackArray();

        // Implement stack using linked list
        StackImplementation stack = new StackImplementation();

        // Push elements into the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Print the top element of the stack
        System.out.println(stack.peek());

        // Pop elements from the stack
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
