package junit.nama.junit.parameterizedtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;


//need to add dependency junit-jupiter-params
public class ParameterizedTestEx  {

	//ValueSourceTest
	
	 @ParameterizedTest(name = "#{index} - isEmpty()? {0}")
	  //  @EmptySource
	  //  @NullSource
	    @NullAndEmptySource
	   //@ValueSource(strings = {""})
	    void test_is_empty_true(String arg) {
		 
		   System.out.println("arg="+arg);
		   
		   if(arg==null)
			   assertTrue(arg==null,"arg is not null");
		   else
		     assertTrue(arg.isEmpty(),"arg is not empty");
	       
	    //    assertTrue(arg.isBlank());
	    }

    // This test will run 3 times with different arguments
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test_int_arrays(int arg) {
        assertTrue(arg > 0);
    }

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(ints = {1, 2, 3})
    void test_int_arrays_custom_name(int arg) {
        assertTrue(arg > 0);
    }

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(strings = {"apple", "banana", "orange"})
    void test_string_arrays_custom_name(String arg) {
        assertTrue(arg.length() > 1);
    }
    
    @ParameterizedTest(name = "#{index} - Test with range of Ints : {0}")
    @MethodSource("rangeProvider")
    void test_method_rangeint(int arg) {
        assertTrue(arg < 10);
    }

    // this need static
    static IntStream rangeProvider() {
        return IntStream.range(0, 10);
    }


}