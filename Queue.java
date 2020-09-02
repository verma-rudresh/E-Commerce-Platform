

// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{


    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;

    public Queue(int capacity) {
        queue = new NodeBase[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return (size() == 0 );
    }

    public boolean isFull() {
        return (size() == capacity);
    }

    public void enqueue(Node<V> node) {
        if(!isFull())
        {
            rear = (rear+1)% capacity;
            queue[rear] = (NodeBase<V>)node;
            currentSize++;
        }

    }

    public NodeBase<V> dequeue() {
        if(isEmpty())
        {
            return null;
        }
        NodeBase node = queue[front];
        front = (front+1)% capacity;
        currentSize--;
        return node;
    }
    public void display(){
        if (!this.isEmpty()) {
            int b = this.currentSize;
            for(int i = 0;i<b;i++){
                this.dequeue().show();
            }
        }

    }
}

