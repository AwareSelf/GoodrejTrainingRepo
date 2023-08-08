package com.modernjava.funcprogramming.lamdaexprsn;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
   	Sex gender;
  	String emailAddress;

    public Person(String name,LocalDate bday,Sex gender,String emailaddr)
    {
    	this.name=name;
    	this.birthday=bday;
    	this.gender=gender;
    	this.emailAddress=emailaddr;
    }
    
    public String getName() {
  		return name;
  	}

  	public void setName(String name) {
  		this.name = name;
  	}
    
    public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

    public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
    public Sex getGender() {
		return gender;
	}


	public void setGender(Sex gender) {
		this.gender = gender;
	}


	public int getAge() {
        // ...
    	return Period.between(birthday,LocalDate.now()).getYears();
    }
	
    //used to explain Method-Reference
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public void printPerson() {
       System.out.println(this.name+" "+this.gender+" "+this.birthday+" "+this.getAge()
       +" "+this.emailAddress);
    }
    
    public static void printPersons(
    			
    	    List<Person> roster, CheckPerson tester) {
    	System.out.println("inside printPersons..");
    	    for (Person p : roster) {
    	        if (tester.test(p)) {
    	            p.printPerson();
    	        }
    	        else
    	        {
    	        	System.out.println("did not match the criteria for printing..");
    	        }
    	        
    	    }//for
    	}//printPersons
    
        //use Predicate<T> - Functional Interface
  		public static void printPersonsWithPredicate(
  			    List<Person> plist, Predicate<Person> tester) {
  			    for (Person p : plist) {
  			        if (tester.test(p)) {
  			            p.printPerson();
  			        }
  			      else
      	          {
      	        	System.out.println("did not match the criteria for printing..");
        	        }
  			    }
  			};  
  			
  			//using Predicate and Consumer Functional interfaces
  			public static void processPersons(
  				    List<Person> roster,
  				    Predicate<Person> tester,
  				    Consumer<Person> block) {
  				        for (Person p : roster) {
  				            if (tester.test(p)) {
  				                block.accept(p);
  				            }
  				        }
  				}
    
  			//using FunctionalInterface - Predicate<T>,Consumer<T>,Function<T>
  			/* Predicate reference can indirectly invoke a function via it's test() function
  			 * invoked function can then check/test for some condition and return a 
  			 * boolean value indicating condition passed or failed
  			*/
  			/* Consumer reference can indirectly invoke a function via it's accept() function
  			 * invoked function can execute a body of function 
  			 * it does not return any value but void
  			 */
  			/* Function reference can indirectly invoke a function via it's apply() function
  			 * invoked function can execute a body of statements
  			 * and return computed value to its caller
  			 */
  			
  	//To print the e-mail address of members who are eligible for Selective Service, 
  	//invoke the processElements method as follows:
  			public static void processPersonsWithFunction(
  				    List<Person> roster,
  				    Predicate<Person> tester,
  				    Function<Person, String> mapper,
  				    Consumer<String> block) {
  				    for (Person p : roster) {
  				        if (tester.test(p)) {
  				            String data = mapper.apply(p);
  				            block.accept(data);
  				        }
  				    }
  				}
  			
  		
  			//generic version
  			public static <X, Y> void processElements(
  				    Iterable<X> source,
  				    Predicate<X> tester,
  				    Function <X, Y> mapper,
  				    Consumer<Y> block) {
  				    for (X p : source) {
  				        if (tester.test(p)) {
  				            Y data = mapper.apply(p);
  				            block.accept(data);
  				        }
  				    }
  				}
  			
  	/*
  	The following table maps each of the operations the method processElements 
  	performs with the corresponding aggregate operation:

  	processElements Action     -->	Aggregate Operation
  	Obtain a source of objects -->	Stream<E> stream()
  	Filter objects that 
  	match a Predicate object   -->  Stream<T> filter(Predicate<? super T> predicate)
  	Map objects to another 
  	value as specified by a 
  	Function object            --> <R> Stream<R> map(Function<? super T,? extends R> mapper)
  	Perform an action as 
  	specified by a 
  	Consumer object	           --> void forEach(Consumer<? super T> action)
  				
  	The operations filter, map, and forEach are aggregate operations. 
  	Aggregate operations process elements from a stream, not directly from a collection
  	(which is the reason why the first method invoked in this example is stream). 
  	A stream is a sequence of elements. 
  	Unlike a collection, it is not a data structure that stores elements. 
  	Instead, a stream carries values from a source, such as collection, 
  	through a pipeline. 
  	A pipeline is a sequence of stream operations, which in this example is 
  	filter- map-forEach. 
  	In addition, aggregate operations typically accept lambda expressions as parameters, 
  	enabling you to customize how they behave.
    For a more thorough discussion of aggregate operations (https://docs.oracle.com/javase/tutorial/collections/streams/index.html), 
    see the Aggregate Operations lesson.  */
}