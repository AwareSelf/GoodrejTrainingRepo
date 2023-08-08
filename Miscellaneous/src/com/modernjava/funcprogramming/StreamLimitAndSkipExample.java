package com.modernjava.funcprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLimitAndSkipExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        List limit5numbers = numbers.stream().limit(5).collect(Collectors.toList());
        limit5numbers.forEach(System.out::println);

        System.out.println("-----");
        List skip5numbers = numbers.stream().skip(5).collect(Collectors.toList());
        skip5numbers.forEach(System.out::println);
        
        Set<Integer> s = Stream.iterate(20,n->n+1).limit(5).collect(Collectors.toSet());
        s.forEach(System.out::println);
  
        int sum = Stream.iterate(20,n->n+1).limit(5).reduce(0,Integer::sum);
        System.out.println(sum);
    } 
}
