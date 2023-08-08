package junit.nama.junit.argumentconverter;


import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class EmployeeConverter implements ArgumentConverter {
	
	  @Override
	    public Object convert(Object source, ParameterContext context)
	      throws ArgumentConversionException {
	        if (!(source instanceof String)) {
	            throw new IllegalArgumentException(
	              "The argument should be a string: " + source);
	        }
	        try {
	        	
	            String[] parts = ((String) source).split(" ");
	            
	   //      System.out.println("parts:"+parts[0]+","+parts[1]+","+parts[2]+","+parts[3]);
	            int empid = Integer.parseInt(parts[0]);
	   //        System.out.println(empid);
	            
	             String empname = parts[1];
	   //        System.out.println("empname:"+empname);
	           
	            double sal = Double.parseDouble(parts[2]);
	    //      System.out.println(sal);
	            
	            int deptno = Integer.parseInt(parts[3]);
	     //      System.out.println(deptno);

	            return new Employee(empid,empname,sal,deptno);
	            
	           
	          
	        } catch (Exception e) {
	            throw new IllegalArgumentException("Failed to convert", e);
	        }
	    }

}
