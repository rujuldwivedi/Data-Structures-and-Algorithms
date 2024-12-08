import java.util.*;

public class QueueStack
{

    /*
     * Here we'll do the following:
     * 1. Implement a Queue using two Stacks
     * 2. Implement a Stack using two Queues
     */

    // Function to implement a Queue using two Stacks
    public static class QueueUsingStack
    {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Function to add an element to the Queue
        public void enqueue(int data)
        {
            stack1.push(data);
        }

        // Function to remove an element from the Queue
        public int dequeue()
        {
            if (stack1.isEmpty() && stack2.isEmpty())
            {
                System.out.println("Queue is empty");
                return -1;
            }

            if (stack2.isEmpty())
            {
                while (!stack1.isEmpty())
                {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }
    }

    // Function to implement a Stack using two Queues
    public static class StackUsingQueue
    {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        // Function to add an element to the Stack
        public void push(int data)
        {
            queue2.add(data);

            while (!queue1.isEmpty())
            {
                queue2.add(queue1.poll());
            }

            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        // Function to remove an element from the Stack
        public int pop()
        {
            if (queue1.isEmpty())
            {
                System.out.println("Stack is empty");
                return -1;
            }

            return queue1.poll();
        }
    }

    public static void main(String[] args)
    {
        // Implement a Queue using two Stacks
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        // Implement a Stack using two Queues
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
