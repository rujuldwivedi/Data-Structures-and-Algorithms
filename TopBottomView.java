import java.util.*;

public class TopBottomView extends Pair<Node, Integer>
{

    /*
     * Here we'll do the following:
     * 1. Print the top view of the tree
     * 2. Print the bottom view of the tree
     */

     TopBottomView(Node first, Integer second)
     {
         super(first, second);
     }

    // Function to print the top view of the tree
    public static void topView(Node root)
    {
        if (root == null)
            return;

        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair<Node, Integer>(root, 0));

        while (!queue.isEmpty())
        {
            Pair<Node, Integer> curr = queue.poll();
            Node node = curr.getFirst();

            // Get the horizontal distance of the current node
            int hd = curr.getSecond();

            // Keep the first node encountered at each horizontal distance
            if (!map.containsKey(hd))
                map.put(hd, node.data);

            if (node.left != null)
                queue.add(new Pair<Node, Integer>(node.left, hd - 1));
            if (node.right != null)
                queue.add(new Pair<Node, Integer>(node.right, hd + 1));
        }

        for (int key : map.keySet())
            System.out.print(map.get(key) + " ");
    }

    // Function to print the bottom view of the tree
    public static void bottomView(Node root)
    {
        if (root == null)
            return;
    
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair<Node, Integer>(root, 0));
    
        while (!queue.isEmpty())
        {
            Pair<Node, Integer> curr = queue.poll();
            Node node = curr.getFirst();

            // Get the horizontal distance of the current node
            int hd = curr.getSecond();
    
            // Update the last node encountered at each horizontal distance
            map.put(hd, node.data);
    
            if (node.left != null)
                queue.add(new Pair<Node, Integer>(node.left, hd - 1));
            if (node.right != null)
                queue.add(new Pair<Node, Integer>(node.right, hd + 1));
        }
    
        for (int key : map.keySet())
            System.out.print(map.get(key) + " ");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Create the tree
        Node root = BinaryTreeImplementation.createBinaryTree(sc);

        System.out.println("Top view of the tree:");
        topView(root);

        System.out.println("\nBottom view of the tree:");
        bottomView(root);

        sc.close();
    }
}
