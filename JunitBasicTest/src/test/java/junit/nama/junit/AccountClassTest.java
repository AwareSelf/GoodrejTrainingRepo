package junit.nama.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import customeexception.Account;
import customeexception.InsufficientBalanceException;
import junit.nama.junitbasictest.MyUtils;

public class AccountClassTest {

	static Account ob;
	
	@BeforeAll
	static void setup()
	{
		 ob = new Account("Prateek Joshi",1001,2000);
	}

	@DisplayName("withdraw testing")
	@Test
	void testWithdraw() {
		
	
		try
		{
			
		
		  ob.withdraw(1500);
		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		double bal = ob.getBalance();
		assertEquals(500,bal,"withdraw of Account not working as expected");
	}
	
	
	
	@DisplayName("test deposit method of Account")
	@Test
	void testDeposit() {
		
	
		try
		{
				 
		  ob.deposit(1500);
		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		double bal = ob.getBalance();
		assertEquals(2000,bal,"deposit of Account not working as expected");
	}
	
	@DisplayName("test withdraw if bal  less than amount")
	@Test()
	void testInsufficientBalance()
	{
	      System.out.println("balance before withdraw:"+ob.getBalance());	
		  assertThrows(InsufficientBalanceException.class,
				 ()->ob.withdraw(2001));
	}

}
