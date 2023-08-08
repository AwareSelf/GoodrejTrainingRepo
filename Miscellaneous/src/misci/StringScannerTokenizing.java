package misci;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class StringScannerTokenizing {
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		  String text = "Now is the time for all good men";
		  String [] words = text.split("\\s");
		  System.out.println(Arrays.asList(words));
		  // words = "Now", "is", "the", "time", ...

		  text = "4231,         Java Programming, 1000.00";
		  //pattern - , surrounded by more than 1 space chars
		  String [] fields = text.split("\\s*,\\s*");
		  System.out.println(Arrays.asList(fields));
		  // fields = "4231", "Java Programming", "1000.00"
		  
		
		  Scanner scanner = new Scanner( text ).useDelimiter("\\s*,\\s*");
		  int checkNumber = scanner.nextInt(); // 4231
		  String description = scanner.next(); // "Java Programming"
		  float amount = scanner.nextFloat();  // 1000.00
		  
		  System.out.println(checkNumber+","+description+","+amount);
		 
		  try(Scanner fileScanner = new Scanner(new File("src/misci/spreadsheet.csv") );
				  )
		  {
		    fileScanner.useDelimiter( "\\s*,\\s*" );
		  //Another thing that you can do with the Scanner is to look ahead with the “hasNext” methods to see if another item is coming:

		    checkNumber = fileScanner.nextInt(); // 4231
			   description = fileScanner.next(); // "Java Programming
			   System.out.println(checkNumber+","+description);
			 
			  Double amount1 = Double.parseDouble(fileScanner.next());  // 1000.00
			   System.out.println(checkNumber+","+description+","+amount1);
		 }
	}

}
