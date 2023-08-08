package junit.nama.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import customeexception.Account;
import customeexception.InsufficientBalanceException;




@TestMethodOrder(OrderAnnotation.class)
public class AccountClassTest1 {

	static Account ob;
	
	@BeforeAll
	static void setup()
	{
		 ob = new Account("Prateek Joshi",1001,1500);
	}

	/*
	@DisplayName("withdraw testing")
	@Test
	@Order(2)
	void testWithdraw() {
		
	
		try
		{
			
		
		  ob.withdraw(1500);
		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		double bal = ob.getBalance();
		assertEquals(2000,bal,"withdraw of Account not working as expected");
	}
	
	
	
	@DisplayName("test deposit method of Account")
	@Test
	@Order(1)
	void testDeposit() {
		
	
		try
		{
				 
		  ob.deposit(1500);
		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		double bal = ob.getBalance();
		System.out.println("balance after deposit 1500:"+bal);
		assertEquals(3500,bal,"deposit of Account not working as expected");
	}
	
	
	@DisplayName("test withdraw if bal  less than amount")
	@Test()
	@Order(4)
	void testInsufficientBalance()
	{
	      System.out.println("balance before withdraw:"+ob.getBalance());	
		  assertThrows(InsufficientBalanceException.class,
				 ()->ob.withdraw(3501));
	}
	*/
	
	//continuous withdrawl three times with diff amt from same account
	@DisplayName("withdraw testing for diff args")
	@ParameterizedTest
	@Order(3)
	@ValueSource(doubles= {10,20,30})
	void testWithdraw2(double args) {
		
	
		try
		{
			
			System.out.println("\nBalance before withdrawl:bal="+ob.getBalance());
		  ob.withdraw(args);
		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		double bal = ob.getBalance();
		System.out.println("after withdrawing amt="+args+",current bal="+bal);
		assertTrue(bal >= 0,"balance is less than zero test fail");
	}
	
	//continuous wihtdrawal with three diff amt from three diff accounts (each with mim bal=1500)
	@DisplayName("withdraw testing for diff args-check boundary values")
	@ParameterizedTest
	@Order(4)
	@ValueSource(doubles= {0,1499,1500})
	void testWithdraw3(double args) {
		
	    Account ob1=null;
		try
		{
			
		   ob1 = new Account("Prateek Joshi",1001,1500);
		   System.out.println("\nBalance before withdrawl:bal="+ob1.getBalance());
		  ob1.withdraw(args);
		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		double bal = ob1.getBalance();
		System.out.println("after withdrawing amt="+args+",current bal="+bal);
		assertTrue(bal >= 0,"balance is less than zero test fail");
	}
	
	

}
