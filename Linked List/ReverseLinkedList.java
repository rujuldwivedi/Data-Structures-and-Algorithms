public class ReverseLinkedList extends Node
{

    /*
     * Here we'll do the following:
     * 1. Implement a singly linked list.
     * 2. Reverse a singly linked list.
     */

    // Default constructor to create a node with data 0
    ReverseLinkedList()
    {
        super(0);
    }
    
    // Constructor to create a node with data inherited from Node class
    ReverseLinkedList(int data)
    {
        super(data);
    }

    // Function to reverse a singly linked list (iterative approach)
    public static Node reverseLinkedList(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    // Function to reverse a singly linked list (recursive approach)
    public static Node reverseLinkedListRecursive(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node rest = reverseLinkedListRecursive(head.next); 
        head.next.next = head;
        head.next = null;

        return rest;
    }

    // Function to print a singly linked list
    public static void printLinkedList(Node head)
    {
        Node current = head;

        while(current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original linked list:");
        printLinkedList(head);

        head = reverseLinkedList(head);
        System.out.println("Reversed linked list (iterative approach):");
        printLinkedList(head);

        head = reverseLinkedListRecursive(head);
        System.out.println("Reversed linked list (recursive approach):");
        printLinkedList(head);
    }
}
