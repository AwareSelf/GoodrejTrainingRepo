package concurrentcollections;

// Java program to illustrate
// CopyOnWriteArrayList class
import java.io.*;
import java.util.*;
import java.util.concurrent.*;


public class CopyOnWriteArrayListIterator {
	


		public static void main(String[] args)
		{

			CopyOnWriteArrayList<String> list
				= new CopyOnWriteArrayList<>();

			// Initial Iterator
			Iterator itr = list.iterator();
			list.add("GfG");
			System.out.println("List contains: ");
			while (itr.hasNext())
				System.out.println(itr.next());

			// iterator after adding an element
			itr = list.iterator();
			System.out.println("List contains:");
			while (itr.hasNext())
				System.out.println(itr.next());
		}
	


}
