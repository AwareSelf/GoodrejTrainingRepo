package com.modernjava.funcprogramming.lamdaexprsn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.modernjava.funcprogramming.lamdaexprsn.Person.Sex;

public class UsePerson {
	
	public static void main(String[] args)
	{
		Person p1 = new Person("Namrata",LocalDate.of(1981,4,16),Sex.FEMALE,"namratamarathe81@gmail.com");
		Person p2 = new Person("Rahul",LocalDate.of(1974,1,1),Sex.MALE,"rahulmar@gmail.com");
		List<Person> roster = new ArrayList<Person>();
		roster.add(p1);
		roster.add(p2);
		
		System.out.println(p1.getAge()+" "+p2.getAge());
		
		//argument defined anonymous inner class
		Person.printPersons(roster,  new CheckPerson() {
	        public boolean test(Person p) {
	            return p.getGender() == Person.Sex.MALE
	                && p.getAge() >= 18
	                && p.getAge() <= 50;
	        }
	    });
		
		//lamda expression
		Person.printPersons(
			    roster,
			    (Person p) -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 50
			);
		
	   //use Functional interface - use of Predicate to test condition
		Person.printPersonsWithPredicate(
			    roster,
			    p -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 50
			);
		//using Functional Interfaces - Predicate<T> & Consumer<T> 
		//here you are passing Functional references to two functions
		//which you can invoke indirectly via Predicate.test() and 
		//Consumer.accept() method.
		Person.processPersons(
			     roster,
			     p -> p.getGender() == Person.Sex.MALE
			         && p.getAge() >= 18
			         && p.getAge() <= 50,
			     p -> p.printPerson()
			);
		
		//using Functional Interfaces - Predicate,Consumer,Function
		Person.processPersonsWithFunction(
			    roster,
			    p -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 50,
			    p -> p.getEmailAddress(),
			    email -> System.out.println(email)
			);
		
		//invoking generic version
		Person.processElements(
			    roster,
			    p -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 50,
			    p -> p.getEmailAddress(),
			    email -> System.out.println(email)
			);
		
		// Use Aggregate Operations That Accept Lambda Expressions as Parameters
		// The following example uses aggregate operations to print the e-mail addresses 
		//of those members contained in the collection roster who are eligible for 
		//Selective Service:
		 roster
		     .stream()
		     .filter(
		         p -> p.getGender() == Person.Sex.MALE
		             && p.getAge() >= 18
		             && p.getAge() <= 25)
		     .map(p -> p.getEmailAddress())
		     .forEach(email -> System.out.println(email));
	} //end of main

}
