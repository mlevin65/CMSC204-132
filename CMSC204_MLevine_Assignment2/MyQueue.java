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
import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.Node;

import java.util.*;

/**
 * @author Miles Levine
 *
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface <T>{
	
	/**
	 * int size - holds the default size
	 * ArrayList<T> queue
	 */
	private int size;
	private ArrayList<T> queue; //implementation of an queue using ArrayList

	
	
	public MyQueue() {
		queue = new ArrayList<>();
		size = 20; //default size
		
	}
	
	public MyQueue(int size) {
		queue = new ArrayList<>(size);
		this.size = size;
		
	}

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		//uses the isEmpty method to check if the ArrayList is empty
		if (queue.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		//If the ArrayList size is equal to the default size set in the constructor, then return true
		if (queue.size() == size) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		//return size of the ArrayList
		int x = queue.size();
		return x;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		boolean bool;
		//if the size of the queue is equal to the default size then throw the overflow exception
		if (isFull()) {
			bool = false;
			throw new QueueOverflowException();	
			}
		else {
		//adds the element to the end of the queue

			queue.add(e);
		bool = true;
		}
		return bool;
	
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if(queue.isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		//set a generic type to the queue at 0
		T generic = queue.get(0);
		//remove that value
		queue.remove(0);
		//queue.trimToSize();
		//queue.ensureCapacity(size);
		return generic;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		
		String str = "";
		//converts the elements of the queue into String format
		for(T index : queue) {
			str += index.toString(); 
		}
		//return the converted String
		return str;
		
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		//for loop that places the delimiter in between all elements of the queue
		for(T index : queue) {
			str += index.toString();
			str += delimiter; 
		}

		str = str.substring(0, str.length() - 1);

		return str;
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
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
			queue.add(index);
		}
	}
}