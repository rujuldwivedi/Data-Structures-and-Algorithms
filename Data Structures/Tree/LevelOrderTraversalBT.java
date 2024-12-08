import java.util.*;

public class LevelOrderTraversalBT
{

    /*
     * Here we'll do the following:
     * 1. Implement a level order traversal of a binary tree.
     * 2. Implement a level order traversal of a binary tree using a queue.
     */

    // Function to print level order traversal of a binary tree
    public static void printLevelOrder(Node root)
    {
        int h = BinaryTreeHeight.findHeight(root);
        for (int i = 1; i <= h; i++)
        {
            printGivenLevel(root, i);
        }
    }

    // Print nodes at a given level 
    public static void printGivenLevel(Node root, int level)
    {
        if (root == null)
        {
            return;
        }
        if (level == 1)
        {
            System.out.print(root.data + " ");
        }
        else if (level > 1)
        {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    // Function to print level order traversal of a binary tree using a queue
    public static void printLevelOrderUsingQueue(Node root)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty())
        {
            Node tempNode = queue.poll();
            if (tempNode == null)
            {
                if (!queue.isEmpty())
                {
                    queue.add(null);
                    System.out.println();
                }
            }
            else
            {
                System.out.print(tempNode.data + " ");
                if (tempNode.left != null)
                {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null)
                {
                    queue.add(tempNode.right);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node root = BinaryTreeHeight.createBinaryTree(sc);

        System.out.println("Level order traversal of the binary tree: ");
        printLevelOrder(root);

        System.out.println("\nLevel order traversal of the binary tree using a queue: ");
        printLevelOrderUsingQueue(root);

        sc.close();
    }

}
