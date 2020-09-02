# E-Commerce-Platform
In this assignment, I have implemented Queue<V> and PriorityQueue<V>  classes which implements QueueInterface<V>. The QueueInterface<V> has some functions inbuilt in it like size(), isEmpty(), isFull(), enqueue() and dequeue(). The enqueue() takes a node as argument and add that element to the end of the queue or PriorityQueue.
  
The implementation of the dequeue() method is different for Queue and PriorityQueue. 
1. In the class Queue<V> which implements QueueInterface<V> ,  
  1.1. I have created an array of nodes named queue on which the whole working of the class Queue depends. I have created four integers namely front, rear, capacity and currentSize. 
  1.2. I have created a constructor of Queue in which the specified argument is the capacity of Queue.  In this, I have assigned the capacity to the size of the array. Rear to -1,front to 0 and currentSize to 0. 
  1.3. I have written and tested a function called size(), which returns the size of the Queue which is the value of currentSize at that stage. 
  1.4. I  have written and tested a function called isEmpty(), which returns true if the size is zero and false if not. 
  1.5. I have written and tested a function called isFull(), which returns true if the Queue is full and false otherwise. 
  1.6. I have written and tested a function called enqueue(node), which takes the node as the argument and add this node in the last position of the queue. This is done by implementing the cyclic array. I have iterated the rear by 1 and added the element to the index of the rear, so, when the rear iterates to last then after next iteration, it will reach to the zeroth index of the array. So the next element will be assigned to the first index of the array. I have increased the currentSize by 1. This method will not do anything if the Queue is already full. 
  1.7. I have written and tested a function called dequeue(), which removes the last element from the Queue. This is also cyclic in the array, as the front denotes the index of the first element of the queue which may or may not be the first element of the array. I have stored the array[front] in another node and then iterated the front by 1 and returned the node. Now the new front index determines the first element of the Queue. I have finally decreased the currentSize by 1. This method will return null if the queue is empty. 
  1.8. I have written and tested a function called display(), which prints all the elements of the Queue in the dequeuing order. 
