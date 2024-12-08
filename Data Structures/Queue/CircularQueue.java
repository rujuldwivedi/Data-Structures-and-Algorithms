public class CircularQueue
{

    /*
     * Here we'll do the following:
     * 1. Implement a Circular Queue
     */

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int size)
    {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enQueue(int data)
    {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1)))
        {
            System.out.println("Queue is full");
        }
        else if (front == -1)
        {
            front = 0;
            rear = 0;
            queue[rear] = data;
        }
        else if (rear == size - 1 && front != 0)
        {
            rear = 0;
            queue[rear] = data;
        }
        else
        {
            rear++;
            queue[rear] = data;
        }
    }

    public int deQueue()
    {
        int temp;
        if (front == -1)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        temp = queue[front];
        if (front == rear)
        {
            front = -1;
            rear = -1;
        }
        else if (front == size - 1)
        {
            front = 0;
        }
        else
        {
            front++;
        }
        return temp;
    }

    public void displayQueue()
    {
        if (front == -1)
        {
            System.out.println("Queue is empty");
            return;
        }
        if (rear >= front)
        {
            for (int i = front; i <= rear; i++)
            {
                System.out.print(queue[i] + " ");
            }
        }
        else
        {
            for (int i = front; i < size; i++)
            {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= rear; i++)
            {
                System.out.print(queue[i] + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        CircularQueue q = new CircularQueue(5);

        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(13);
        q.enQueue(-6);

        q.displayQueue();

        int x = q.deQueue();

        if (x != -1)
        {
            System.out.println("Deleted value = " + x);
        }

        x = q.deQueue();

        if (x != -1)
        {
            System.out.println("Deleted value = " + x);
        }

        q.displayQueue();

        q.enQueue(9);
        q.enQueue(20);
        q.enQueue(5);

        q.displayQueue();

        q.enQueue(20);
    }
}
