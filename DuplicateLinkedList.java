import java.util.*;

public class DuplicateLinkedList extends Node
{

    // Create a default constructor
    DuplicateLinkedList()
    {
        super(0);
    }

    // Create a constructor to initialize the node
    DuplicateLinkedList(int data)
    {
        super(data);
    }

    /*
     * Here we'll do the following:
     * 1. Duplicate the linked list with random pointers, the pointers can point to any node in the linked list
     */

    // Function to duplicate the linked list
    public static Node duplicateLinkedList(Node head)
    {
        // Create a hashmap to store the nodes
        HashMap<Node, Node> map = new HashMap<Node, Node>();

        // Create a new head node
        Node newHead = new Node(0);
        Node p = head;
        Node q = newHead;

        // Traverse the linked list
        while(p != null)
        {
            // Create a new node
            Node temp = new Node(p.data);
            q.next = temp;
            q = temp;
            map.put(p, q);
            p = p.next;
        }

        // Reset the pointers
        p = head;
        q = newHead.next;

        // Traverse the linked list
        while(p != null)
        {
            if(p.random != null)
            {
                q.random = map.get(p.random);
            }
            p = p.next;
            q = q.next;
        }

        return newHead.next;
    }

    /*

    * Function to duplicate the list without using extra space
    * The idea is to insert a new node between the original nodes
    * Then set the random pointers
    * Then reset the pointers
    
    public static Node duplicateLinkedListWithoutExtraSpace(Node head)
    {
        Node p = head;

        while(p != null)
        {
            Node temp = new Node(p.data);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }

        p = head;

        while(p != null)
        {
            if(p.random != null)
            {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        p = head;
        Node newHead = p.next;
        Node q = newHead;

        while(p != null)
        {
            p.next = q.next;
            p = p.next;
            if(p != null)
            {
                q.next = p.next;
                q = q.next;
            }
        }

        return newHead;
    }

    */ 

    // Function to print the linked list
    public static void print(Node head)
    {
        Node p = head;
        while(p != null)
        {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        // Create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Set the random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next.next.next.next;
        head.next.next.next.next.random = head.next;

        // Print the linked list
        System.out.println("Original linked list:");
        print(head);

        // Duplicate the linked list
        Node newHead = duplicateLinkedList(head);
        // Node newHead2 = duplicateLinkedListWithoutExtraSpace(head);

        // Print the linked list
        System.out.println("Duplicated linked list:");
        print(newHead);
        // System.out.println("Duplicated linked list without extra space:");
        // print(newHead2);
    }

}
