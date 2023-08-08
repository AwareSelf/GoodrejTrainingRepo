
package concurrentcollections1.producerconsumer.usingblockingqueue;

//Java Program to demonstrate producer consumer
//problem solution

//Import the BlockingQueue interface and
//ArrayBlockingQueue class
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Create a Main class for execution
public class ProducerConsumerEx {
	public static void main(String[] args)
	{

		// Create an ArrayBlockingQueue object with capacity
		// 4
		BlockingQueue<Integer> bqueue
			= new ArrayBlockingQueue<Integer>(4);

		// Create 1 object each for producer
		// and consumer and pass them the common
		// buffer created above
		Producerx p1 = new Producerx(bqueue);
		Consumerx c1 = new Consumerx(bqueue);

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
