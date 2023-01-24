/*
 * Class: CMSC204 
 * Instructor: Prof. Kuijt
 * Description: You will be creating a utility class that converts an infix 
 * expression to a postfix expression, a postfix expression to an infix 
 * expression and evaluates a postfix expression.
 * Due: 10/2/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Miles Levine
*/
public class InvalidNotationFormatException extends RuntimeException {
	
	InvalidNotationFormatException() {
		super("Notation format is incorrect");
	}
}