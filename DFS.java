import java.util.*;
class DFS extends Node
{
    DFS(int value)
    {
      super(value);
    }
  void dfsStack(Node node)
  {
    if(node == null)
    return;
    Stack<Node> stack = new Stack<>();
    stack.push(node);
    while(!stack.isEmpty())
    {
      Node removed = stack.pop();
      System.out.print(removed.value + " ");
      if(removed.right != null)
      stack.push(removed.right);
      if(removed.left != null)
      stack.push(removed.left);
    }
  }
  int diameter = 0;
  public int diameterOfBinaryTree(Node root)
  {
    height(root);
    return diameter-1;
  }
  int height(Node node)
  {
    if(node == null)
    return 0;
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    int dia = leftHeight + rightHeight + 1;
    diameter = Math.max(diameter, dia);
    return Math.max(leftHeight, rightHeight) + 1;
  }
  public Node invertTree(Node root)
  {
    if (root == null)
    return null;
    Node left = invertTree(root.left);
    Node right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
  public void flatten(Node root)
  {
    Node current = root;
    while (current != null)
    {
      if (current.left != null)
      {
        Node temp = current.left;
        while(temp.right != null)
        temp = temp.right;
        temp.right = current.right;
        current.right = current.left;
        current.left= null;
      }
      current = current.right;
    }
  }
  public boolean helper(Node node, Integer low, Integer high)
  {
    if (node == null)
    return true;
    if (low != null && node.value <= low)
    return false;
    if(high != null && node.value >= high)
    return false;
    boolean leftTree = helper(node.left, low, node.value);
    boolean rightTree = helper(node.right, node.value, high);
    return leftTree && rightTree;
  }
  public boolean isvalueidBST(Node root)
  {
        return helper(root, null, null);
  }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
      if (root == null)
      return null;
      if (root == p || root == q)
      return root;
      Node left = lowestCommonAncestor(root.left, p, q);
      Node right = lowestCommonAncestor(root.right, p, q);
      if (left != null && right != null)
      return root;
      return left == null ? right : left;
    }
    int count = 0;
    public Node helper(Node root, int k)
    {
      if (root == null)
      return null;
      Node left = helper(root.left, k);
      if (left != null)
      return left;
      count++;
      if(count == k)
      return root;
      return helper(root.right, k);
    }
    public int kthSmallest(Node root, int k)
    {
        return helper(root, k).value;
    }
    public Node buildTree(int[] preorder, int[] inorder)
    {
      if (preorder.length == 0)
      return null;
      int r = preorder[0];
      int index = 0;
      for(int i=0; i<inorder.length; i++)
      {
        if(inorder[i] == r)
        index = i;
      }
      Node node = new Node(r);
      node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
      node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
      return node;
    }
    public static List<List<Integer>> findPaths(Node node, int sum) {
      List<List<Integer>> paths = new ArrayList<>();
      List<Integer> path = new ArrayList<>();
      helper(node, sum, path,paths);
      return paths;
    }
    public static void helper(Node node, int sum, List<Integer> path, List<List<Integer>> paths)
    {
      if(node == null)
      return ;
      path.add(node.value);
      if (node.value == sum && node.left == null && node.right == null)
      paths.add(new ArrayList<>(path));
      else
      {
        helper(node.left, sum-node.value, path, paths);
        helper(node.right, sum-node.value, path, paths);
      }
      // backtrack
      path.remove(path.size() - 1);    
    } 
    public static void main(String[] args)
    {
      DFS tree = new DFS(1);
      tree.left = new DFS(2);
      tree.right = new DFS(3);
      tree.left.left = new DFS(4);
      tree.left.right = new DFS(5);
      tree.right.left = new DFS(6);
      tree.right.right = new DFS(7);
      tree.dfsStack(tree);
      System.out.println();
      System.out.println(tree.diameterOfBinaryTree(tree));
      System.out.println(tree.isvalueidBST(tree));
      System.out.println(tree.kthSmallest(tree, 3));
      System.out.println(tree.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
      System.out.println(tree.lowestCommonAncestor(tree, tree.left.left, tree.left.right).value);
      System.out.println(findPaths(tree, 0) + " " + findPaths(tree, 8));
    }
}