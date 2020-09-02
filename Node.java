

public class Node<V> extends NodeBase<V> {
	private  int priority;
	private V value;
	public Node(int priority, V value) {
		this.priority = priority;
		this.value = value;
	}

	// Complete these methods
	public int getPriority() {
		return priority;
	}

	public V getValue() {
		return value;
	}

}
