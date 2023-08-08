package com.modernjava.funcprogramming.lamdaexprsn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.modernjava.funcprogramming.lamdaexprsn.Person.Sex;

public class MethodReferenceEx {

	

	public static void main(String[] args)
	{
		Person p1 = new Person("Namrata",LocalDate.of(1981,4,16),Sex.FEMALE,"namratamarathe81@gmail.com");
		Person p2 = new Person("Rahul",LocalDate.of(1974,1,1),Sex.MALE,"rahulmar@gmail.com");
		List<Person> roster = new ArrayList<Person>();
		roster.add(p1);
		roster.add(p2);
		
		Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
		Arrays.sort(rosterAsArray, new MethodReferenceEx().new PersonAgeComparator());
		
		/*
		The method signature of this invocation of sort is the following:

			static <T> void sort(T[] a, Comparator<? super T> c)
		*/
		
		
		/*
		 * Notice that the interface Comparator is a functional interface. 
		 * Therefore, you could use a lambda expression instead of defining and then 
		 * creating a new instance of a class that implements Comparator:
		 */
		//lambda expression - in place of comparator impl
		Arrays.sort(rosterAsArray,
			    (Person a, Person b) -> {
			        return a.getBirthday().compareTo(b.getBirthday());
			    }
			);
		
		
		/*
		 * However, this method to compare the birth dates of two Person instances 
		 * already exists as Person.compareByAge. You can invoke this method instead in 
		 * the body of the lambda expression:
		 */
		//lambda exprsn using existing function in Person class
		Arrays.sort(rosterAsArray,
			    (a, b) -> Person.compareByAge(a, b)
			);
		
		
		/*
		 * Because this lambda expression invokes an existing method, you can use a 
		 * method reference instead of a lambda expression:
		 */
		//lamda exprsn using Method reference
		Arrays.sort(rosterAsArray, Person::compareByAge);
		/*
		 * The method reference Person::compareByAge is semantically the same as the above
		 * lambda expression (a, b) -> Person.compareByAge(a, b). 
		 * Each has the following characteristics:
         * Its formal parameter list is copied from Comparator<Person>.compare, which is 
         * (Person, Person).
         * Its body calls the method Person.compareByAge.
		 */
	}
	
	

	class PersonAgeComparator implements Comparator<Person> {
	    public int compare(Person a, Person b) {
	        return a.getBirthday().compareTo(b.getBirthday());
	    }
	}
	        
	
}
