import java.util.*;

public class Deque
{

    /*
     * Here we'll do the following:
     * 1. Implement the Deque using an ArrayDeque
     * 2. Implement Stack using Deque
     * 3. Implement Queue using Deque
     */

    public static void main(String[] args)
    {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        deque.pollFirst();
        deque.pollLast();

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        // Implementing Stack using Deque
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        // Implementing Queue using Deque
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
