import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Assignment2Driver {
	public int catalogSize;
	public int numBuyers;
	public int numSellers;
	public int sellerSleepTime, buyerSleepTime;
	public Queue<Item> inventory;

	public static void main(String[] args) throws InterruptedException {

		Assignment2Driver a_driver = new Assignment2Driver();
		BufferedReader reader;

		int itemcount = 0;
		try {
			//reader = new BufferedReader(new FileReader("C:\\Users\\DELL\\IdeaProjects\\test\\src\\tests\\input.txt"));
			reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			//System.out.println(line);
			ArrayList<Node<Item>> list = new ArrayList<>();
			String[] tokens = line.split(" ");
			a_driver.catalogSize = Integer.parseInt(tokens[0]);
			a_driver.numBuyers = Integer.parseInt(tokens[1]);
			a_driver.numSellers = Integer.parseInt(tokens[2]);
			a_driver.buyerSleepTime = Integer.parseInt(tokens[3]);
			a_driver.sellerSleepTime = Integer.parseInt(tokens[4]);
			//System.out.println(a_driver.catalogSize+ " " + a_driver.sellerSleepTime+ " "+ a_driver.buyerSleepTime);
			while (line != null) {
				line = reader.readLine();
				//System.out.println(line);
				if (line != null) {
					itemcount++;
					tokens = line.split(" ");


					Item item = new Item(tokens[1], Double.parseDouble(tokens[2]));
					Node<Item> node = new Node<>(Integer.parseInt(tokens[0]), item);
					list.add(node);
				}
			}
			a_driver.inventory = new Queue<>(list.size());
			int a  = list.size();
			// Add all elements of the ArrayList named "list" to inventory queue
			// ...
			for (Node<Item> itemNode : list)
				a_driver.inventory.enqueue(itemNode);
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		Seller[] sellers = new Seller[a_driver.numSellers];
		Buyer[] buyers = new Buyer[a_driver.numBuyers];
		PriorityQueue<Item> queue = new PriorityQueue<>(a_driver.catalogSize);
		Lock lock = new ReentrantLock();
		Condition full = lock.newCondition();
		Condition empty = lock.newCondition();
		int iteration; // No. of purchases each buyer make
		iteration = itemcount/a_driver.numBuyers;

		//  Create multiple Buyer and Seller Threads and start them.
		// ...
		Thread[] arr1 = new Thread[a_driver.numSellers];
		Thread[] arr2 = new Thread[a_driver.numBuyers];
		for(int i=0;i<a_driver.numSellers;i++){
			SellerBase obj = new Seller(a_driver.sellerSleepTime,a_driver.catalogSize,lock,full,empty,queue,a_driver.inventory);
			sellers[i] = (Seller) obj;
			Thread t = new Thread(obj);
			arr1[i] = t;
			arr1[i].start();
			arr1[i].sleep(10);
		}
		for(int i =0;i<a_driver.numBuyers;i++){
			BuyerBase obj = new Buyer(a_driver.buyerSleepTime,a_driver.catalogSize,lock,full,empty,queue,iteration);
			buyers[i] = (Buyer) obj;
			Thread t3 = new Thread(obj);
			arr2[i] = t3;
			arr2[i].start();
			arr2[i].sleep(10);
		}

	}
}
