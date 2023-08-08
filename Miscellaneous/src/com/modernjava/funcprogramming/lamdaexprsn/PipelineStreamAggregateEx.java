package com.modernjava.funcprogramming.lamdaexprsn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.modernjava.funcprogramming.lamdaexprsn.Person.Sex;

public class PipelineStreamAggregateEx {
	
	public static void main(String[] args)
	{
		Person p1 = new Person("Namrata",LocalDate.of(1981,4,16),Sex.FEMALE,"namratamarathe81@gmail.com");
		Person p2 = new Person("Rahul",LocalDate.of(1974,1,1),Sex.MALE,"rahulmar@gmail.com");
		List<Person> roster = new ArrayList<Person>();
		roster.add(p1);
		roster.add(p2);
		
		for (Person p : roster) {
		    if (p.getGender() == Person.Sex.MALE) {
		        System.out.println(p.getName());
		    }
		}
		
		roster
	    .stream()
	    .filter(e -> e.getGender() == Person.Sex.MALE)
	    .forEach(e -> System.out.println(e.getName()));
		
		//average is aggregate function which 
		double average = roster
			    .stream()
			    .filter(p -> p.getGender() == Person.Sex.MALE)
			    .mapToInt(Person::getAge)
			    .average()
			    .getAsDouble();
		System.out.println(average);
		
		/*
		 * The JDK contains many terminal operations 
		 * (such as average, sum, min, max, and count) that return one value by combining 
		 * the contents of a stream. 
		 * These operations are called reduction operations. 
		 * The JDK also contains reduction operations that return a collection instead 
		 * of a single value. 
		 * Many reduction operations perform a specific task, such as finding the average
		 * of values or grouping elements into categories. However, the JDK provides you 
		 * with the general-purpose reduction operations reduce and collect, 
		 */
		Integer totalAge = roster
			    .stream()
			    .mapToInt(Person::getAge)
			    .sum();
		//Compare this with the following pipeline, which uses the Stream.reduce operation to calculate the same value:

			Integer totalAgeReduce = roster
			   .stream()
			   .map(Person::getAge)
			   .reduce(
			       0,
			       (a, b) -> a + b);
			
			List<String> namesOfMaleMembersCollect = roster
				    .stream()
				    .filter(p -> p.getGender() == Person.Sex.MALE)
				    .map(p -> p.getName())
				    .collect(Collectors.toList());
			
			Map<Person.Sex, List<Person>> byGender =
				    roster
				        .stream()
				        .collect(Collectors.groupingBy(Person::getGender));
			
			//multilevel-reduction using downstream-collector
			Map<Person.Sex, List<String>> namesByGender =
				    roster
				        .stream()
				        .collect(
				            Collectors.groupingBy(
				                Person::getGender,                      
				                Collectors.mapping(
				                    Person::getName,
				                    Collectors.toList())));
			
			//mutlitlevel reduction-downstream reduction
			//The following example retrieves the total age of members of each gender:

				Map<Person.Sex, Integer> totalAgeByGender =
				    roster
				        .stream()
				        .collect(
				            Collectors.groupingBy(
				                Person::getGender,                      
				                Collectors.reducing(
				                    0,
				                    Person::getAge,
				                    Integer::sum)));
				
			//The following example retrieves the average age of members of each gender:

					Map<Person.Sex, Double> averageAgeByGender = roster
					    .stream()
					    .collect(
					        Collectors.groupingBy(
					            Person::getGender,                      
					            Collectors.averagingInt(Person::getAge)));
	}

}

/*
 * A pipeline contains the following components:

A source: This could be a collection, an array, a generator function, or an I/O channel. 
In this example, the source is the collection roster.

Zero or more intermediate operations: An intermediate operation, such as filter, produces 
a new stream.
A stream is a sequence of elements. Unlike a collection, it is not a data structure that 
stores elements. Instead, a stream carries values from a source through a pipeline. 
This example creates a stream from the collection roster by invoking the method stream.

The filter operation returns a new stream that contains elements that match its predicate 
(this operation's parameter). In this example, the predicate is the lambda expression 
e -> e.getGender() == Person.Sex.MALE. It returns the boolean value true if the gender 
field of object e has the value Person.Sex.MALE. Consequently, the filter operation in 
this example returns a stream that contains all male members in the collection roster.

A terminal operation: A terminal operation, such as forEach, produces a non-stream result,
such as a primitive value (like a double value), a collection, or in the case of forEach,
no value at all. In this example, the parameter of the forEach operation is the lambda 
expression e -> System.out.println(e.getName()), which invokes the method getName on the 
object e. (The Java runtime and compiler infer that the type of the object e is Person.)
https://docs.oracle.com/javase/tutorial/collections/streams/index.html
*/