package com.modernjava.funcprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamCustomSortExample {
    public static void main(String[] args) {
    	List<Instructor> courses = Instructors
    			.getAll()
    			.stream()
    			.sorted(Comparator.comparing(Instructor::getName))
    	.collect(Collectors.toList());
    	
    	courses.forEach(System.out::println);
    	
    	List<Instructor> courses1 = Instructors
    			.getAll()
    			.stream()
    			.sorted(Comparator.comparing(Instructor::getName).reversed())
    	.collect(Collectors.toList());
    	
    	courses1.forEach(System.out::println);



    }
}
