package concurrentcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Concurrent Hashmap is a class that was introduced in jdk1.5.  
 * Concurrent hash map applies locks only at bucket level called fragment while adding or updating the map. So, a concurrent hash map allows concurrent read and write operation to the map. 

Synchronized hashmap(Collection.syncronizedHashMap()) is a method of Collection framework. 
This method applies a lock on the entire collection. So, if one thread is accessing the map then 
no other thread can access the same map. 

Concurrent hash map	vs Synchronized hashmap
1
Implementation
It is a class that implements a Concurrent hash map and serializable interface. 
It is a method in Collection class.  
2
Lock mechanism
Locks the portion
Locks the whole map. 
3
Performance
Concurrent hashmap allows concurrent read and write. 
So performance is relatively better than a synchronized map. 

Multiple threads can't access the map concurrently. 
So, performance is relatively less than a concurrent hash map.
4
Null key
It doesn't allow null as a key or value. 
It allows null as a key.
5 
Concurrent modification exception
It doesn't throw concurrent modification exception. 
Iterator return by synchronized map throws concurrent modification exception
 */

/*
 * HashMap vs ConcurrentHashMap
Synchronized:	
HashMap is not synchronized.	
ConcurrentHashMap is synchronized.

Thread Safe	
HashMap is not thread safe.	
ConcurrentHashMap is thread safe.

Iterator type	
HashMap iterator is fail-fast and ArrayList throws ConcurrentModificationException if concurrent 
modification happens during iteration.	
ConcurrentHashMap is fail-safe and it will never throw ConcurrentModificationException during 
iteration.

Null values	
HashMap allows key and value to be null.	
ConcurrentHashMap does not allow null key/value. It will throw NullPointerException.

Performance	
HashMap is faster.	
ConcurrentHashMap is slower than HashMap.

Since Java Version	
1.2	
1.5
 */
class SynchronizedMapEx {
	
	public static void main(String[] args) {
	      Map<Integer,String> laptopmap = new HashMap<Integer,String>();
	      laptopmap.put(1,"IBM");
	      laptopmap.put(2,"Dell");
	      laptopmap.put(3,"HCL");
	      // create a synchronized map
	      Map<Integer,String> syncmap = Collections.synchronizedMap(laptopmap);
	      System.out.println("Synchronized map is : "+syncmap);
	      
	      //ConcurrentHashMap
	      Map<Integer,String> laptopmap1 = new ConcurrentHashMap<Integer,String>();
	      laptopmap1.put(1,"IBM");
	      laptopmap1.put(2,"Dell");
	      laptopmap1.put(3,"HCL");
	      System.out.println("ConcurrentHashMap is: "+laptopmap1);
	   }

}
