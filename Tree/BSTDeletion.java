public class BSTDeletion extends BSTInsertion
{

    /*
     * Here we'll do the following:
     * 1. Implement the delete operation in a BST
     */

     BSTDeletion()
     {
         super(0);
     }

     // Function to delete a node from a BST
        public Node deleteNode(Node root, int key)
        {
            // Base case
            if (root == null)
            {
                return root;
            }
    
            // If the key to be deleted is smaller than the root's key, then it lies in the left subtree
            if (key < root.data)
            {
                root.left = deleteNode(root.left, key);
            }
            // If the key to be deleted is greater than the root's key, then it lies in the right subtree
            else if (key > root.data)
            {
                root.right = deleteNode(root.right, key);
            }
            // If the key is same as root's key, then this is the node to be deleted
            else
            {
                // Node with only one child or no child
                if (root.left == null)
                {
                    return root.right;
                }
                else if (root.right == null)
                {
                    return root.left;
                }
    
                // Node with two children: Get the inorder successor
                // (smallest in the right subtree which also has left child as null)
                root.data = (int) minValue(root.right);

                //We could have also taken the inorder predecessor (largest in the left subtree)
    
                // Delete the inorder successor
                root.right = deleteNode(root.right, root.data);
            }
    
            return root;
        }

        // Function to find the inorder successor
        public int minValue(Node root)
        {
            int minv = root.data;
            
            //Keep going to the left to find the minimum value
            while (root.left != null)
            {
                minv = root.left.data;
                root = root.left;
            }
            return minv;
        }

    public static void main(String[] args)
    {
        Node root = new Node(10);

        insert(root, 8);
        insert(root, 12);
        insert(root, 7);
        insert(root, 9);
        insert(root, 11);
        insert(root, 13);

        System.out.println("Inorder traversal of the given tree");
        BinaryTreeImplementation.printBinaryTree(root);

        System.out.println("\nDelete 12");
        root = new BSTDeletion().deleteNode(root, 12);

        System.out.println("Inorder traversal of the modified tree");
        BinaryTreeImplementation.printBinaryTree(root);
    }
}
