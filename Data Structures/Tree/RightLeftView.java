import java.util.*;

public class RightLeftView
{

    /*
     * Here we'll do the following:
     * 1. Print the left view of the tree using Queue
     * 2. Print the right view of the tree using Queue
     * 3. Print the left view of the tree using HashMap
     * 4. Print the right view of the tree using HashMap
     */

    // Function to print the left view of the tree
    public static void leftView(Node root)
    {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                Node curr = queue.poll();
                if (i == 0)
                    System.out.print(curr.data + " ");

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
    }

    // Function to print the right view of the tree
    public static void rightView(Node root)
    {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                Node curr = queue.poll();
                if (i == size - 1)
                    System.out.print(curr.data + " ");

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
    }

    // Function to print the left view of the tree using HashMap
    public static void leftViewUsingHashMap(Node root)
    {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        HashMap<Integer, Integer> map = new HashMap<>();
        int level = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                Node curr = queue.poll();
                if (!map.containsKey(level))
                    map.put(level, curr.data);

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            level++;
        }

        for (int key : map.keySet())
            System.out.print(map.get(key) + " ");
    }

    // Function to print the right view of the tree using HashMap
    public static void rightViewUsingHashMap(Node root)
    {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        HashMap<Integer, Integer> map = new HashMap<>();
        int level = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                Node curr = queue.poll();
                if (!map.containsKey(level))
                    map.put(level, curr.data);

                if (curr.right != null)
                    queue.add(curr.right);
                if (curr.left != null)
                    queue.add(curr.left);
            }
            level++;
        }

        for (int key : map.keySet())
            System.out.print(map.get(key) + " ");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Node root = BinaryTreeImplementation.createBinaryTree(sc);

        leftView(root);
        System.out.println();
        rightView(root);
        System.out.println();
        leftViewUsingHashMap(root);
        System.out.println();
        rightViewUsingHashMap(root);

        sc.close();
    }
}
