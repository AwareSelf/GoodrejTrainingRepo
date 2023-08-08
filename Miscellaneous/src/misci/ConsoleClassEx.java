package misci;

import java.io.Console;  
class ConsoleClassEx{    
public static void main(String args[]){    
	
	Console console=System.console();  
	
	if(console!=null)
	{
		String username = console.readLine("Please enter user name : ");     
		console.writer().println("welcome "+username);    
		
		
		console.printf("Here is your name: %s\n", username);
		
		char[] pass = console.readPassword("Please enter password : ");     
		String password=String.valueOf(pass);//converting char array into string    
		System.out.println("Password is: "+password); 
	}
	else
	{
	     System.out.println(" No Console! ");
		 //Note: System.console() returns null in an online IDE
	}
  }    
}  