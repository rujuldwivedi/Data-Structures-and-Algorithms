import java.util.*;
class BFS extends Node
{
  BFS(int value)
  {
    super(value);
  }
  public List<List<Integer>> levelOrder(Node root)
  {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null)
    return result;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty())
    {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for (int i=0; i < levelSize; i++) {
        Node currentNode = queue.poll();
        currentLevel.add(currentNode.value);
        if (currentNode.left != null)
        queue.offer(currentNode.left);
        if (currentNode.right != null)
        queue.offer(currentNode.right);
      }
      result.add(currentLevel);
    }
    return result;
  }
  public List<Integer> rightSideView(Node root)
  {
    List<Integer> result = new ArrayList<>();
    if (root == null)
    return result;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty())
    {
      int levelSize = queue.size();
      for (int i=0; i < levelSize; i++)
      {
        Node currentNode = queue.poll();
        if (i == levelSize - 1)
        result.add(currentNode.value);
        if (currentNode.left != null)
        queue.offer(currentNode.left);
        if (currentNode.right != null)
        queue.offer(currentNode.right);
      }
    }
    return result;
  }
  public List<Double> averageOfLevels(Node root)
  {
    List<Double> result = new ArrayList<>();
    if (root == null)
    return result;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty())
    {
      int levelSize = queue.size();
      double averageLevel = 0;
      for (int i=0; i < levelSize; i++)
      {
        Node currentNode = queue.poll();
        averageLevel += currentNode.value;
        if (currentNode.left != null)
        queue.offer(currentNode.left);
        if (currentNode.right != null)
        queue.offer(currentNode.right);
      }
        averageLevel = averageLevel / levelSize;
        result.add(averageLevel);
    }
    return result;
  }
  public Node findSuccessor(Node root, int key)
  {
    if (root == null)
    return null;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty())
    {
        Node currentNode = queue.poll();
        if (currentNode.left != null)
        queue.offer(currentNode.left);
        if (currentNode.right != null)
        queue.offer(currentNode.right);
        if (currentNode.value == key)
        break;
    }
    return queue.peek(); 
  }
  public List<List<Integer>> zigzagLevelOrder(Node root)
  {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null)
    return result;
    Deque<Node> queue = new LinkedList<>();
    queue.add(root);
    boolean reverse = false;
    while (!queue.isEmpty())
    {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for (int i=0; i < levelSize; i++)
      {
        if (!reverse)
        {
          Node currentNode = queue.pollFirst();
          currentLevel.add(currentNode.value);
          if (currentNode.left != null)
          queue.addLast(currentNode.left);
          if (currentNode.right != null)
          queue.addLast(currentNode.right);
        }
        else
        {
          Node currentNode = queue.pollLast();
          currentLevel.add(currentNode.value);
          if (currentNode.right != null)
          queue.addFirst(currentNode.right);
          if (currentNode.left != null)
          queue.addFirst(currentNode.left);
        }
      }
      reverse = !reverse;
      result.add(currentLevel);
    }
    return result;
  }
  public Node connect(Node root)
  {
    if (root == null)
    return null;
    Node leftMost = root;
    while (leftMost.left != null)
    {
      Node current = leftMost;
      while(current != null)
      {
        current.left.next = current.right;
        if(current.next != null)
        current.right.next = current.next.left;
        current = current.next;
      }
      leftMost = leftMost.left;
    }
    return root;
  }
  public boolean isCousins(Node root, int x, int y)
  {
    Node xx = findNode(root, x);
    Node yy = findNode(root, y);
    return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
  }
  Node findNode(Node node, int x)
  {
    if (node == null)
    return null;
    if (node.value == x)
    return node;
    Node temp = findNode(node.left, x);
    if (temp != null)
    return temp;
    return findNode(node.right, x);
  }
  boolean isSibling (Node node, Node x, Node y)
  {
    if (node == null)
    return false;
    return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y));
  }
  int level (Node node, Node x, int lev)
  {
    if(node == null)
    return 0;
    if(node == x)
    return lev;
    int l = level(node.left, x, lev+1);
    if (l != 0)//if l==0 that means node is not present in left subtree,else if it is present then l==level of node
    return l;
    return level(node.right, x, lev+1);//if node is not present in left subtree then it must be present in right subtree
  }
  public boolean isSymmetric(Node root)
  {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root.left);
    queue.add(root.right);
    while(!queue.isEmpty())
    {
      Node left = queue.poll();
      Node right = queue.poll();
      if(left == null && right == null)
      continue;
      if(left == null || right == null)
      return false;
      if (left.value != right.value)
      return false;
      queue.add(left.left);
      queue.add(right.right);
      queue.add(left.right);
      queue.add(right.left);
    }
    return true;
  }
  public static void main(String[] args)
  {
    BFS bfs = new BFS(1);
    bfs.left = new Node(2);
    bfs.right = new Node(3);
    bfs.left.left = new Node(4);
    bfs.left.right = new Node(5);
    bfs.right.left = new Node(6);
    bfs.right.right = new Node(7);
    bfs.left.left.left = new Node(8);
    bfs.left.left.right = new Node(9);
    bfs.left.right.left = new Node(10);
    bfs.left.right.right = new Node(11);
    bfs.right.left.left = new Node(12);
    bfs.right.left.right = new Node(13);
    bfs.right.right.left = new Node(14);
    bfs.right.right.right = new Node(15);
    System.out.println(bfs.levelOrder(bfs));
    System.out.println(bfs.rightSideView(bfs));
    System.out.println(bfs.averageOfLevels(bfs));
    System.out.println(bfs.findSuccessor(bfs, 3));
    System.out.println(bfs.zigzagLevelOrder(bfs));
    System.out.println(bfs.connect(bfs));
    System.out.println(bfs.isCousins(bfs, 4, 5));
    System.out.println(bfs.isSymmetric(bfs));
  }
}