/*
 * Class: CMSC204 
 * Instructor: Prof. Kuijt
 * Description: Create an application that will check for valid passwords.The following rules must 
 * be followed to create a valid password. 1. At least 6 characters long. 
 * 2. 10 or more characters is a strong password, between 6 and 9 characters is a weak (but acceptable) password. 
 * 3. At least 1 numeric character. 4. At least 1 uppercase alphabetic character. 
 * 5. At least 1 lowercase alphabetic character. 6. At least 1 special character. 
 * 8. No more than 2 of the same character in a sequence
 * Due: 9/13/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Miles Levine
*/
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Miles Levine
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwordsTest;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception {
		String[] passArray = {"ABC123!@#", "miless5AAA#", "Asd1*", "pencil123!", "september1!", "CatsAndDogs"};
		passwordsTest = new ArrayList<String>();
		passwordsTest.addAll(Arrays.asList(passArray));
		
	 
	}

	@After
	public void tearDown() throws Exception {
		passwordsTest = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Apple"));
			assertTrue("Did not throw LengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides LengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertFalse(PasswordCheckerUtility.isValidPassword("password"));
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("IlikeBeans1"));

			assertTrue("Did not throw NoUpperAlphaException", false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("ABCDEFG123*"));
 
			assertTrue("Did not throw NoLowerAlphaException", false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("123zx*A");
			assertTrue("Did not throw WeakPassword Exception", false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion", true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true, PasswordCheckerUtility.isValidPassword("SUNNNYday123*"));
		 	assertTrue("Did not throw an InvalidSequenceException", false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(PasswordCheckerUtility.isValidPassword("HoldOn!!**"), true);
		 	assertTrue("Did not throw an NoDigitException", false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw an NoDigitException", true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an NoDigitException", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
		assertTrue(PasswordCheckerUtility.isValidPassword("Maryland1*"));
		assertTrue("This is a valid password", true);
		}
		catch (Exception e) {
			assertTrue("Exception was thrown", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwordsTest);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "ABC123!@#");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "miless5AAA#");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("sequence"));
		
		 
		scan = new Scanner(results.get(2));  
		assertEquals(scan.next(), "Asd1*");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "pencil123!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "september1!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") );
		 
		
		scan = new Scanner(results.get(5)); 
		assertEquals(scan.next(), "CatsAndDogs");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
	}
	
}
