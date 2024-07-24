public class PalindromeLinkedList extends Node
{

    // Default constructor to create a node with data 0
    PalindromeLinkedList()
    {
        
        super(0);
    }
    
    // Constructor to create a node with data inherited from Node class
    PalindromeLinkedList(int data)
    {
        super(data);
    }

    /*
     * Here we'll do the following:
     * 1. Implement a singly linked list.
     * 2. Check if a singly linked list is a palindrome.
     */

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

    // Function to check if a singly linked list is a palindrome
    public static boolean isPalindrome(Node head)
    {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        // Node temp = null;
        Node secondHalf = null;
        Node midNode = null;
        boolean res = true;

        if(head != null && head.next != null)
        {
            while(fast != null && fast.next != null)
            {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }

            if(fast != null)
            {
                midNode = slow;
                slow = slow.next;
            }

            secondHalf = slow;
            prev.next = null;
            secondHalf = reverseLinkedList(secondHalf);
            res = compareLists(head, secondHalf);

            secondHalf = reverseLinkedList(secondHalf);

            if(midNode != null)
            {
                prev.next = midNode;
                midNode.next = secondHalf;
            }
            else
            {
                prev.next = secondHalf;
            }
        }

        return res;
    }

    // Function to compare two linked lists
    public static boolean compareLists(Node head1, Node head2)
    {
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null && temp2 != null)
        {
            if(temp1.data == temp2.data)
            {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
            {
                return false;
            }
        }

        if(temp1 == null && temp2 == null)
        {
            return true;
        }

        return false;
    }

    // Function to print a linked list
    public static void printLinkedList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println("Original linked list:");
        printLinkedList(head);

        if(isPalindrome(head))
        {
            System.out.println("The linked list is a palindrome.");
        }
        else
        {
            System.out.println("The linked list is not a palindrome.");
        }
    }

}
