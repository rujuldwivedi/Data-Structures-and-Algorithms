public class LinkedListImplementation extends Node
{

    // Default constructor to create a node with data 0
    LinkedListImplementation()
    {
        super(0);
    }
    
    // Constructor to create a node with data inherited from Node class
    LinkedListImplementation(int data)
    {
        super(data);
    }

    /*
     * Here we'll do the following:
     * 1. Implement a singly linked list.
     * 2. Implement a doubly linked list.
     * 3. Implement a circular linked list.
     * 4. Implement a doubly circular linked list.
     * 5. Implement a linked list with a loop.
     * 6. Implement a linked list with a loop and find the start of the loop.
     * 7. Implement all the linked list operations.
     */

    // Node class for singly linked list (we'll inherit from Node class in Node.java)

    /*
     * Here's a code snippet to create a node of T type in Java.
     * class Node<T>
     * {
     *    T data;
     *   Node<T> next;
     * Node(T data)
     * {
     *   this.data = data;
     *  this.next = null;
     * }
     * }
     * 
     * Node<Integer> node = new Node<Integer>(10);
     * Node<String> node = new Node<String>("Hello");
     * Node<LinkedListImplementation> node = new Node<LinkedListImplementation>(new LinkedListImplementation());
     * Node<Queue> node = new Node<Queue>(new LinkedListImplementation());
     * Node<Stack> node = new Node<Stack>(new Stack());
     * Node<HashMap> node = new Node<HashMap>(new HashMap());
     * 
     * Below are some of the operations on the above node class.
     * node.data = 20;
     * node.next = new Node<Integer>(30);
     * node.next.next = new Node<Double>(40.0);
     * node.next.next.next = new Node<String>("World");
     * 
     * System.out.println(node.data);
     * System.out.println(node.next.data);
     * System.out.println(node.next.next.data);
     * System.out.println(node.next.next.next.data);
     * 
     */

    Node head;

    // Function to detect a loop in a linked list
    public static boolean detectLoop(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                return true;
            }
        }

        return false;
    }

    // Function to implement all the linked list operations

    public void insertAtBeginning(Node head, int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(Node head, int data)
    {
        Node newNode = new Node(data);
        Node temp = head;

        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void insertAtPosition(Node head, int data, int position)
    {
        Node newNode = new Node(data);
        Node temp = head;

        for(int i = 1; i < position - 1; i++)
        {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtBeginning(Node head)
    {
        head = head.next;
    }

    public void deleteAtEnd(Node head)
    {
        Node temp = head;

        while(temp.next.next != null)
        {
            temp = temp.next;
        }

        temp.next = null;
    }

    public void deleteAtPosition(Node head, int position)
    {
        Node temp = head;

        for(int i = 1; i < position - 1; i++)
        {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    public void display(Node head)
    {
        Node temp = head;

        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        LinkedListImplementation list = new LinkedListImplementation();

        list.insertAtBeginning(head, 0);
        list.insertAtEnd(head, 6);
        list.insertAtPosition(head, 10, 3);

        list.display(head);

        list.deleteAtBeginning(head);
        list.deleteAtEnd(head);
        list.deleteAtPosition(head, 3);

        list.display(head);

        System.out.println();

        System.out.println(detectLoop(head));

        head.next.next.next.next.next = head.next.next;

        System.out.println(detectLoop(head));

    }
}
