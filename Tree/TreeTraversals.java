import java.util.*;

public class TreeTraversals extends BinaryTreeImplementation
{

    /*
     * Here we'll do the following:
     * 1. Do Inorder Traversal of a binary tree
     * 2. Do Preorder Traversal of a binary tree
     * 3. Do Postorder Traversal of a binary tree
     */

    TreeTraversals(int data)
    {
        super(data);
    }

    // Function to do Inorder Traversal of a binary tree
    public static void inorderTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    // Function to do Preorder Traversal of a binary tree
    public static void preorderTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Function to do Postorder Traversal of a binary tree
    public static void postorderTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = createBinaryTree(sc);
        System.out.println("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println("\nPreorder Traversal: ");
        preorderTraversal(root);
        System.out.println("\nPostorder Traversal: ");
        postorderTraversal(root);

        sc.close();
    }

}
