public class BSTInsertion extends Node
{

    /*
     * Here we'll do the following:
     * 1. Implement the insert operation in a BST
     */

    BSTInsertion(int key)
    {
        super(key);
    }

    /*
    * Iterative approach:
     
    public static Node insert(Node root, int key)
    {
        Node parent = null;
        Node current = root;

        while (current != null)
        {
            parent = current;
            if (key < current.data)
            {
                current = current.left;
            }
            else
            {
                current =current.right;
            }
        }
    
        if (parent == null)
        {
            return new Node(key);
        }

        if (key < parent.data)
        {
            parent.left = new Node(key);
        }

        else
        {
            parent.right = new Node(key);
        }    

        return root;
    }
    
     */

    public static Node insert(Node root, int key)
    {
        if (root == null)
        {
            return new Node(key);
        }

        if (key < root.data)
        {
            root.left = insert(root.left, key);
        }
        else
        {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static void main(String[] args)
    {
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        BinaryTreeImplementation.printBinaryTree(root);
    }
}
