package com.modernjava.funcprogramming;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapExample {
    public static void main(String[] args) {
        //return only instructor names from the instructor list
        Set<String> instructorNames = Instructors.getAll().stream()
                                        .map(Instructor::getName)
                                        .map(String::toUpperCase)
                                        .collect(Collectors.toSet());
        System.out.println(instructorNames);
        
        
       List<String> lst =  Arrays.asList("namrata","sukanya","rutu","poorti");
       lst = lst.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
       
       
       List<Integer> lst1 =  Arrays.asList(10,20,30,40);
       lst1.stream().map(x -> x*x).forEach(System.out::println);
       
       IntStream.rangeClosed(10,20).map(x->x*x).forEach(System.out::println);
       /*
       IntStream.rangeClosed(10,20).filter(x->x>15).forEach(System.out::println);
       int sum = IntStream.rangeClosed(10,20).reduce(0,(x,y)->x+y);
       System.out.println(sum);
       */
    }
}
