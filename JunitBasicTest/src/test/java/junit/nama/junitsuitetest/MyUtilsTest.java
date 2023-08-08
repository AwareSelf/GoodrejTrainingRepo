package junit.nama.junitsuitetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.nama.junitbasictest.MyUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
 
@DisplayName(value = "All the Test Cases of MyUtils")
public class MyUtilsTest {
	
	private static MyUtils myUtils;
	
	@BeforeAll
	static void setUp() {
		myUtils = new MyUtils();
		System.out.println("Test data set up is done..");
	}
	
	
	@BeforeEach
	void beforeEach() {
		System.out.println("@BeforeEach is executed..");
	}
	
	@Test
	@Tag(value = "dev")
	@DisplayName(value = "adding two positive numbers")
	void test_add_two_positive_numbers() {
		int actualResult = myUtils.add(20, 10);
		assertEquals(30, actualResult);
	}
	
	@Test
	@Tag(value = "dev")
	@DisplayName(value = "adding two negtaive numbers")
	void test_add_two_negative_numbers() {
		int actualResult = myUtils.add(-20, -10);
		assertEquals(-30, actualResult);
	}
	
	@Test
	@DisplayName(value = "adding one positive and one negtaive number")
	void test_add_one_positive_and_one_negative_number() {
		int actualResult = myUtils.add(20, -10);
		assertEquals(10, actualResult);
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("@AfterEach is executed..");
	}
	
	@AfterAll
	static void tearDown() {
		myUtils = null;
		System.out.println("Test data teardown is done..");
	}
}