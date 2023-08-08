package concurrentcollections;
import java.util.HashMap;
import java.util.Iterator;

/*
 * This message says that the exception is thrown when the next method is called as the iterator
 *  is iterating the list and we are making modifications in it simultaneously. 
 *  But if we make modifications in hashmap like given below, then it will not throw any 
 *  such exception as the size of the hashmap won't change.
 */
import java.util.concurrent.*;

public class ConcurrentMapEx {
	
	public static void main(String[] args)
	{
	
		ConcurrentMap<Integer, String> m = new ConcurrentHashMap<Integer, String>();
		m.put(100, "Geeks");
		m.put(101, "For");
		m.put(102, "Geeks");

		// Here we cant add Hello because 101 key
		// is already present
		m.putIfAbsent(101, "Hello");

		// We can remove entry because 101 key
		// is associated with For value
		m.remove(101, "For");

		// Now we can add Hello
		m.putIfAbsent(101, "Hello");

		// We can replace Hello with For
		m.replace(101,"Hello","For");
		System.out.println("Map contents : " + m);
		
		/*
		ConcurrentSkipListMap is sorted and provides
		expected average log(n) time cost for the containsKey, get, put and remove operations and their 
		variants
		ConcurrentSkipListMap isn't so fast, but is useful when you need sorted thread-safe map.
		*/
		
		ConcurrentMap<Integer, Integer> mpp = new ConcurrentSkipListMap<Integer, Integer>();
		  
        // Adding elements to this map
          // using put() method
        for (int i = 1; i <= 5; i++)
            mpp.put(i, i);
        
        // remove() mapping associated
        // with key 1
        mpp.remove(1);
  
        System.out.println("After remove(): " + mpp);
  
        // Print map to the console
        System.out.println("After put(): " + mpp);
        
        ConcurrentMap<Integer, String> chm = new ConcurrentSkipListMap<Integer, String>();
        
        // insert mappings using put method
        chm.put(100, "Geeks");
        chm.put(101, "for");
        chm.put(102, "Geeks");
        chm.put(103, "Contribute");
        
        // Displaying the HashMap
        System.out.println("The Mappings are: ");
        System.out.println(chm);
  
        // Display the value of 100
        System.out.println("The Value associated to "
                           + "100 is : " + chm.get(100));
  
        // Getting the value of 103
        System.out.println("The Value associated to "
                           + "103 is : " + chm.get(103));
        
     // ConcurrentSkipListMap
        Iterator<ConcurrentSkipListMap
                     .Entry<Integer, String> > itr
            = chm.entrySet().iterator();
  
        // The hasNext() method is used to check if there is
        // a next element The next() method is used to
        // retrieve the next element
        while (itr.hasNext()) {
            ConcurrentSkipListMap
                .Entry<Integer, String> entry
                = itr.next();
            System.out.println("Key = " + entry.getKey()
                               + ", Value = "
                               + entry.getValue());
	           }//end of while
        
        
        HashMap<Integer, Integer> map = new HashMap<>();  
        map.put(1, 1);  
        map.put(2, 2);  
        map.put(3,3);  
          
        Iterator<Integer> it = map.keySet().iterator();  
        while(it.hasNext()) {  
            Integer key = it.next();  
            System.out.println("Map Value:" + map.get(key));  
            if (key.equals(2)) {  
                map.put(1, 4);  
            }  
        }     
    }  
 

    }


