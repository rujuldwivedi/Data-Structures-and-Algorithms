import java.util.*;

public class LowestCommonAncestor
{

    /*
     * Here we'll do the following:
     * 1. Find the lowest common ancestor of two nodes in a binary tree
     */

    // Function to find the lowest common ancestor of two nodes in a binary tree
    public static Node findLCA(Node root, Node n1, Node n2)
    {
        // Case where none of the nodes are present
        if(root == null)
            return null;

        // If the root is one of the nodes, then return the root
        if(root == n1 || root == n2)
            return root;

        // Find the LCA in the left and right subtrees
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        // If both the nodes are present in the right subtree, then the LCA from the right subtree is the LCA
        if(left == null)
        return right;

        // If both the nodes are present in the left subtree, then the LCA from the left subtree is the LCA
        if(right == null)
        return left;

        // If one node is present in the left subtree and the other in the right subtree, then the LCA is the root
        return root;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = BinaryTreeImplementation.createBinaryTree(sc);

        System.out.println("Enter the two nodes to find the lowest common ancestor of: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        Node node1 = BinaryTreeImplementation.findNode(root, n1);
        Node node2 = BinaryTreeImplementation.findNode(root, n2);

        Node lca = findLCA(root, node1, node2);

        System.out.println("Lowest common ancestor of " + n1 + " and " + n2 + " is: " + lca.data);

        sc.close();
    }
}
