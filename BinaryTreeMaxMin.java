import java.util.*;

public class BinaryTreeMaxMin
{

    /*
     * Here we'll do the following:
     * 1. Implement a binary tree
     * 2. Find the size of a binary tree
     * 3. Find the maximum and minimum element in a binary tree
     */

    // Function to find the size of a binary tree
    public static int findSize(Node root)
    {
        if (root == null)
        {
            return 0;
        }
        return findSize(root.left) + findSize(root.right) + 1;
    }

    // Function to find the maximum element in a binary tree
    public static int findMax(Node root)
    {
        if (root == null)
        {
            return Integer.MIN_VALUE;
        }
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    // Function to find the minimum element in a binary tree
    public static int findMin(Node root)
    {
        if (root == null)
        {
            return Integer.MAX_VALUE;
        }
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = BinaryTreeImplementation.createBinaryTree(sc);
        System.out.println("Size of the binary tree: " + findSize(root));
        System.out.println("Maximum element in the binary tree: " + findMax(root));
        System.out.println("Minimum element in the binary tree: " + findMin(root));

        sc.close();
    }   
}
