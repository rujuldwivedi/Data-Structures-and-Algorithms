import java.util.*;
class Node
{
    static Scanner sc = new Scanner(System.in);
    int value;
    Node left;
    Node right;
    int start;
    int end;
    Node next;
    int height;
    Node(int value)
    {
        this.value=value;
    }
    public Node (int start, int end)
    {
      this.start = start;
      this.end = end;
    }
    public Node root;
    // public Node createTree()
    // {
    //     System.out.println("Enter value: ");
    //     int value = sc.nextInt();
    //     if(value==-1)
    //     return null;
    //     root = new Node(value);
    //     System.out.println("Enter left of "+value);
    //     root.left = createTree();
    //     System.out.println("Enter right of "+value);
    //     root.right = createTree();
    //     return root;
    // }
    public static void main(String[] args)
    {
        // Node root = new Node(1);
        // root.createTree();
        // sc.close();
    }
}