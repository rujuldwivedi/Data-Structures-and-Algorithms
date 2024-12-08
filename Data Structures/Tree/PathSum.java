import java.util.*;
class PathSum
{
    public boolean hasPathSum(Node root, int sum)
    {
      if (root == null)
      return false;
      if (root.value == sum && root.left == null && root.right == null)
      return true;
      return hasPathSum(root.left, sum-root.value) || hasPathSum(root.right, sum-root.value);
    }
    public int sumNumbers(Node root)
    {
      return helper(root, 0);
    }
    int helper(Node node, int sum)
    {
      if(node == null)
      return 0;
      sum = sum * 10 + node.value;
      if (node.left == null && node.right == null)
      return sum;
      return helper(node.left, sum) + helper(node.right, sum);
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(Node root)
    {
        helper(root);
        return ans;
    }
    int helper(Node node)
    {
      if(node == null)
      return 0;
      int left = helper(node.left);
      int right = helper(node.right);
      left = Math.max(0, left);
      right = Math.max(0, right);
      int pathSum = left + right + node.value;
      ans = Math.max(ans, pathSum);
      return Math.max(left, right) + node.value;
    }
    boolean findPath(Node node, int[] arr)
    {
      if (node == null)
      return arr.length == 0;
      return helper(node, arr, 0);
    }
    boolean helper(Node node, int[] arr, int index)
    {
      if(node == null)
      return false;
      if(index >= arr.length || node.value != arr[index])
      return false;
      if(node.left == null && node.right == null && index == arr.length - 1)
      return true;
      return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }
    int countPaths(Node node, int sum)
    {
      List<Integer> path = new ArrayList<>();
      return helper(node, sum, path);
    }
    int helper(Node node, int sum, List<Integer> path)
    {
      if(node == null)
      return 0;
      path.add(node.value);
      int count = 0;
      int s = 0;
      ListIterator<Integer> itr = path.listIterator(path.size());
      while (itr.hasPrevious())
      {
        s += itr.previous();
        if (s == sum)
        count++;
      }
      count += helper(node.left, s, path) + helper(node.right, sum, path);
      path.remove(path.size() - 1);
      return count;
    }
    List<List<Integer>> findPaths(Node node, int sum)
    {
      List<List<Integer>> paths = new ArrayList<>();
      List<Integer> path = new ArrayList<>();
      helper(node, sum, path);
      return paths;
    }
    void helper(Node node, int sum, List<Integer> path, List<List<Integer>> paths)
    {
      if(node == null)
      return;
      path.add(node.value);
      if (node.value == sum && node.left == null && node.right == null)
      paths.add(new ArrayList<>(path));
      else
      {
        helper(node.left, sum-node.value, path, paths);
        helper(node.right, sum-node.value, path, paths);
      }
      path.remove(path.size() - 1);    
    }  
    public static void main(String[] args)
    {
      Node root = new Node(5);
      root.left = new Node(4);
      root.right = new Node(8);
      root.left.left = new Node(11);
      root.left.left.left = new Node(7);
      root.left.left.right = new Node(2);
      root.right.left = new Node(13);
      root.right.right = new Node(4);
      root.right.right.left = new Node(5);
      root.right.right.right = new Node(1);
      PathSum obj = new PathSum();
      System.out.println(obj.hasPathSum(root, 22));
      System.out.println(obj.sumNumbers(root));
      System.out.println(obj.maxPathSum(root));
      int[] arr = {5, 8, 4, 11, 7};
      System.out.println(obj.findPath(root, arr));
      System.out.println(obj.countPaths(root, 22));
      System.out.println(obj.findPaths(root, 22));
    }
  }