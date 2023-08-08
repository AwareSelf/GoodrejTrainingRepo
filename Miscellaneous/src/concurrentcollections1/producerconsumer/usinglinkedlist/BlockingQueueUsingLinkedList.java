package concurrentcollections1.producerconsumer.usinglinkedlist;

//Java program that explains the internal
//implementation of BlockingQueue

import java.io.*;
import java.util.*;

public class BlockingQueueUsingLinkedList<E> {

	// BlockingQueue using LinkedList structure
	// with a constraint on capacity
	private List<E> queue = new LinkedList<E>();

	// limit variable to define capacity
	private int limit = 10;

	// constructor of BlockingQueue
	public BlockingQueueUsingLinkedList(int limit) { this.limit = limit; }

	// enqueue method that throws Exception
	// when you try to insert after the limit
	public synchronized void enqueue(E item)
		throws InterruptedException
	{
		while (this.queue.size() == this.limit) {
			System.out.println("Queue is full with max capacity:"+this.limit);
			wait();
		}
		if (this.queue.size() == 0) {
			System.out.println("Queue is empty");
			notifyAll();
		}
		this.queue.add(item);
	}

	// dequeue methods that throws Exception
	// when you try to remove element from an
	// empty queue
	public synchronized E dequeue()
		throws InterruptedException
	{
		while (this.queue.size() == 0) {
			System.out.println("Queue is empty");
			wait();
		}
		if (this.queue.size() == this.limit) {
			System.out.println("Queue is full with max capacity:"+this.limit);	
			notifyAll();
		}

		return this.queue.remove(0);
		
		
	}

	@Override
	public String toString() {
		return "BlockingQueueUsingLinkedList [queue=" + queue + ", limit=" + limit + "]";
	}

	
}
