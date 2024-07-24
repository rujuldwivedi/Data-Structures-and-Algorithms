public class Heap
{

    /*
     * Heap is a complete binary tree.
     * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
     * Heaps are of two types: Min Heap and Max Heap.
     * In a Min Heap, the key at the root must be minimum among all keys present in the heap.
     * In a Max Heap, the key at the root must be maximum among all keys present in the heap.
     * The same property must be recursively true for all nodes in both the heaps.
     */

    private int[] heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public Heap(int maxSize)
    {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos)
    {
        return pos / 2;
    }

    private int leftChild(int pos)
    {
        return 2 * pos;
    }

    private int rightChild(int pos)
    {
        return 2 * pos + 1;
    }

    private boolean isLeaf(int pos)
    {
        return pos >= (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos)
    {
        if (!isLeaf(pos))
        {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)])
            {
                if (heap[leftChild(pos)] < heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else
                {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element)
    {
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)])
        {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++)
        {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            minHeapify(pos);
        }
    }

    public int remove()
    {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    private void maxHeapify(int pos)
    {
        if (!isLeaf(pos))
        {
            if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)])
            {
                if (heap[leftChild(pos)] > heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else
                {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void maxHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            maxHeapify(pos);
        }
    }

    public int removeMax()
    {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        maxHeapify(FRONT);
        return popped;
    }

    public static void main(String[] args)
    {
        System.out.println("The Min Heap is ");
        Heap minHeap = new Heap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());

        System.out.println("The Max Heap is ");
        Heap maxHeap = new Heap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();

        maxHeap.print();
        System.out.println("The Max val is " + maxHeap.removeMax());
    }
}
