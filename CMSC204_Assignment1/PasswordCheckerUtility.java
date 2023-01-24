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



import java.util.*;
import java.util.ArrayList;

/**
 * @author Miles Levine
 *
 */
public class PasswordCheckerUtility {
	public PasswordCheckerUtility() {}
	
	/**
	 * Compare equality of two passwords
	 * @param password password string to be checked for
	 * @param passwordConfirm passwordConfirm string to be checked against password for
	 * @throws UnmatchedException thrown if not same (case sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		//If statement that calls the comparePasswordsWithReturn() method and compares both passwords to check if they are the same
		if (comparePasswordsWithReturn(password, passwordConfirm) == false) {
			//If the statement is false then the exception will be thrown
			throw new UnmatchedException("Passwords do not match");
		}
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password password string to be checked for
	 * @param passwordConfirm passwordConfirm string to be checked against password for
	 * @return true if both same (case sensitive), false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		//If statement that compares the password to passwordConfirm
		if (password.equals(passwordConfirm)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks the password length requirement - The password must be at least 6 characters long
	 * @param password password string to be checked for length
	 * @return true if meets minimum length requirement
	 * @throws LengthException thrown if does not meet minimum length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException {
		//Valid length is any input that has 6 characters and above. 
		final int MINIMUM = 6;
		if (password.length() >= MINIMUM) {
			return true;
		}
		//If the statement is false then LengthException will be thrown with message.
		throw new LengthException("The password must be at least 6 characters long");
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password password string to be checked for alpha character requirement
	 * @return true if meet alpha character requirement
	 * @throws NoUpperAlphaException thrown if does not meet alpha character requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		//Converts the String password, to an array of characters
		char[] characters = password.toCharArray();
		//Enhanced for loop to compare each and every character in the array.
		for(char ch : characters) {
			//If the char is Uppercase, return true.
			if(Character.isUpperCase(ch)) {
				return true;
			}

		}
		//After the for loop ends and the If statement does not return true then NoUpperAlphaException will be thrown with message.
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}

	/**
	 * Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	 * @param password password string to be checked for lowercase requirement
	 * @return true if meets lowercase requirement
	 * @throws NoLowerAlphaException thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		//Converts the String password, to an array of characters
		char[] characters = password.toCharArray();
		//Enhanced for loop to compare each and every character in the array.
		for(char ch : characters) {
			//If the char is Lowercase, return true.
			if(Character.isLowerCase(ch)) {
				return true;
			}
		}
		//After the for loop ends and the If statement does not return true then NoUpperAlphaException will be thrown with message.
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password password string to be checked for Digit requirement
	 * @return true if meet Digit requirement
	 * @throws NoDigitException thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		//Converts the String password, to an array of characters.
		char[] characters = password.toCharArray();
		//Enhanced for loop to compare each and every character in the array.
		for(char c : characters) {
			//If the char is a digit, return true.
			if(Character.isDigit(c)) {
				return true;
			}
		}
		//After the for loop ends and the If statement does not return true then NoUpperAlphaException will be thrown with message.
		throw new NoDigitException("The password must contain at least one digit");
	}
	
	
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password password string to be checked for SpecialCharacter requirement
	 * @return true if meets SpecialCharacter requirement
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		//Converts the String password, to an array of characters.
		char[] characters = password.toCharArray();
		String str = "..!@#$%&*()'+,-./:;<=>?[]^_`{|}"; //String str contains all of the special chars that can be input into a password.
		//Enhanced for loop to compare each and every character in the array.
		for(char c : characters) {
			//If one of the special characters in String str is in the password, return true.
			if(str.contains(Character.toString(c))) {
				return true;
			}
		}
		//After the for loop ends and the If statement does not return true then NoUpperAlphaException will be thrown with message.
		throw new NoSpecialCharacterException("The password must contain at least one special character");
	}
	
	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password password string to be checked for Sequence requirement
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException thrown if meets Sequence requirement
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		int count = 0;
		//for loop that loops for each character from the password string
		for (int index = 0; index < password.length(); index++) {
			
			if (count <= 3) {//If statement that iterates the counter 3 times
				if (index + 1 < password.length() && password.charAt(index) == password.charAt(index + 1)) {
					count++;
				}
			}
			else if (count <= 3) {//Once the counter becomes 3, if statement that compares the 3 characters to each other
				if (index + 1 < password.length() && password.charAt(index) != password.charAt(index + 1)) {
					count = 0;
				}
			}
		}
		//If the counter ends with less that 1 then the password does not contain more than 2 of the same characters in sequence
		if (count <= 1) 
			return true;
		
		else 
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
		
	}
	
	/**
	 * Return true if valid password (follows all the following rules), returns false if an invalid password
	 * 1. At least 6 characters long - 2. At least 1 numeric character- 3. At least 1 uppercase alphabetic character
	 * - 4. At least 1 lowercase alphabetic character - 5. At least 1 special character
	 * - 6. No more than 2 of the same character in a sequence - Hello@123 – OK AAAbb@123 – not OK Aaabb@123 – OK
	 * @param password string to be checked for validity
	 * @return true if valid password (follows all rules from above), false if an invalid password
	 * @throws LengthException thrown if length is less than 6 characters
	 * @throws NoUpperAlphaException thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException thrown if no lowercase alphabetic
	 * @throws NoDigitException thrown if no digit
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter requirement
	 * @throws InvalidSequenceException thrown if more than 2 of same character.
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		try {
			isValidLength(password);
		}
		catch (LengthException le) {
			throw new LengthException(le.getMessage());
		}
		try {
			hasUpperAlpha(password);
		}
		catch (NoUpperAlphaException nuae) {
			throw new NoUpperAlphaException(nuae.getMessage());
		}
		try {
			hasLowerAlpha(password);
		}
		catch (NoLowerAlphaException nlae) {
			throw new NoLowerAlphaException(nlae.getMessage());

		}
		try {
			hasDigit(password);
		}
		catch (NoDigitException nde) {
			throw new NoDigitException(nde.getMessage());
		}
		try {
			hasSpecialChar(password);
		} 
		catch (NoSpecialCharacterException nsce) {
			throw new NoSpecialCharacterException(nsce.getMessage());

		}
		try {
			NoSameCharInSequence(password);

		}
		catch (InvalidSequenceException ise) {
			throw new InvalidSequenceException(ise.getMessage());

		}
		return true;
		
	}
	
	/**
	 * checks if the password contains 6 to 9 characters
	 * @param password password string to be checked for
	 * @return true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		final int MAXIMUM = 9;
		final int MINIMUM = 6;
		//If the length of the password String is less than or equal to 9, and greater than or equal to 6, return true.
		if (password.length() <= MAXIMUM && password.length() >= MINIMUM) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param password string to be checked if weak password
	 * @return false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	 * @throws WeakPasswordException if length of password is between 6 and 9 (inclusive), ALTHOUGH the password may be VALID.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		final int MAXIMUM = 9;
		final int MINIMUM = 6;
		try {
			//If the length of the password String is less than or equal to 9, and greater than or equal to 6 and if calling 
			//the isValidPassword method returns true then WeakPasswordException will be thrown with message.
			if(password.length() <= MAXIMUM && password.length() >= MINIMUM && isValidPassword(password) ) {
				throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
			}

		}
		catch(WeakPasswordException wpe) {
			throw new WeakPasswordException(wpe.getMessage());
		}
		catch(Exception e) {
			e.getMessage();
		}
		return false;
	}
		
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the
	 * status of any invalid passwords (weak passwords are not considered invalid). The ArrayList of invalid
	 * passwords will be of the following format: password BLANK message of the exception thrown
	 * @param passwords list of passwords
	 * @return of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) { 
		//Use an ArrayList to copy the invalid passwords form the file.
		ArrayList <String> invalidPasswords = new ArrayList<>();
		//Enhanced for loop to run every invalid password in the ArrayList through the isValidPassword method.
		for (String p : passwords) {
			
			try {
				isValidPassword(p);
			} 
			catch (Exception e) {
				invalidPasswords.add(p + " -> " + e.getMessage());
			}
			System.out.println(passwords);
		}
		return invalidPasswords;
	}
	
}
