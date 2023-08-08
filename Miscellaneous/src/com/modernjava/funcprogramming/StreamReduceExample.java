package com.modernjava.funcprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    public static void main(String[] args) {
    	
    	/*
    	 * Reduce - reduce is a repeated process of combining all elements
    	 * it takes an input of elements and combines them into a single result by 
    	 * repeated application of a combining operation for example sum,multiplication
    	 * and division of elements
    	 * 
    	 * Methods:
    	 * T reduce(identity,binaryOperator)
    	 * Optional reduce(binaryOperator)
    	 * 
    	 * Optional is a container object which may not contain a non-value
    	 */
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int results = numbers.stream()
                     //0 +1 = 1        //10+5= 15    //36+9=45
                    //1 + 2 = 3        //15+ 6= 21
                    //3 + 3 = 6        //21+7 = 28
                    //6+ 4 = 10        //28+8 = 36
                    .reduce(0,(a,b) -> a +b);

        //1 * 1 = 1     //0*1 = 0
        //1 * 2 = 2     //0*2=0
        int results1 = numbers.stream().reduce(1,(a,b) -> a* b);
        System.out.println(results);
        System.out.println(results1);

        Optional result2 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("--------");
        if(result2.isPresent())
            System.out.println(result2.get());


    }

}
