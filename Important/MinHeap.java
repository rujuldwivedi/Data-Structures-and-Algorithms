package Important;

class MinHeap {
    int[] heap;
    int size;

    MinHeap(int capacity) {
        heap = new int[capacity + 1];
        size = 0;
    }

    void insert(int val) {
        heap[++size] = val;
        int i = size;
        while (i > 1 && heap[i] < heap[i / 2]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    int extractMin() {
        int min = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return min;
    }

    void heapify(int i) {
        int left = 2 * i, right = 2 * i + 1, smallest = i;
        if (left <= size && heap[left] < heap[smallest]) smallest = left;
        if (right <= size && heap[right] < heap[smallest]) smallest = right;
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
