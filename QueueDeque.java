import java.util.*;

public class QueueDeque
{

    /*

    * Here we'll do the following:
    * 1. Implement a Queue using LinkedList library
    * 2. Implement a Queue using ArrayDeque library
    * 3. Implement a Deque using LinkedList library
    * 4. Implement a Deque using ArrayDeque library
    * 5. Implement a Circular Queue using ArrayDeque library
    * 6. Implement a Circular Deque using ArrayDeque library
    * 7. Implement a Priority Queue using PriorityQueue library
    * 8. Implement a Priority Deque using PriorityQueue library
     
     */

    public static void main(String[] args)
    {
        // Implement a Queue using LinkedList library
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(10);
        queue1.offer(20);
        queue1.offer(30);
        System.out.println(queue1);
        System.out.println(queue1.poll());
        System.out.println(queue1);

        // Implement a Queue using ArrayDeque library
        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.offer(10);
        queue2.offer(20);
        queue2.offer(30);
        System.out.println(queue2);
        System.out.println(queue2.poll());
        System.out.println(queue2);

        // Implement a Deque using LinkedList library
        Deque<Integer> deque1 = new LinkedList<>();
        deque1.offer(10);
        deque1.offer(20);
        deque1.offer(30);
        System.out.println(deque1);
        System.out.println(deque1.pollFirst());
        System.out.println(deque1);
        System.out.println(deque1.pollLast());
        System.out.println(deque1);

        // Implement a Deque using ArrayDeque library
        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.offer(10);
        deque2.offer(20);
        deque2.offer(30);
        System.out.println(deque2);
        System.out.println(deque2.pollFirst());
        System.out.println(deque2);
        System.out.println(deque2.pollLast());
        System.out.println(deque2);

        // Implement a Priority Queue using PriorityQueue library
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30);
        priorityQueue.offer(20);
        priorityQueue.offer(10);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);

        // Implement a Priority Deque using PriorityQueue library
        Queue<Integer> priorityDeque = new PriorityQueue<>();
        priorityDeque.offer(30);
        priorityDeque.offer(20);
        priorityDeque.offer(10);
        System.out.println(priorityDeque);
        System.out.println(priorityDeque.poll());
        System.out.println(priorityDeque);

        /*

        * The general difference between {add(), remove(), element()} method
        * and {offer(), poll(), peek()} method is that {add(), remove(), element()}
        * throws an exception if the Queue is {full, empty} while {offer(), poll(), peek()}
        * returns false/null.
        
        */
    }
}
