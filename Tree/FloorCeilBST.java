public class FloorCeilBST
{

    /*
     * Here we'll do the following:
     * 1. Find the floor of a number in a BST
     * 2. Find the ceil of a number in a BST
     */

     // Find the floor of a number in a BST 
        public static int floor(Node root, int key)
        {
            Node res = null;
            while(root != null)
            {
                if(root.data == key)
                    return root.data;
                else if(root.data > key)
                    root = root.left;
                else
                {
                    res = root;
                    root = root.right;
                }
            }

            // Also handling the case when the number is less than the minimum number in the BST
            if(res == null)
                return Integer.MIN_VALUE;

            return res.data;
        }

        // Find the ceil of a number in a BST
        public static int ceil(Node root, int key)
        {
            Node res = null;
            while(root != null)
            {
                if(root.data == key)
                    return root.data;
                else if(root.data < key)
                    root = root.right;
                else
                {
                    res = root;
                    root = root.left;
                }
            }

            // Also handling the case when the number is greater than the maximum number in the BST
            if(res == null)
                return Integer.MAX_VALUE;

            return res.data;
        }

    public static void main(String[] args)
    {
        Node root = new Node(8);
        BSTInsertion.insert(root, 3);
        BSTInsertion.insert(root, 10);
        BSTInsertion.insert(root, 1);
        BSTInsertion.insert(root, 6);
        BSTInsertion.insert(root, 14);
        BSTInsertion.insert(root, 4);
        BSTInsertion.insert(root, 7);
        BSTInsertion.insert(root, 13);

        System.out.println(floor(root, 0));
        System.out.println(ceil(root, 5));
    }
}
