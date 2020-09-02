
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;


    public PriorityQueue(int capacity) {
        queue = new NodeBase[capacity];
        this.capacity = capacity;
        this.currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public boolean isFull() {
        return (currentSize == capacity);
    }

    public void enqueue(Node<V> node) {
        if(!isFull()) {
            queue[currentSize] = (NodeBase<V>) node;
            currentSize++;
        }
    }
    // In case of priority queue, the dequeue() should
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
        if (!isEmpty()) {
            int k = 0;
            int prior = queue[0].getPriority();
            int b = this.currentSize;
            for (int i = 1; i < b; i++) {
                if (queue[i].getPriority() < prior) {
                    prior = queue[i].getPriority();
                    k = i;
                }
            }
            NodeBase<V> node = queue[k];
            for (int m = k; m < b - 1; m++)
                queue[m] = queue[m + 1];
            currentSize--;
            return node;
        }
        return null;
    }

    public void display () {
        if (!this.isEmpty()) {
            int b = currentSize;
            for (int i = 0; i < b; i++) {
                this.dequeue().show();
            }
        }

    }
}

