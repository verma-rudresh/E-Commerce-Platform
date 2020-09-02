

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V>
{
    int catalogSize;
    //Lock lock;
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {

        super.catalog = catalog;
        super.inventory = inventory;
        super.full = full;
        super.empty = empty;
        this.catalogSize = catalogSize;
        super.setSleepTime(sleepTime);
        super.lock = lock;
    }

    public void sell() throws InterruptedException {
        lock.lock();
        try {

            while(catalog.isFull())
                full.await();
            if(!inventory.isEmpty())
            {
             NodeBase<V> item = inventory.dequeue();
                catalog.enqueue((Node<V>) item);
            }

            empty.signalAll();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }
}

