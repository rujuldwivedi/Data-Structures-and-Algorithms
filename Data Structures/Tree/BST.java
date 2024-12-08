import java.util.*;
class BST extends Node
{
    BST()
    {
        super(0);
    }
    public static Scanner sc = new Scanner(System.in);
    public static Node root;
    public static int height(Node node)
    {
        if(node == null)
        return -1;
        return node.height;
    }
    public static void insert(int value)
    {
        root = insert(root,value);
    }
    public static Node insert(Node node, int value)
    {
        if(node==null)
        {
            node = new Node(value);
            return node;
        }
        if(value <= node.value)
        node.left = insert(node.left,value);
        if(value >= node.value)
        node.right = insert(node.right,value);
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        return node;
    }
    public static void populate(int[] nums)
    {
        for(int i=0;i<nums.length;i++)
        insert(nums[i]);
    }
    public static void display()
    {
        display(root,"Root node: ");
    }
    public static void display(Node node, String details)
    {
        if(node==null)
        return;
        System.out.println(details + node.value);
        display(node.left,"Left child of "+node.value+":");
        display(node.right,"Right child of "+node.value+":");
    }
    public static boolean balanced()
    {
       return balanced(root);
    }
    public static boolean balanced(Node node)
    {
        if (node == null)
        return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    public static void preOrder(Node node)
    {
        if(node == null)
        return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node)
    {
        if(node == null)
        return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    public static void postOrder(Node node)
    {
        if(node == null)
        return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    public static void main(String[] args)
    {
        int[] nums = {1,6,4,9,2,0,13,15,11};
        populate(nums);
        System.out.print("Pre-Order: ");
        preOrder(root);
        System.out.println();
        System.out.print("In-Order: ");
        inOrder(root);
        System.out.println();
        System.out.print("Post-Order: ");
        postOrder(root);
        System.out.println();
        // display();
        // System.out.println(balanced());
    }
}