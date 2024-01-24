class AVL extends Node
{
    AVL()
    {
        super(0);
    }
  public int height()
  {
    return height(root);
  }
  public int height(Node node)
  {
    if (node == null)
    return -1;
    return node.height;
  }
  private Node insert(int value, Node node)
  {
    if (node == null)
    return new Node(value);
    if (value < node.value)
    node.left = insert(value, node.left);
    if (value > node.value)
    node.right = insert(value, node.right);
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    return rotate(node);
  }
  public void insert(int value)
  {
    root = insert(value, root);
  }
  public Node rightRotate(Node parent)
  {
    Node child = parent.left;
    Node temp = child.right;
    child.right = parent;
    parent.left = temp;
    parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
    child.height = Math.max(height(child.left), height(child.right)) + 1;
    return child;
  }
  public Node leftRotate(Node child)
  {
    Node parent = child.right;
    Node temp = parent.left;
    parent.left = child;
    child.right = temp;
    parent.height = Math.max(height(parent.left), height(parent.right) + 1);
    child.height = Math.max(height(child.left), height(child.right) + 1);
    return parent;
  }
  private Node rotate(Node node)
  {
    if (height(node.left) - height(node.right) > 1)
    { // left heavy
      if(height(node.left.left) - height(node.left.right) > 0)
      return rightRotate(node);// left left case
      if(height(node.left.left) - height(node.left.right) < 0)
      { // left right case
        node.left = leftRotate(node.left);
        return rightRotate(node);
      }
    }
    if (height(node.left) - height(node.right) < -1)
    { // right heavy
      if(height(node.right.left) - height(node.right.right) < 0)
      return leftRotate(node);// right right case
      if(height(node.right.left) - height(node.right.right) > 0)
      { // right left case
        node.right = rightRotate(node.right);
        return leftRotate(node);
      }
    }
    return node;
  }
  public void populate(int[] nums)
  {
    for (int i = 0; i < nums.length; i++)
    this.insert(nums[i]);
  }
  public void display(Node node, String details)
  {
    if (node == null)
    return;
    System.out.println(details + node.value);
    display(node.left, "Left child of " + node.value + " : ");
    display(node.right, "Right child of " + node.value + " : ");
  }
  public void display()
  {
    display(this.root, "Root Node: ");
  }
  public boolean isEmpty()
  {
    return root == null;
  }
  private boolean balanced(Node node)
  {
    if (node == null)
    return true;
    return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
  }
  public boolean balanced()
  {
    return balanced(root);
  }
  public static void main(String args[])
  {
    AVL tree = new AVL();
    int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
    tree.populate(nums);
    tree.display();
    System.out.println("Height of tree: " + tree.height());
    System.out.println("Balanced: " + tree.balanced());
  }
}