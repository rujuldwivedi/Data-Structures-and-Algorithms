public class QueueImplementation extends Node
{

    /*
     * Here we'll do the following:
     * 1. Implement a Queue using Arrays
     * 2. Implement a Queue using Linked List
     */

    // Implementing a Queue using Arrays
    int front, rear, size;
    int capacity;
    int array[];

    public QueueImplementation(int capacity)
    {
        super(0);
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    // Queue is full when size becomes equal to the capacity
    boolean isFull(QueueImplementation queue)
    {
        return (queue.size == queue.capacity);
    }

    // Queue is empty when size is 0
    boolean isEmpty(QueueImplementation queue)
    {
        return (queue.size == 0);
    }

    // Method to add an item to the queue
    void enqueue(int item)
    {
        if(isFull(this))
        {
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }

    // Method to remove an item from the queue
    int dequeue()
    {
        if(isEmpty(this))
        {
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    // Method to get front of the queue
    int front()
    {
        if(isEmpty(this))
        {
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }

    // Method to get rear of the queue
    int rear()
    {
        if(isEmpty(this))
        {
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }

    // Implementing a Queue using Linked List
    /*
    static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    */

    Node frontNode, rearNode;
    int sizeNode;

    public QueueImplementation()
    {
        super(0);
        this.frontNode = this.rearNode = null;
        this.sizeNode = 0;
    }

    // Method to add an item to the queue
    void enqueueNode(int data)
    {
        Node temp = new Node(data);

        // If queue is empty, then new node is front and rear both
        if(this.rearNode == null)
        {
            this.frontNode = this.rearNode = temp;
            return;
        }

        // Add the new node at the end of the queue and change rear
        this.rearNode.next = temp;
        this.rearNode = temp;
        this.sizeNode++;
    }

    // Method to remove an item from the queue
    Node dequeueNode()
    {
        // If queue is empty, return NULL
        if(this.frontNode == null)
        {
            return null;
        }

        // Store previous front and move front one node ahead
        Node temp = this.frontNode;
        this.frontNode = this.frontNode.next;

        // If front becomes NULL, then change rear also as NULL
        if(this.frontNode == null)
        {
            this.rearNode = null;
        }
        this.sizeNode--;
        return temp;
    }

    // Method to get front of the queue
    Node frontNode()
    {
        if(this.frontNode == null)
        {
            return null;
        }
        return this.frontNode;
    }

    // Method to get rear of the queue
    Node rearNode()
    {
        if(this.rearNode == null)
        {
            return null;
        }
        return this.rearNode;
    }

    public static void main(String[] args)
    {
        QueueImplementation queue = new QueueImplementation(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() + " dequeued from queue");
        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());

        QueueImplementation queueNode = new QueueImplementation();

        queueNode.enqueueNode(10);
        queueNode.enqueueNode(20);
        queueNode.enqueueNode(30);
        queueNode.enqueueNode(40);

        System.out.println(queueNode.dequeueNode().data + " dequeued from queue");
        System.out.println("Front item is " + queueNode.frontNode().data);
        System.out.println("Rear item is " + queueNode.rearNode().data);
    }
}
