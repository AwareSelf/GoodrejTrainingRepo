package com.modernjava.funcprogramming.lamdaexprsn;

interface CheckPerson {
    boolean test(Person p);
}

/*
 * no need to define this java.util package has Predicate interface defined as below:-
interface Predicate<T> {
    boolean test(T t);
}*/
//The following class implements the CheckPerson interface by specifying an implementation for the method test. This method filters members that are eligible for Selective Service in the United States: it returns a true value if its Person parameter is male and between the ages of 18 and 25:

public class CheckPersonImpl implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}

