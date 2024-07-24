import java.util.*;

public class BinaryTreeDiamater
{

    /*
     * Here we'll do the following:
     * 1. Find the diameter of a binary tree
     */

    // Function to find the diameter of a binary tree
    public static int diameter(Node root)
    {
        if(root == null)
            return 0;

        int leftHeight = BinaryTreeHeight.findHeight(root.left);
        int rightHeight = BinaryTreeHeight.findHeight(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = BinaryTreeImplementation.createBinaryTree(sc);

        System.out.println("Diameter of the binary tree is: " + diameter(root));

        sc.close();
    }
}
