import java.util.*;

public class BinaryTreeToDLL
{

    /*
     * Here we'll do the following:
     * 1. Convert a binary tree to a doubly linked list, in terms of in-order traversal
     */

    static Node prev = null, head = null;

    // Function to convert a binary tree to a doubly linked list
    public static Node convertToDLL(Node root)
    {
        if(root == null)
            return null;

        convertToDLL(root.left);

        if(prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        convertToDLL(root.right);

        return head;
    }

    // Function to print the doubly linked list
    public static void printDLL(Node root)
    {
        Node temp = root;

        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = BinaryTreeImplementation.createBinaryTree(sc); 

        Node head = convertToDLL(root);
        printDLL(head);

        sc.close();
    }
}
