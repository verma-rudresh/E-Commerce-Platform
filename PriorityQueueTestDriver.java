// Use this driver for the testing the correctness of your priority queue implementation
// You can change the add, remove sequence to test for various scenarios.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
public class PriorityQueueTestDriver {
    public static void main(String[] args) throws IOException
	{

		PriorityQueue<String> pq = new PriorityQueue<String>(5);
		//Queue<String> queue = new Queue<>(5);
		pq.enqueue(new Node(4, "A"));
		//queue.enqueue(new Node(4, "A"));
		pq.enqueue(new Node(10, "B"));
		//queue.enqueue(new Node(10, "B"));
		pq.enqueue(new Node(3, "C"));
		//queue.enqueue(new Node(3, "C"));
		pq.enqueue(new Node(5, "E"));
		//queue.enqueue(new Node(5, "E"));
		pq.enqueue(new Node(2, "F"));
		//queue.enqueue(new Node(2, "F"));
	//pq.enqueue(new Node(2,"J"));
	pq.display();
	//pq.dequeue();
	//queue.display();
    }
}
