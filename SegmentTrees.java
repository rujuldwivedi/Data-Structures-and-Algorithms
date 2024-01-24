public class SegmentTrees extends Node
{
    SegmentTrees()
    {
        super(0);
    }
    public SegmentTrees(int[] arr)
    {
        super(0,0);
        this.root = constructTree(arr, 0, arr.length - 1);
      }
      private Node constructTree(int[] arr, int start, int end)
      {
        if(start == end)
        {
          Node leaf = new Node(start, end);
          leaf.value = arr[start];
          return leaf;
        }
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);
        node.value = node.left.value + node.right.value;
        return node;
      }
      private void display(Node node)
      {
        String str = "";
        if(node.left != null)
        str += "Interval=[" + node.left.start + "-" + node.left.end + "] and value: " + node.left.value + " => "; 
        else
        str += "No left child. ";
        str += "Interval=[" + node.start + "-" + node.end + "] and value: " + node.value + " <= "; 
        if(node.right != null)
        str += "Interval=[" + node.right.start + "-" + node.right.end + "] and value: " + node.right.value; 
        else
        str += "No right child";
        System.out.println(str + '\n');
        if(node.left != null)
        display(node.left);
        if(node.right != null)
        display(node.right);
      }
      public void display()
      {
        display(this.root);
      }
      public int query(Node node, int s, int e)
      {
        if(node.start >= s && node.end <= e)
        return node.value;
        else if (node.start > e || node.end < s)
        return 0;
        else
        return this.query(node.left, s, e) + this.query(node.right, s, e);
      }
      public int query(int s, int e)
      {
        return this.query(this.root, s, e);
      }
      public int update(Node node, int index, int value)
      {
        if (index >= node.start&& index <= node.end)
        {
          if(index == node.start && index == node.end)
          {
            node.value = value;
            return node.value;
          }
          else
          {
            int leftAns = update(node.left, index, value);
            int rightAns = update(node.right, index, value);
            node.value = leftAns + rightAns;
            return node.value;
          }
        }
        return node.value;
      }
      public void update(int index, int value)
      {
        this.root.value = update(this.root, index, value);
      }
        public static void main(String[] args)
        {
            int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
            SegmentTrees st = new SegmentTrees(arr);
            st.update(3, 14);
            System.out.println(st.query(2, 6));
            st.display();
        }
}
