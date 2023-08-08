package concurrentcollections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * CopyOnWriteArrayList is a thread-safe variant of ArrayList where operations which can 
 * change the ArrayList (add, update, set methods) creates a clone of the underlying array.

CopyOnWriteArrayList is to be used in a Thread based environment where read operations 
are very frequent and update operations are rare.

Iterator of CopyOnWriteArrayList will never throw ConcurrentModificationException.

Any type of modification to CopyOnWriteArrayList will not reflect during iteration 
since the iterator was created.

List modification methods like remove, set and add are not supported in the iteration. 
This method will throw UnsupportedOperationException.

null can be added to the list.
 */

/*
 *  	
ArrayList vs CopyOnWriteArrayList
Synchronized	
ArrayList is not synchronized.	
CopyOnWriteArrayList is synchronized.

Thread Safe	
ArrayList is not thread safe.	
CopyOnWriteArrayList is thread safe.

Iterator type	
ArrayList iterator is fail-fast and ArrayList throws ConcurrentModificationException 
if concurrent modification happens during iteration.	

CopyOnWriteArrayList is fail-safe and it will never throw ConcurrentModificationException 
during iteration. 
The reason behind it is that CopyOnWriteArrayList creates a new arraylist every time it is 
modified.

Remove Opearation	
ArrayList iterator supports removal of element during iteration.	
CopyOnWriteArrayList.remove() method throws exception if elements are tried to be removed during 
iteration.

Performance	
ArrayList is faster.	
CopyOnWriteArrayList is slower than ArrayList.

Since 
Java Version	1.2	
Java Version    1.5
 */

/*
 * Synchronized ArrayList and CopyOnWriteArrayList are useful for synchronizing the ArrayList. This is necessary for a multi-threaded environment to make sure thread safety is achieved.

The differences between Synchronized ArrayList and CopyOnWriteArrayList are given as follows −

Synchronized ArrayList	CopyOnWriteArrayList
Synchronized ArrayList is used to synchronize the ArrayList.	
CopyOnWriteArrayList is used to synchronize the ArrayList.

The Java 1.2 version first introduced the Synchronized ArrayList.	
The Java 1.5 version first introduced the CopyOnWriteArrayList.

The Synchronized ArrayList should be used when there are more write operations than 
reading operations in ArrayList.	
The CopyOnWriteArrayList should be used when there are more read operations than write 
operations in ArrayList.

This iterator is a fail-fast iterator.	
This iterator is a fail-safe iterator.

The synchronized block should contain the iteration of the list.	
The iteration of the list can be outside the synchronized block.

During the read or write operation, the whole ArrayList is locked by Synchronized ArrayList for 
thread safety.	
During the write operation only, the whole ArrayList is locked by CopyOnWriteArrayList for 
thread safety.

The Synchronized ArrayList should be used when the ArrayList is larger.	
The CopyOnWriteArrayList should be used when the ArrayList is smaller.
 */
public class CopyOnWriteArrayListEx {

   public static void main(String args[]) {
      // create an array list
      CopyOnWriteArrayList al = new CopyOnWriteArrayList();
      System.out.println("Initial size of al: " + al.size());

      // add elements to the array list
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");
      al.add(1, "A2");
      System.out.println("Size of al after additions: " + al.size());

      // display the array list
      System.out.println("Contents of al: " + al);

      // Remove elements from the array list
      al.remove("F");
      al.remove(2);
      System.out.println("Size of al after deletions: " + al.size());
      System.out.println("Contents of al: " + al);

      try {
         Iterator iterator = al.iterator();
         while(iterator.hasNext()) {
            iterator.remove();
         }
      }catch(UnsupportedOperationException e) {
         System.out.println("Method not supported:");
      }
      System.out.println("Size of al: " + al.size());
   }
}