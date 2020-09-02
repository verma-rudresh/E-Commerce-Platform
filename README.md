# E-Commerce-Platform
In this assignment, I have implemented Queue<V> and PriorityQueue<V>  classes which implements QueueInterface<V>. The QueueInterface<V> has some functions inbuilt in it like size(), isEmpty(), isFull(), enqueue() and dequeue(). The enqueue() takes a node as argument and add that element to the end of the queue or PriorityQueue.
  
The implementation of the dequeue() method is different for Queue and PriorityQueue. 
### 1. In the class Queue<V> which implements QueueInterface<V> ,  
  1.1. I have created an array of nodes named queue on which the whole working of the class Queue depends. I have created four integers namely front, rear, capacity and currentSize. 
  
  1.2. I have created a constructor of Queue in which the specified argument is the capacity of Queue.  In this, I have assigned the capacity to the size of the array. Rear to -1,front to 0 and currentSize to 0. 
  
  1.3. I have written and tested a function called size(), which returns the size of the Queue which is the value of currentSize at that stage. 
  
  1.4. I  have written and tested a function called isEmpty(), which returns true if the size is zero and false if not. 
  
  1.5. I have written and tested a function called isFull(), which returns true if the Queue is full and false otherwise. 
  
  1.6. I have written and tested a function called enqueue(node), which takes the node as the argument and add this node in the last position of the queue. This is done by implementing the cyclic array. I have iterated the rear by 1 and added the element to the index of the rear, so, when the rear iterates to last then after next iteration, it will reach to the zeroth index of the array. So the next element will be assigned to the first index of the array. I have increased the currentSize by 1. This method will not do anything if the Queue is already full. 
  
  1.7. I have written and tested a function called dequeue(), which removes the last element from the Queue. This is also cyclic in the array, as the front denotes the index of the first element of the queue which may or may not be the first element of the array. I have stored the array[front] in another node and then iterated the front by 1 and returned the node. Now the new front index determines the first element of the Queue. I have finally decreased the currentSize by 1. This method will return null if the queue is empty. 
  
  1.8. I have written and tested a function called display(), which prints all the elements of the Queue in the dequeuing order. 

### 2. In the class PriorityQueue<V> which implements QueueInterface<V> , 
  
  2.1. This PriorityQueue consists of elements which are of the type node. Every node contains two data in it. First is the priority value of the item and second is itself the item. 
  
  2.2. I have written and tested a function called size(), which returns the size of the PriorityQueue. 
  
  2.3. I  have written and tested a function called isEmpty(), which returns true if the size is zero and false if not. 
  
  2.4. I have written and tested a function called isFull(), which returns true if the PriorityQueue is full and false otherwise. 
  
  2.5. I have written and tested a function called enqueue(node), which add the node to the last of the PriorityQueue, same as that of Queue. 
  
  2.6. I have written and tested a function called dequeue(), which removes that node from the PriorityQueue which has the least priority value(note that the highest priority element has the least value of priority). I have done this by a method in which I have found the node with the least priority and its index in the array of PriorityQueue by comparing the priority of all the nodes. Then I have stored that node in another variable of type Node and shifted all the succeeding elements by one place to the left. Finally, I have decreased the size by 1 and returned the stored node. 
  
  2.7. I have written and tested a function called display(), which is same as that of the Queue.
  
### 3. The class PriorityQueueTestDriver checks the implementation of the PriorityQueue. 
### 4. In the class Assignment2TestDriver, 

 4.1. In the class main, the code which read the file is given already. In fact, maximum work is done already. I have to add all the elements of the ArrayList named list to the defined Queue named inventory. This is done by applying a ‘for’ loop and taking each element from the list and adding it to the inventory. After that, I have created multiple sellers and buyers threads according to the number of sellers and buyers and started all the threads. At last, when all the implementations are completed, we have to run this main. 
### 5. In the class Seller<V> which implements the SellerBase<V>(which is a thread type class),
  
  5.1. In the constructor, all I have to do is to assign all the arguments passed, to the variables created in the class SellerBase<V> by using the syntax ‘super’. 
  
  5.2. In the function sell(), first I have applied a lock so that no other seller thread can access it simultaneously. Then I have written that if the catalog is full, then the seller thread has to wait until a  buyer buys an item. Otherwise, the seller thread will check whether the inventory is empty or not if it's not then it will dequeue an element from it and enqueue the element in the catalog(a PriorityQueue). then I have signaled all the buyer thread that they can now buy the item. Finally, I have unlocked the lock. 
  
### 6. In the class Buyer<V> which implements the BuyerBase<V>(which is a thread type class), 
  
  6.1. In the constructor, all I have to do is to assign all the arguments passed, to the variables created in the class BuyerBase<V> by using the syntax ‘super’. 
  
  6.2. In the function buy(), first I have applied a lock so that no other thread can access it simultaneously. Then I have written that if the catalog is full, the buyer should wait for the seller to provide an item to the catalog. If it’s not, then the buyer will dequeue the element of the least priority value from the catalog and prints the priority value. Then it will notify all the seller that they can now add items to the catalog. Finally, I have unlocked the lock. 

The threads are created on the SellerBase and BuyerBase classes which execute the run function in these classes, which contains sell() and buy() respectively. 
