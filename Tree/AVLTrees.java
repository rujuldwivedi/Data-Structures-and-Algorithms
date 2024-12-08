public class AVLTrees
{

    /*
     * Here we'll do the following:
     * 1. Implement the AVL Tree
     * 2. Implement the AVL Tree rotations
     * 3. Implement the following operations on the AVL Tree:   
     *   a. Insertion
     *   b. Deletion
     *   c. Searching
     * 4. Implement the AVL Tree traversal
     */

      /*
    
     * Some concepts/characteristics of AVL Trees:
     * 1. AVL Tree is a self-balancing binary search tree.
     * 2. The height of the left and right subtrees of any node differ by at most one.
     * 3. If at any time they differ by more than one, rebalancing is done to restore this property.
     * 4. The rotations are used to restore the balance of the tree.
     * 5. The rotations are of four types:
     *  a. Left Rotation
     * b. Right Rotation
     * c. Left-Right Rotation
     * d. Right-Left Rotation
     * 6. The time complexity of the AVL Tree operations is O(log n).
     * 7. The AVL Tree is used in the applications where the search operations are more frequent than the insertions and deletions.
    
     */

     // Implementing the AVL Tree
     Node root;

    // Implement the rotation operations
    public static Node rightRotate(Node y)
    {
        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        y.height = Math.max(BinaryTreeHeight.findHeight(y.left), BinaryTreeHeight.findHeight(y.right)) + 1;
        x.height = Math.max(BinaryTreeHeight.findHeight(x.left), BinaryTreeHeight.findHeight(x.right)) + 1;

        return x;
    }

    public static Node leftRotate(Node x)
    {
        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        x.height = Math.max(BinaryTreeHeight.findHeight(x.left), BinaryTreeHeight.findHeight(x.right)) + 1;
        y.height = Math.max(BinaryTreeHeight.findHeight(y.left), BinaryTreeHeight.findHeight(y.right)) + 1;

        return y;
    }

    public static int getBalance(Node node)
    {
        if(node == null)
        {
            return 0;
        }

        return BinaryTreeHeight.findHeight(node.left) - BinaryTreeHeight.findHeight(node.right);
    }

    // Implement the following operations on the AVL Tree
    // a. Insertion
    public static Node insert(Node node, int data)
    {
        if(node == null)
        {
            return (new Node(data));
        }

        if(data < node.data)
        {
            node.left = insert(node.left, data);
        }
        else if(data > node.data)
        {
            node.right = insert(node.right, data);
        }
        else
        {
            return node;
        }

        node.height = 1 + Math.max(BinaryTreeHeight.findHeight(node.left), BinaryTreeHeight.findHeight(node.right));

        int balance = getBalance(node);

        // Left Left Case (left crowded and left subtree is more crowded)
        if(balance > 1 && data < node.left.data)
        {
            return rightRotate(node);
        }

        // Right Right Case (right crowded and right subtree is more crowded)
        if(balance < -1 && data > node.right.data)
        {
            return leftRotate(node);
        }

        // Left Right Case (left crowded and right subtree is more crowded)
        if(balance > 1 && data > node.left.data)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case (right crowded and left subtree is more crowded)
        if(balance < -1 && data < node.right.data)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static Node minValueNode(Node node)
    {
        Node current = node;

        while(current.left != null)
        {
            current = current.left;
        }

        return current;
    }

    // b. Deletion
    public static Node deleteNode(Node root, int data)
    {
        if(root == null)
        {
            return root;
        }

        if(data < root.data)
        {
            root.left = deleteNode(root.left, data);
        }
        else if(data > root.data)
        {
            root.right = deleteNode(root.right, data);
        }
        else
        {
            if(root.left == null || root.right == null)
            {
                Node temp = null;

                if(temp == root.left)
                {
                    temp = root.right;
                }
                else
                {
                    temp = root.left;
                }

                if(temp == null)
                {
                    temp = root;
                    root = null;
                }
                else
                {
                    root = temp;
                }
            }
            else
            {
                Node temp = minValueNode(root.right);

                root.data = temp.data;

                root.right = deleteNode(root.right, temp.data);
            }
        }

        if(root == null)
        {
            return root;
        }

        root.height = Math.max(BinaryTreeHeight.findHeight(root.left), BinaryTreeHeight.findHeight(root.right)) + 1;

        int balance = getBalance(root);

        if(balance > 1 && getBalance(root.left) >= 0)
        {
            return rightRotate(root);
        }

        if(balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if(balance < -1 && getBalance(root.right) <= 0)
        {
            return leftRotate(root);
        }

        if(balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // c. Searching
    public static Node search(Node root, int data)
    {
        if(root == null || root.data == data)
        {
            return root;
        }

        if(root.data < data)
        {
            return search(root.right, data);
        }

        return search(root.left, data);
    }

    // Implement the AVL Tree traversal
    public static void inOrder(Node node)
    {
        if(node != null)
        {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void preOrder(Node node)
    {
        if(node != null)
        {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void postOrder(Node node)
    {
        if(node != null)
        {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args)
    {
        Node root = null;

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.println("Inorder traversal of the constructed AVL tree is: ");
        inOrder(root);
        System.out.println();

        root = deleteNode(root, 30);

        System.out.println("Inorder traversal of the AVL tree after deletion of 30 is: ");
        inOrder(root);
        System.out.println();

        Node searchNode = search(root, 40);

        if(searchNode != null)
        {
            System.out.println("The node with data 40 is found in the AVL tree.");
        }
        else
        {
            System.out.println("The node with data 40 is not found in the AVL tree.");
        }

        System.out.println("Preorder traversal of the AVL tree is: ");
        preOrder(root);

        System.err.println();

        System.out.println("Inorder traversal of the AVL tree is: ");
        inOrder(root);

        System.out.println();    

        System.out.println("Postorder traversal of the AVL tree is: ");
        postOrder(root);

        System.out.println("The height of the AVL tree is: " + BinaryTreeHeight.findHeight(root));
    }

    /*

     * Some concepts/characteristics of Red-Black Trees:
     * 1. Red-Black Tree is a self-balancing binary search tree.
     * 2. The nodes are colored either red or black.
     * 3. The root is always black.
     * 4. The children of red nodes are always black.
     * 5. Every path from a node to its descendant NULL nodes has the same number of black nodes.
     * 6. The rotations are used to restore the balance of the tree.
     * 7. The rotations are of two types:

     * a. Left Rotation
     *      i. The right child of the node becomes the new root of the subtree.
     *    ii. The left child of the right child of the node becomes the right child of the node.
     * iii. The right child of the right child of the node becomes the left child of the right child of the node.
    
     * b. Right Rotation
     *     i. The left child of the node becomes the new root of the subtree.
     *   ii. The right child of the left child of the node becomes the left child of the node.
     * iii. The left child of the left child of the node becomes the right child of the left child of the node.

     * 8. The time complexity of the Red-Black Tree operations is O(log n).
     * 9. The Red-Black Tree is used in the applications where the insertions and deletions are more frequent than the search operations.
     * 10. The algorithms are as follows:

     * a. Insertion
     *     i. Insert the node as in the binary search tree.
     *    ii. Color the node as red.
     *  iii. If the parent of the node is red, then fix the tree.
     *  iv. If the uncle of the node is red, then recolor the parent, uncle, and grandparent.
     *  v. If the uncle of the node is black, then perform the rotations.
    
     * b. Deletion
     *    i. Delete the node as in the binary search tree.
     *  ii. If the node is red, then the tree is balanced.
     * iii. If the node is black, then fix the tree.
     * iv. If the sibling of the node is red, then perform the rotations.
     * v. If the sibling of the node is black, then recolor the sibling, parent, and grandparent.
    
     * c. Searching
     *   i. Search the node as in the binary search tree.

     */

}
