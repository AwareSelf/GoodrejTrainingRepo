package com.modernjava.funcprogramming;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsOperations {
    public static void main(String[] args) {
    	
    /*
     * distinct : method to collect or filter all distinct elements from a collection
     * count : returns the count(long) of elements in the stream
     * sorted : stream consisting of the elements of this stream, sorted according 
     *          to the natural order
     * anyMatch : returns whether any elements of the stream match the provided predicate
     * allMatch :  returns whether all elements of the stream match the provided predicate
     * nonMatch : returns whether no elements of this stream match the provided predicate 
     */
        //count   distinct
        Long count = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .count();

        System.out.println(count);
        //distinct
        List<String> courses = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(courses);

        //anymatch, allmatch and nonmatch


        boolean match = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .noneMatch(s -> s.startsWith("J"));

        System.out.println(match);




    }
}
