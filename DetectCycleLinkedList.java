public class DetectCycleLinkedList extends Node
{

    // Create a default constructor
    DetectCycleLinkedList()
    {
        super(0);
    }

    // Create a constructor to initialize the node
    DetectCycleLinkedList(int data)
    {
        super(data);
    }

    /*
     * Here we'll do the following:
     * 1. Detect if there is a cycle in the linked list
     */

     /*
      * Floyd's Cycle Detection Algorithm
        * 1. Initialize two pointers, slow and fast, to the head of the linked list
        * 2. Move slow by one step and fast by two steps
        * 3. If there is a cycle, slow and fast will meet at some point
        * 4. If there is no cycle, fast will reach the end of the linked list
      */

      // Function to detect cycle in a linked list
        public boolean detectCycle(Node head)
        {
            // Initialize slow and fast pointers
            Node slow = head;
            Node fast = head;
    
            // Traverse the linked list
            while(fast != null && fast.next != null)
            {
                // Move slow by one step
                slow = slow.next;
    
                // Move fast by two steps
                fast = fast.next.next;
    
                // If slow and fast meet, there is a cycle
                if(slow == fast)
                {
                    return true;
                }
            }
    
            // If fast reaches the end of the linked list, there is no cycle
            return false;
        }

        public static void main(String[] args)
        {
            // Create a new linked list
            DetectCycleLinkedList head = new DetectCycleLinkedList(1);
            head.next = new DetectCycleLinkedList(2);
            head.next.next = new DetectCycleLinkedList(3);
            head.next.next.next = new DetectCycleLinkedList(4);
            head.next.next.next.next = new DetectCycleLinkedList(5);
    
            // Create a cycle in the linked list
            head.next.next.next.next.next = head.next;
    
            // Create an object of the DetectCycleLinkedList class
            DetectCycleLinkedList obj = new DetectCycleLinkedList();
    
            // Check if there is a cycle in the linked list
            boolean res = obj.detectCycle(head);
    
            // Print the result
            if(res)
            {
                System.out.println("There is a cycle in the linked list");
            }
            else
            {
                System.out.println("There is no cycle in the linked list");
            }
        }
}
