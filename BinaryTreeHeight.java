import java.util.*;

public class BinaryTreeHeight extends BinaryTreeImplementation
{

    /*
     * Here we'll do the following:
     * 1. Implement a binary tree
     * 2. Find the height of a binary tree
     */

    BinaryTreeHeight(int data)
    {
        super(data);
    }

    // Function to find the height of a binary tree
    public static int findHeight(Node root)
    {
        if (root == null)
        {
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) +1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = createBinaryTree(sc);
        System.out.println("Height of the binary tree: " + findHeight(root));

        sc.close();
    }
}