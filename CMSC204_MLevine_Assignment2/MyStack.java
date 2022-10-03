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

import java.util.ArrayList;

/**
 * @author Miles Levine
 *
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T>{
	
	/**
	 * int size - holds the default size
	 * ArrayList<T> queue
	 */
	private ArrayList<T> stack; //ArrayList implementation of a stack
	private int size; 

	public MyStack() {
		stack = new ArrayList<>();
		//setting default size to 20
		size = 20; 
		
	}
	
	public MyStack(int size) {
		stack = new ArrayList<>(size);
		this.size = size;
		
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		//Uses the isEmpty method to check if the ArrayList is empty
		if (stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		//If the ArrayList size is equal to the default size set in the constructor, then return true
		if (stack.size() == size) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		//return size of the ArrayList
		int x = stack.size();
		return x;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param i the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T i) throws StackOverflowException {
		//if the size of the stack is equal to the default size then throw an overflow exception
		if (stack.size() == size) {
			throw new StackOverflowException();
		}
		//adding an element to the top of the stack
		stack.add(i);
		
		return true;
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException{
		//if the stack size is empty then throw the underflow exception
		if (stack.size() == 0) {
			throw new StackUnderflowException();
		}
		//gets the element at the top of the stack
		T generic = stack.get(stack.size() - 1);
		return generic;
	}
	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		//if the stack size is empty then throw the underflow exception
		if(stack.size() == 0) {
			throw new StackUnderflowException();
		}
		T generic = stack.get(stack.size() - 1);
		//delete the element at the top of the stack
		stack.remove(stack.size() - 1);
		//return that deleted element
		return generic;
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String str = "";
		//converts the elements of the stack into String format
		for(T index: stack) {
			str += index.toString(); 
		}
		//return the converted String
		return str;
		
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		//for loop that places the delimiter in between all elements of the queue
		for(T index: stack) {
			str += index.toString();
			str += delimiter;
		}
		str = str.substring(0, str.length() - 1);
		
		return str;
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList<T> list) {
		//deep copy of the ArrayList
		ArrayList<T> copy = new ArrayList<>(list.size());
		for (T i : list) {
			copy.add(i);
		}
		//fills the queue with the elements of the copied ArrayList.
		for (T index : copy) {
			stack.add(index);
		}
	}
		
}
