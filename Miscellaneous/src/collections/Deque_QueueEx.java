package collections;

/*

The Deque interface present in java.util package is a subtype of the queue interface. 
The Deque is related to the double-ended queue that supports addition or removal of elements from 
either end of the data structure. 
It can either be used as a queue(first-in-first-out/FIFO) or as a stack(last-in-first-out/LIFO). 
Deque is the acronym for double ended queue.

Since Deque is an interface, objects cannot be created of the type deque. 
We always need a class which extends this list in order to create an object. 
And also, after the introduction of Generics in Java 1.5, it is possible to restrict the type of
object that can be stored in the Deque. This type-safe queue can be defined as:

// Obj is the type of the object to be stored in Deque
Deque<Obj> deque = new ArrayDeque<Obj> ();

The class which implements the Deque interface is ArrayDeque.

ArrayDeque: ArrayDeque class which is implemented in the collection framework provides us with 
a way to apply resizable-array. 
This is a special kind of array that grows and allows users to add or remove an element from 
both sides of the queue. 
Array deques have no capacity restrictions and they grow as necessary to support usage. 
They are not thread-safe which means that in the absence of external synchronization, 
ArrayDeque does not support concurrent access by multiple threads. 
ArrayDeque class is likely to be faster than Stack when used as a stack. 
ArrayDeque class is likely to be faster than LinkedList when used as a queue. 
Let�s see how to create a queue object using this class.
*/

//Java program to demonstrate the working
//of a Deque in Java

import java.util.*;

public class Deque_QueueEx {
	public static void main(String[] args)
	{
		Deque<String> deque
			= new LinkedList<String>();

		// We can add elements to the queue
		// in various ways


		// Add at the last
		deque.offer("Element 5 (Tail)");

		// Add at the first
		deque.offerFirst("Element 6 (Head)");
		
		deque.offerLast("Element 7 (Tail)");


		System.out.println(deque + "\n");

		// We can remove the first element
		// or the last element.
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollLast());
		System.out.println("Deque after polling "
						+ "first and last: "
						+ deque);
		
		// Initializing an deque
        Deque<String> dq
            = new ArrayDeque<String>();
  
        // add() method to insert
        dq.offer("For");
        dq.offerFirst("Java");
        dq.offerLast("Java");
        dq.offer("is so good");
  
        System.out.println(dq);
        System.out.println(dq.peek());
        
        System.out.println(dq.poll());
  
        System.out.println(dq.pollFirst());
  
        System.out.println(dq.pollLast());
        for (Iterator itr = dq.iterator();
                itr.hasNext();) {
               System.out.print(itr.next() + " ");
           }
     
           System.out.println();
     
           for (Iterator itr = dq.descendingIterator();
                itr.hasNext();) {
               System.out.print(itr.next() + " ");
           }
	}
}
