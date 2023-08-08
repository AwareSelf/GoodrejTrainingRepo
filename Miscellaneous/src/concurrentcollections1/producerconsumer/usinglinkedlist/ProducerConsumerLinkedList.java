package concurrentcollections1.producerconsumer.usinglinkedlist;


//Java Program to demonstrate producer consumer
//problem solution

//Import the BlockingQueue interface and
//ArrayBlockingQueue class
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Create a Main class for execution
public class ProducerConsumerLinkedList {
	public static void main(String[] args)
	{

		// Create an ArrayBlockingQueue object with capacity
		// 4
		BlockingQueueUsingLinkedList<Integer> bqueue
			= new BlockingQueueUsingLinkedList<Integer>(4);

		// Create 1 object each for producer
		// and consumer and pass them the common
		// buffer created above
		Producer1 p1 = new Producer1(bqueue);
		Consumer1 c1 = new Consumer1(bqueue);

		// Create 1 thread each for producer
		// and consumer and pass them their
		// respective objects.
		Thread pThread = new Thread(p1);
		Thread cThread = new Thread(c1);

		// Start both threads
	
		pThread.start();
		cThread.start();
		
	}
}

class Producer1 implements Runnable {

	BlockingQueueUsingLinkedList<Integer> obj;

	public Producer1(BlockingQueueUsingLinkedList<Integer> obj)
	{
		// accept an ArrayBlockingQueue object from
		// constructor
		this.obj = obj;
	}

	@Override public void run()
	{
		
		// Produce numbers in the range [1,4]
		// and put them in the buffer
		for (int i = 1; i <= 5; i++) {
			try {
				obj.enqueue(i);
				System.out.println("Produced " + i);
				//Thread.sleep(500);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer1 implements Runnable {

	BlockingQueueUsingLinkedList<Integer> obj;

	// Initialize taken to -1
	// to indicate that no number
	// has been taken so far.
	int taken = -1;

	public Consumer1(BlockingQueueUsingLinkedList<Integer> obj)
	{
		// accept an ArrayBlockingQueue object from
		// constructor
		this.obj = obj;
	}

	@Override public void run()
	{

		// Take numbers from the buffer and
		// print them, if the last number taken
		// is 4 then stop
		while (taken != 4) {
			try {
				taken = obj.dequeue();
				System.out.println("Consumed " + taken);
				Thread.sleep(3000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(obj);
	}
}

