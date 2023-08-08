package concurrenthashmap.parallelism;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapParallelism {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();
		hashMap.put("A", 1);
		hashMap.put("B", 2);
		hashMap.put("C", 3);
		hashMap.put("D", 4);
		hashMap.put("E", 5);
		hashMap.put("F", 6);
		hashMap.put("G", 7);
		
		hashMap.forEach(2,(k, v) -> System.out.println("key->" + k 
	                    		+ "is related with value-> " 
		                        + v +", by thread-> "
			                    + Thread.currentThread().getName()));
		
		
		String result = hashMap.search(1, (k, v) -> {
			  System.out.println(Thread.currentThread().getName());
			  if (k.equals("F"))
			    return k +"-" +v;
			  return null;
			});
			System.out.println("result => " +result);

	}

}
