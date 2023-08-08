package concurrentcollections1.producerconsumer.usingblockingqueue;

import java.util.concurrent.BlockingQueue;

//Java program to demonstrate producer code

//Implement Runnable since object
//of this class will be executed by
//a separate thread
class Producerx implements Runnable {

	BlockingQueue<Integer> obj;

	public Producerx(BlockingQueue<Integer> obj)
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
				obj.put(i);
				System.out.println("Produced " + i);
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
