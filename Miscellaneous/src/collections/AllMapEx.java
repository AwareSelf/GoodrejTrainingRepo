package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
/*
TreeMap in Java
A TreeMap in Java is implemented using a Red-Black trees. 
It has key-value pairs i.e. keys that are associated with the values and the keys are ordered. 
A TreeMap can only have unique elements and cannot have a null key but have null elements.
*/

/*
HashMap in Java
A HashMap in Java is implemented using an array of linked lists. 
It has key-value pairs i.e. keys that are associated with the values and the keys 
are in arbitrary order. 
A HashMap can only have unique elements and can have only one null key but multiple null 
elements.
*/

/*
LinkedHashMap in Java
A LinkedHashMap in Java is implemented using doubly linked buckets. 
It has key-value pairs i.e. keys that are associated with the values and the keys are ordered by 
their insertion order. 
A LinkedHashMap can only have unique elements and can have only one null key but multiple null 
elements.
*/
public class AllMapEx {
	
	public static void main (String[] args) {
		
	//TreeMap
	TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
    int[] arr = {1, 3, 5, 7, 9};
    for (int i : arr) {
       tMap.put(i, Integer.toString(i));
    }
    for (int j: tMap.keySet()) {
       System.out.print(j + " ");
    }
    
    //HashMap
    HashMap<Integer, String> hMap1 = new HashMap<Integer, String>();
    int[] arr1 = {1, 3, 5, 7, 9};
    for (int i : arr1) {
       hMap1.put(i, Integer.toString(i));  
    }
    for (int j: hMap1.keySet()) {
       System.out.print(j + " ");
    }
    
    //LinkedHashMap
    LinkedHashMap<Integer, String> lhMap = new LinkedHashMap<Integer, String>();
    int[] arr2 = {1, 3, 5, 7, 9};
    for (int i : arr2) {
       lhMap.put(i, Integer.toString(i));
    }
    for (int j: lhMap.keySet()) {
       System.out.print(j + " ");
    }
  }
}
