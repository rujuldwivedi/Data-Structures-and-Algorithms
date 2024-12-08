public class Node
{

    /*
     * Here we'll do the following:
     * 1. Implement a singly linked list that can be used in other programs.
     */

    int data;
    int height;
    public Node prev;
    public Node next;
    public Node child;
    public Node left;
    public Node right;
    Node random;

    public Node(int data)
    {
        this.data = data;
        this.height = 1;
        this.next = null;
        this.child = null;
        this.prev = null;
        this.left = null;
        this.right = null;
        this.random = null;
    }
    public static void main(String[] args)
    {
        System.out.println();
    }
}