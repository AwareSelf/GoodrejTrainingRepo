package junit.nama.junit.dynamictest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class DynamicTest2 {

	@TestFactory
	Stream<DynamicTest> dynamicTestsForEmployeeWorkflows() {
	    List<Employee> inputList = Arrays.asList(
	    											new Employee(1, "Fred"), 
	    											new Employee(2,"Ram"), 
	    											new Employee(3, "John")
	    										);
	        
	    EmployeeDao dao = new EmployeeDao();
	    
	    
	    
	    //1st stream
	    Stream<DynamicTest> saveEmployeeStream = inputList.stream()
	      .map(emp -> DynamicTest.dynamicTest(
	        "saveEmployee: " + emp.toString(), 
	          () -> {
	              Employee returned = dao.save(emp);
	              assertEquals(returned.getId(), emp.getId());
	          }
	    ));
	        
	    
	    //2nd stream
	    Stream<DynamicTest> saveEmployeeWithFirstNameStream 
	      = inputList.stream()
	      .filter(emp -> !emp.getFirstName().isEmpty())
	      .map(emp -> DynamicTest.dynamicTest(
	        "saveEmployeeWithName" + emp.toString(), 
	        () -> {
	            Employee returned = dao.save(emp);
	            assertEquals(returned.getId(), emp.getId());
	            assertEquals(returned.getFirstName(), emp.getFirstName());
	        }));
	        
	    //combine two streams and return as single stream<dynamic tests>
	    return Stream.concat(saveEmployeeStream, 
	      saveEmployeeWithFirstNameStream);
	}
}
