import java.util.*;

public class FlattenMLL extends Node
{

    /*
     * Here we'll do the following:
     * 1. Implement a function to flatten a multi-level linked list using a queue
     */

     FlattenMLL(int data)
     {
         super(data);
     }

    public static Node flatten(Node head)
    {
        if (head == null)
        {
            return null;
        }

        Node dummy = new Node(0);
        Node tail = dummy;
        Queue<Node> queue = new LinkedList<>();
        Node curr = head;

        while (curr != null || !queue.isEmpty())
        {
            if (curr.child != null)
            {
                queue.add((Node) curr.child);
            }

            tail.next = curr;
            curr.prev = tail;
            tail = curr;

            if (curr.next == null && !queue.isEmpty())
            {
                curr = queue.poll();
            }
            else
            {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    /*
     * Implementing the approach without using extra space:
     * What we're doing here is that we're flattening the linked list in place
     * We're iterating through the linked list and whenever we encounter a node with a child,
     * we'll flatten the child linked list and then merge it with the current linked list
     * We'll keep doing this until we reach the end of the linked list

     public static Node flatten(Node head)
     { 
        if (head == null)
        {
            return null;
        }
     
        Node temp = null;

        Node tail = head;

        while (tail.next != null)
        {
            tail = tail.next;
        }

        Node curr = head;

        while (curr != tail)
        {
            if (curr.child != null)
            {
                tail.next = curr.child;
                temp = curr.child;

                while (temp.next != null)
                {
                    temp = temp.next;
                }

                temp.next = curr.next;

                if (curr.next != null)
                {
                    curr.next.prev = temp;
                }

                curr.child = null;
            }

            curr = curr.next;
        }

        return head;
    }
     
     */

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.child = new Node(5);
        head.next.child.next = new Node(6);
        head.next.child.next.prev = head.next.child;
        head.next.child.next.next = new Node(7);
        head.next.child.next.next.prev = head.next.child.next;
        head.next.child.next.child = new Node(8);
        head.next.child.next.child.next = new Node(9);
        head.next.child.next.child.next.prev = head.next.child.next.child;
        head.next.child.next.child.next.next = new Node(10);
        head.next.child.next.child.next.next.prev = head.next.child.next.child.next;
        
        Node result = flatten(head);
        while (result != null)
        {
            System.out.print(result.data + " ");
            result = result.next;
        }

        System.out.println();

    }
}