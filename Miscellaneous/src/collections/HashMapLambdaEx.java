package collections;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class HashMapLambdaEx {
   public static void main(String[] args) throws Exception {
	   /*
      HashMap<Integer,Callable<Integer>>map = new HashMap<Integer, Callable<Integer>>() {
         {
            put(0, () -> {
               return 10;
            });
            put(1, () -> {
               return 20;
            });
            put(2, () -> {
               return 30;
            });
            put(3, () -> {
               return 40;
            });
         }};
         System.out.println(map.get(0).call());
         System.out.println(map.get(1).call());
         System.out.println(map.get(2).call());
         System.out.println(map.get(3).call());
        */ 
         Callable<String> c = ()-> "HelloWorld!";
         System.out.println(c.call());
      }
   }

