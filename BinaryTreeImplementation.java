import java.util.*;

public class BinaryTreeImplementation extends Node
{

    /*
     * Here we'll do the following:
     * 1. Implement a binary tree
     */

    BinaryTreeImplementation(int data)
    {
        super(data);
    }

    // Function to create a binary tree
    public static Node createBinaryTree(Scanner sc)
    {
        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if (data  < 0)
        {
            return null;
        }
        root = new Node(data);
        System.out.println("Enter left child of " + data);
        root.left = createBinaryTree(sc);
        System.out.println("Enter right child of " + data);
        root.right = createBinaryTree(sc);
        return root;
    }

     // Function to find a node in a binary tree
    public static Node findNode(Node root, int data)
    {
        if (root == null)
        {
            return null;
        }
        if (root.data == data)
        {
            return root;
        }
        Node left = findNode(root.left, data);
        Node right = findNode(root.right, data);
        return left != null ? left : right;
    }

    // Function to print the binary tree
    public static void printBinaryTree(Node root)
    {
        if (root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = createBinaryTree(sc);
        printBinaryTree(root);

        sc.close();
    }
}
