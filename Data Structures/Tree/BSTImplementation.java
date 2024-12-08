import java.util.*;

public class BSTImplementation extends Node
{

    /*
     * Here we'll do the following:
     * 1. Implement a BST search operation
     */

    BSTImplementation(int key)
    {
        super(key);
    }

    // Function to search a given key in BST
    public static Node search(Node root, int key)
    {
        // Base Cases: root is null or key is present at root
        if (root == null || root.data == key)
            return root;

        // Key is greater than root's key
        if (root.data < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = BinaryTreeImplementation.createBinaryTree(sc);

        System.out.println("Enter the key to search: ");
        int key = sc.nextInt();

        Node result = search(root, key);

        if (result != null)
            System.out.println("Key found in the BST");
        else
            System.out.println("Key not found in the BST");
    }

}
