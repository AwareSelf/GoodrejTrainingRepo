package concurrentcollections;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;  

/*
 * 
The ConcurrentModificationException occurs when an object is tried to be modified concurrently when it is 
not permissible. This exception usually comes when one is working with Java Collection classes.

For Example - It is not permissible for a thread to modify a Collection when some other thread is 
iterating over it. This is because the result of the iteration becomes undefined with it. 
Some implementation of the Iterator class throws this exception, including all those general-purpose 
implementations of Iterator which are provided by the JRE. Iterators which do this are called fail-fast 
as they throw the exception quickly as soon as they encounter such situation rather than facing 
undetermined behavior of the collection any time in the future.

Note: It is not mandatory that this exception will be thrown only when some other thread tries to 
modify a Collection object. It can also happen if a single thread has some methods called which are 
trying to violate the contract of the object. This may happen when a thread is trying to modify the 
Collection object while it is being iterated by some fail-fast iterator, the iterator will throw the 
exception.
 */

/*
 * How to avoid ConcurrentModificationException in a multi-threaded environment?
To avoid the ConcurrentModificationException in a multi-threaded environment, 
we can follow the following ways-

Instead of iterating over the collection class, we can iterate over the array. 
In this way, we can work very well with small-sized lists, but this will deplete the performance
if the array size is very large.
Another way can be locking the list by putting it in the synchronized block. 
This is not an effective approach as the sole purpose of using multi-threading is relinquished 
by this.
JDK 1.5 or higher provides with ConcurrentHashMap and CopyOnWriteArrayList classes. 
These classes help us in avoiding concurrent modification exception.
How to avoid ConcurrentModificationException in a single-threaded environment?
By using iterator's remove() function, you can remove an object from an underlying collection 
object.
 */

public class ConcurrentModificationExceptionEx {
  
	    public static void main(String[] args) {  
	    	/*
	        ArrayList<Integer> list = new ArrayList<>();  
	  
	        list.add(1);  
	        list.add(2);  
	        list.add(3);  
	        list.add(4);  
	        list.add(5);  
	  
	        Iterator<Integer> it = list.iterator();  
	        while (it.hasNext()) {                   
	Integer value = it.next();              
	            System.out.println("List Value:" + value);  
	            if (value.equals(3))  
	                list.remove(value);  
	        }  
	        
	        */
	        
	        
	        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
	        list.add(1);  
	        list.add(2);  
	        list.add(3);  
	        list.add(4);  
	        list.add(5);  
	  
	        Iterator<Integer> it = list.iterator();  
	        while (it.hasNext()) {                   
	Integer value = it.next();              
	            System.out.println("List Value:" + value);  
	            if (value.equals(3))  
	                list.remove(value);  
	        }  
	        
	        System.out.println(list);
	  
	       
	    }  
	  
	}  


