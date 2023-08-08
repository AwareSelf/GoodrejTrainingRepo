package junit.nama.junit.parameterizedtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class CsvSourceTest {

	  @ParameterizedTest
	    @CsvSource({
	            "java,      4",
	            "clojure,   7",
	            "python,    6"
	    })
	    void test_csv(String str, int length) {
	        assertEquals(length, str.length());
	    }
	 
	  /*
	  Suppose we're going to make sure that the toUpperCase() method from 
	  String generates the expected uppercase value. @ValueSource won't be enough.

	  To write a parameterized test for such scenarios, we have to

	  Pass an input value and an expected value to the test method
	  Compute the actual result with those input values
	  Assert the actual value with the expected value
	  So, we need argument sources capable of passing multiple arguments.

	  The @CsvSource is one of those sources:
      */
	  
	  @ParameterizedTest
	  @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
	  void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
	      String actualValue = input.toUpperCase();
	      assertEquals(expected, actualValue);
	  }

	  /*
	  The @CsvSource accepts an array of comma-separated values, and each array 
	  entry corresponds to a line in a CSV file.

	  This source takes one array entry each time, splits it by comma and passes 
	  each array to the annotated test method as separate parameters.

	  By default, the comma is the column separator, but we can customize it using 
	  the delimiter attribute:
     */
	  @ParameterizedTest
	  @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
	  void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
		  System.out.println("input="+input+",expected="+expected);
		  String actualValue = input.toLowerCase();
	      assertEquals(expected, actualValue);
	  }
	  //Now it's a colon-separated value, so still a CSV.

	 
	  //We can load the CSV file and ignore the header column with @CsvFileSource:

		  @ParameterizedTest
		  @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
		  void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(
		    String input, String expected) {
			  System.out.println("input="+input+",expected="+expected);
		      String actualValue = input.toUpperCase();
		      assertEquals(expected, actualValue);
		  }

}
