package junit.nama.junit.nestedtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Nested;

public class NestedHierarchyFBLoginTest {
	
	@BeforeAll
	static void setUp(){
	   System.out.println("@BeforeAll- FBloginTest");
	 }
	@BeforeEach
	void beforeEachTest(){
		System.out.println("@BeforeEach- FBloginTest");
	}
	
	@Test
	void verifyLoginID(){
			String id="user1";
			assertEquals(id, "user1", "Valid login id");
			System.out.println("OUTERMOST CLASS - FBloginTest");
	}

	@Nested
	class PasswordCheckClass { 

		@Test
		void  verifyPassword(){
			String passwd="mypasswd123";
			assertEquals(passwd,"mypasswd123","Valid password");
			System.out.println("NESTED CLASS - nestedPasswordClass-verifyPassword test1");
		}
		
		@Test
		void  verifyPassword1(){
			String passwd="mypasswd123";
			assertNotEquals(passwd,"mypasswd","Invalid password");
			System.out.println("NESTED CLASS - nestedPasswordClass-verifyPasswordTest2");
		}
	}
	
	@Nested
	class ValidatePhonenoClass { 
      
		@Test
		void  verifyPhoneno(){
			String passwd="mypasswd123";
			assertEquals(passwd,"mypasswd123","Valid phoenno");
			System.out.println("NESTED CLASS - nestedPasswordClass-verifyPhoeno test1");
		}
		
		@Test
		void  verifynotblank(){
			String passwd="mypasswd123";
			assertNotEquals(passwd,"mypasswd","Invalid phoneno");
			System.out.println("NESTED CLASS - nestedPasswordClass-verifyPhonenoTest2");
		}
	}
	
	@AfterEach
	void afterEachTest(){
		System.out.println("@AfterEach- FBloginTest");
	}
	@AfterAll
	static void tearDown(){
		System.out.println("@AfterAll-FBloginClass");
	}
}