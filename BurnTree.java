import java.util.*;

public class BurnTree extends Depth
{

    /*
     * Here we'll do the following:
     * 1. Find the minimum time to burn the tree from a given leaf node
     */

    BurnTree(int data)
    {
        super(data);
    }

    static int ans = -1;

    public static int burn(Node root, int target, Depth depth)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.data == target)
        {
            depth.depth = 1;
            return 1;
        }

        Depth leftDepth = new Depth(-1);
        Depth rightDepth = new Depth(-1);

        int left = burn(root.left, target, leftDepth);
        int right = burn(root.right, target, rightDepth);

        if (leftDepth.depth != -1)
        {
            ans = Math.max(ans, leftDepth.depth + right + 1);
            depth.depth = leftDepth.depth + 1;
        }

        else if (rightDepth.depth != -1)
        {
            ans = Math.max(ans, rightDepth.depth + left + 1);
            depth.depth = rightDepth.depth + 1;
        }

        return Math.max(left, right) + 1;
    }

    public static int minTime(Node root, int target)
    {
        Depth depth = new Depth(-1);
        burn(root, target, depth);
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Node root = BinaryTreeImplementation.createBinaryTree(sc);
        System.out.println("Enter the target node: ");
        int target = sc.nextInt();
        System.out.println("Minimum time to burn the tree from the target node: " + minTime(root, target));
        sc.close();
    }
}
