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
public class NoDigitException extends Exception {
	public NoDigitException(String message) {
		super(message);
	}
}