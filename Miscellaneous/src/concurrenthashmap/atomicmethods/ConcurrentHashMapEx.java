package concurrenthashmap.atomicmethods;

import java.util.concurrent.ConcurrentHashMap;

//https://dzone.com/articles/concurrenthashmap-in-java8
public class ConcurrentHashMapEx {

	public static void main(String[] args) {
		
		
	    merge();
	    getOrDefault();
	    compute();
	    reduce();
		

	}
	
static void merge()
{
/*
Merge
As per the Javadoc, "If the specified key is not already associated with a 
(non-null) value, associates it with the given value. 
Otherwise, replaces the value with the results of the given remapping function, 
or removes if null. 
The entire method invocation is performed atomically. 
Some attempted update operations on this map by other threads may be blocked while 
computation is in progress, so the computation should be short and simple, 
and must not attempt to update any other mappings of this Map."

The method signature of the merge method is:

public V merge(K key, V value, BiFunction remappingFunction)

Here, remappingFunction is the function that recomputes a value if present.
	
 */

	ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
	map.put("X", "x");
	System.out.println("1st ==> " +map);
	System.out.println("2nd ==> " + map.merge("X", "x", (v1, v2) -> null));
	System.out.println("3rd ==> " +map);
	map.put("Y", "y");
	map.put("X", "x1");
	System.out.println("4th ==> " +map.merge("X", "x1", (v1, v2) -> "z"));
	System.out.println("5th ==> " +map);
	System.out.println("6th ==> " +map.merge(
	 "X", "x1", (v1, v2) -> v2.concat("z")));
	System.out.println("7th ==> " +map);
}

	static void getOrDefault()
	{
		
		ConcurrentHashMap<String, Integer> defaultMap = 
				  new ConcurrentHashMap<String, Integer>();
				defaultMap.put("X", 30);
				System.out.println(defaultMap);
				System.out.println(defaultMap.getOrDefault("Y", 21));
		
	}
	
	static void compute()
	{
		/*
		Compute:- Generally, we do some computation on map values and store it back. 
		In the concurrent model, it's difficult to manage, and that's the reason 
		Java introduced the compute method. 
		The entire method invocation is performed atomically.

		The compute and computeIfPresent methods take a remapping function as an 
		argument to compute a value, and remapping is of type BiFunction. 
		The computeIfAbsent method takes an argument as mappingFunction to compute 
		a value, and hence mappingFunction is of type Function.
		
		*/
		ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
		map1.put("A", 1);
		map1.put("B", 2);
		map1.put("C", 3);
		// Compute a new value for the existing key
		System.out.println("1st print => " +map1.compute("A",
		  (k, v) -> v == null ? 42 : v + 40));
		System.out.println("2nd print => " + map1);
		// This will add a new (key, value) pair
		System.out.println("3rd print => " + map1.compute("X",
		  (k, v) -> v == null ? 42 : v + 41));
		System.out.println("4th print => " + map1);

		//computeIfPresent method
		System.out.println("5th print => " + map1.computeIfPresent("X", (k, v) -> v == null ? 42 : v + 10));
		System.out.println("6th print => " + map1);

		//computeIfAbsent method
		System.out.println("7th print => " + map1.computeIfAbsent("Y", (k) -> 90));
		System.out.println("8th print => " + map1);
	}


static void reduce()
{
/*
Reduce 
The reduce method signature is:
public U reduce(long parallelismThreshold, BiFunction transformer, 
                          BiFunction reducer)
Here, transformer is a function returning the transformation for an element, 
or null if there is no transformation (in which case it is not combined), 
and reducer is a commutative associative combining function.
 */
	
	ConcurrentHashMap<String, Integer> reducedMap = new ConcurrentHashMap<>();
	reducedMap.put("One", 1);
	reducedMap.put("Two", 2);
	reducedMap.put("Three", 3);
	System.out.println("reduce example => " 
	 +reducedMap.reduce(2, (k, v) -> v*2, (total, elem) -> total + elem)); //12

	System.out.println("reduceKeys example => " 
	 +reducedMap.reduceKeys(2, (key1, key2) -> key1.length() > key2.length() ? key1 + "-"+key2 : key2 + "-"+key1)); 

	System.out.println("reduceValues example => " 
	 +reducedMap.reduceValues(2, (v) -> v*2 , (value1, value2) -> value1 > value2 ? value1 - value2 : value2 - value1));
	System.out.println("After reduce => " +reducedMap); //0
}
}