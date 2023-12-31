package concurrentcollections1.producerconsumer.usingblockingqueue;

import java.util.concurrent.BlockingQueue;

//Java program to demonstrate consumer code

//Implement Runnable since object
//of this class will be executed by
//a separate thread
public class Consumerx implements Runnable {

	BlockingQueue<Integer> obj;

	// Initialize taken to -1
	// to indicate that no number
	// has been taken so far.
	int taken = -1;

	public Consumerx(BlockingQueue<Integer> obj)
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
				taken = obj.take();
				System.out.println("Consumed " + taken);
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(obj);
	}
}
