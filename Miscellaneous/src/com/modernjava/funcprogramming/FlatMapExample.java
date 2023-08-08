package com.modernjava.funcprogramming;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
    	
    	//Flatmap is a combination of a map and flat operation
    	//It is used to flatten the stream
        //Get a list of all the courses which instructors offers
        Set<String> instructorsCourses = Instructors.getAll().stream()
                                        .map(Instructor::getCourses)
                                        .flatMap(List::stream)
                                        .collect(Collectors.toSet());
        System.out.println(instructorsCourses);
    }
}
