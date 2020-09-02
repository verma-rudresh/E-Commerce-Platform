

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buyer<V> extends BuyerBase<V> {
    //int catalogSize;
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        // Complete the Buyer Constructor method
        super.catalog = catalog;
        super.full = full;
        super.empty = empty;
        //this.catalogSize = catalogSize;
        super.setSleepTime(sleepTime) ;
        super.setIteration(iteration);
        super.lock = lock;
    }
    public void buy() throws InterruptedException
    {
        lock.lock();
        try
        {
            // Complete the try block for consume method
            // ...
            while(catalog.isEmpty())
                empty.await();
            NodeBase<V> n = catalog.dequeue();
            System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
            n.show(); // DO NOT REMOVE (For Automated Testing)
            // ...
            full.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Complete this block
            lock.unlock();
        }
    }
}

