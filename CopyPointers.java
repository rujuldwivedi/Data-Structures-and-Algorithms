import java.util.*;
class CopyPointers
{
    class Node
    {
        int val;
        Node next;
        Node random;
        public Node(int val)
        {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head)
    {
        HashMap <Node,Node> ans = new HashMap<>();
        if(head==null)
        return null;
        Node curr = head;
        Node prev = null;
        while(curr!=null)
        {
            Node temp = new Node(curr.val);
            if(prev!=null)
            prev.next = temp;
            prev = temp;
            ans.put(curr,temp);
            curr = curr.next;
        }
        curr = head;
        while(curr!=null)
        {
            ans.get(curr).random = ans.getOrDefault(curr.random,null);
            curr = curr.next;
        }
        return ans.get(head);
    }
    public static void main(String args[])
    {
        CopyPointers cp = new CopyPointers();
        Node head = cp.new Node(7);
        Node temp = cp.new Node(13);
        head.next = temp;
        temp.random = head;
        temp = cp.new Node(11);
        head.next.next = temp;
        temp.next = cp.new Node(10);
        temp.random = temp.next;
        temp = temp.next;
        temp.next = cp.new Node(1);
        temp.random = head;
        temp = temp.next;
        temp.next = null;
        Node ans = cp.copyRandomList(head);
        while(ans!=null)
        {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}