import java.util.*;

public class VerticalTraversal
{

    /*
     * Here we'll do the following:
     * 1. Do the vertical order traversal of the tree
     */

     // Function to do the vertical order traversal of the tree
    public static void verticalOrderTraversal(Node root)
    {
        // Base case
        if(root == null)
            return;

        // Create a map to store the vertical order traversal
        Map<Integer, List<Integer>> map = new TreeMap<>();

        // Create a queue to do the level order traversal
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();

        // Add the root node to the queue
        queue.add(new Pair<>(root, 0));

        // Do the level order traversal
        while(!queue.isEmpty())
        {
            // Get the front element of the queue
            Pair<Node, Integer> front = queue.poll();

            // Get the node and the horizontal distance of the node
            Node node = front.getFirst();
            int hd = front.getSecond();

            // If the hd is not present in the map, add it
            if(!map.containsKey(hd))
                map.put(hd, new ArrayList<>());

            // Add the node's data to the hd
            map.get(hd).add(node.data);

            // If the left child is not null, add it to the queue
            if(node.left != null)
                queue.add(new Pair<>(node.left, hd - 1));

            // If the right child is not null, add it to the queue
            if(node.right != null)
                queue.add(new Pair<>(node.right, hd + 1));
        }

        // Print the vertical order traversal
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            List<Integer> list = entry.getValue();
            for(int i = 0; i < list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Create the tree
        Node root = BinaryTreeImplementation.createBinaryTree(sc);

        // Do the vertical order traversal
        verticalOrderTraversal(root);

        sc.close();
    }
}
