/*
 * Class: CMSC204 
 * Instructor: Prof. Kuijt
 * Description: Write a generic double-linked list class with an iterator, 
   and a generic sorted double-linked list class with an iterator that inherits 
   from your generic double-linked list class. 
 * Due: 10/18/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Miles Levine
*/

/**
 * @author Miles Levine
 *
 */
public class UnsupportedOperationException extends RuntimeException {
	UnsupportedOperationException() {
		super("Invalid operation for sorted list");
	}
}
