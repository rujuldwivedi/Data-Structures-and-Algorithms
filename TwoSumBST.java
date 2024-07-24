import java.util.*;

public class TwoSumBST
{

    /*
     * Here we'll do the following:
     * 1. Find the two elements in the BST that sum to the target
     */

     // Function to find the two elements in the BST that sum to the target
    public static ArrayList<Integer> findTarget(Node root, int target)
    {

        /*
         * This approach is similar to the recursive approach but here we'll use two stacks to keep track of the left and right subtrees
         */
        
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> leftStack = new Stack<>();
        Stack<Node> rightStack = new Stack<>(); 
        Node left = root;
        Node right = root;

        while (left != null)
        {
            leftStack.push(left);
            left = left.left;
        }

        while (right != null)
        {
            rightStack.push(right);
            right = right.right;
        }

        while (leftStack.peek() != rightStack.peek())
        {
            int sum = leftStack.peek().data + rightStack.peek().data;

            if (sum == target)
            {
                result.add(leftStack.peek().data);
                result.add(rightStack.peek().data);
                return result;
            }
            else if (sum < target)
            {
                left = leftStack.pop().right;
                while (left != null)
                {
                    leftStack.push(left);
                    left = left.left;
                }
            }
            else
            {
                right = rightStack.pop().left;
                while (right != null)
                {
                    rightStack.push(right);
                    right = right.right;
                }
            }
        }

        return result;
    }
    
    public static void main(String[] args)
    {
        Node root = new Node(5);

        BSTInsertion.insert(root, 3);
        BSTInsertion.insert(root, 6);
        BSTInsertion.insert(root, 2);
        BSTInsertion.insert(root, 4);
        BSTInsertion.insert(root, 7);

        int target = 9;

        ArrayList<Integer> result = findTarget(root, target);

        if (result.size() == 0)
        {
            System.out.println("No such elements found");
        }
        else
        {
            System.out.println("The two elements are: " + result.get(0) + " and " + result.get(1));
        }
    }
}
