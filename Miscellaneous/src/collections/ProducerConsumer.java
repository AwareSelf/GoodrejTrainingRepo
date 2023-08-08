package collections;

//Java program to demonstrate consumer code

//Java Program to demonstrate producer consumer
//problem solution

//Import the BlockingQueue interface and
//ArrayBlockingQueue class
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Create a Main class for execution
public class ProducerConsumer {
	public static void main(String[] args)
	{

		// Create an ArrayBlockingQueue object with capacity
		// 4
		BlockingQueue<Integer> bqueue
			= new ArrayBlockingQueue<Integer>(4);

		// Create 1 object each for producer
		// and consumer and pass them the common
		// buffer created above
		producer p1 = new producer(bqueue);
		consumer c1 = new consumer(bqueue);

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

class producer implements Runnable {

	BlockingQueue<Integer> obj;

	public producer(BlockingQueue<Integer> obj)
	{
		this.obj = obj;
	}

	@Override public void run()
	{
		for (int i = 1; i <= 4; i++) {
			try {
				obj.put(i);
				System.out.println("Produced " + i);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class consumer implements Runnable {

	BlockingQueue<Integer> obj;

	int taken = -1;

	public consumer(BlockingQueue<Integer> obj)
	{
		this.obj = obj;
	}

	@Override public void run()
	{
		while (taken != 4) {
			try {
				taken = obj.take();
				System.out.println("Consumed " + taken);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/*
 * The Producer-Consumer problem is a synchronization issue that arises when one or more threads
 *  generate data, placing it on a buffer, and simultaneously, one or more threads consume data 
 *  from the same buffer. 

Doing so can cause a race condition in which the threads are racing against each other to 
complete their task. In this scenario, nothing stops them from entering methods at the same 
time and producing erroneous results. 

Moreover, due to a lack of inter-thread communication, the consumer may try to remove an element 
even though the buffer is empty. Similarly, the producer may try to add an element when the 
buffer is full. 

Possible Solutions:

1) 
Checking the size of the buffer before removing and adding seems like a solution. 
Producer-Consumer systems generally use an infinite while loop. 
Checking the size for every iteration of the loop would be inefficient. Also, thread-safety 
cannot be guaranteed. Hence this solution is not used.

2)
wait() & notify() methods can be used to establish inter-thread communication.
3)
BlockingQueue is a less-complex thread-safe alternative to wait() & notify(). 
This method is discussed in this article.

The BlockingQueue interface is part of the java.util.concurrent package. 

If a producer thread tries to put an element in a full BlockingQueue, it gets blocked and 
stays blocked until a consumer removes an element.
Similarly, if a consumer thread tries to take an element from an empty BlockingQueue, 
it gets blocked and remains blocked until a producer adds an element.

BlockingQueue also has add(E e) and remove() methods. 
But these methods must not be used for producer-consumer problems because:
add will throw IllegalStateException if the queue is full.
remove returns a boolean, but an element is to be returned.

Implementation of BlockingQueue
Since BlockingQueue is an interface, we cannot create its object. 
Instead, we can create objects of one of the classes which implement BlockingQueue. 
 For this demonstration, ArrayBlockingQueue shall be used.

ArrayBlockingQueue

As the name suggests, an ArrayBlockingQueue uses the array data structure as a buffer.
Since it is an array, its capacity is fixed after declaration.
It provides fairness as an option. This means threads are given access to the buffer on a first-come, first-serve basis. Fairness is off by default. It can be turned on by placing the boolean value true inside the constructor.
Production-Consumer Solution
Now that we understand what a BlockingQueue is and its usage. Let us apply this knowledge to solve the producer-consumer problem. We can divide this problem into two subproblems by creating a separate class for producer and consumer for convenience. The producer and consumer will be acted upon by different threads but will share a common BlockingQueue buffer.

Producer: As the name suggests, the producer class will produce data. In our case, the producer class is producing numbers in the range [1,4]. It will place this data in the BlockingQueue buffer.

// 
*/
