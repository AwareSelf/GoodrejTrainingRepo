package concurrentcollections1;

//Java Program to llustarte ConcurrentModificationException
//Using ConcurrentHashMap

//Importing required classes
import java.util.*;


//ConcurrentHashMap class extending Thread class
class ArrayListEx1 extends Thread {

	// Creating static concurrentHashMap object
	static List<Integer> lst
		= new ArrayList<Integer>();

	// Method 1
	// run() method for the thread
	public void run()
	{

		// Try block to check for exceptions
		try {

			// Making thread to sleep for 2 seconds
			Thread.sleep(2000);
		}

		// Catch block to handle the exceptions
		catch (InterruptedException e) {
		}

		// Display message
		System.out.println("Child Thread updating list");

		// Inserting element
		lst.add(103);
	}

	// Method 2
	// Main driver method
	public static void main(String arg[])
		throws InterruptedException
	{

		// Adding elements to object created of Map
	    lst.add(101);
		lst.add(102);

		// Creating thread inside main() method
		ArrayListEx1 t = new ArrayListEx1();

		// Starting thread
		t.start();

		// Creating object of Set class
		Iterator<Integer> itr = lst.iterator();

	
		// Condition holds true till there is single element
		// in Set object
		while (itr.hasNext()) {

			// Iterating over elements
			// using next() method
						// Display message
			System.out.println(
				"Main Thread Iterating concurrent List and Current value is:"
			 + "..." + itr.next());

			// Making thread to sleep for 3 seconds
			Thread.sleep(3000);
		}

		// Display elements of concurrent (CopyOnWriteArrayList) list objects
		System.out.println(lst);
	}
}
