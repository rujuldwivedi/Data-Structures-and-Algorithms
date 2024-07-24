import java.util.*;

public class CheckBST extends BinaryTreeImplementation
{

    /*
     * Here we'll do the following:
     * 1. Implement the function to check if a binary tree is a BST
     */

    CheckBST()
    {
        super(0);
    }

    /*
     * What we'll do here is:
     * 1. We'll check if the greatest value in the left subtree is less than the root's value
     * 2. We'll check if the smallest value in the right subtree is greater than the root's value
     * 3. We'll check if the left and right subtrees are also BSTs
     */

    // Utility function to check if a binary tree is a BST
    public static boolean isBSTUtil(Node root, int min, int max)
    {
        // Base case
        if (root == null)
        {
            return true;
        }

        // If the node's value is not within the given range, then it is not a BST
        if (root.data < min || root.data > max)
        {
            return false;
        }

        /*
        *  The range is defined as follows:
        *  For the left subtree, the maximum value is the root's value - 1 and the minimum value is the minimum value of the root
        *  For the right subtree, the minimum value is the root's value + 1 and the maximum value is the maximum value of the root
        */

        // Check the subtrees recursively
        return isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max);

    }

    // Function to check if a binary tree is a BST
    public static boolean isBST(Node root)
    {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        Node root = createBinaryTree(sc);

        if (isBST(root))
        {
            System.out.println("The binary tree is a BST");
        }
        else
        {
            System.out.println("The binary tree is not a BST");
        }
    }
}
