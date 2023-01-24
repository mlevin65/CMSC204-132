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

import java.util.*;

/**
 * @author Miles Levine
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	Comparator<T> comp = null;
	
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param compareableObject Comparator to compare data elements
	 */
	public SortedDoubleLinkedList (Comparator<T> compareableObject ) {
		comp = compareableObject;
	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * @param data - the data for the Node within the linked list
	 * @return 
	 */
	@Override
	public void addToFront(T data) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * @param data - the data for the Node within the linked list
	 * @return 
	 */
	@Override
	public void addToEnd(T data) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * @param data
	 */
	public void add(T data) {
		//create a new node
		Node node = new Node(data, null, null);
		//if list is empty tail and head are set to node value
		if (size == 0) {
			tail = node;
			head = node;
		}
		//compares the data to the tail data to see if data is greater than the tail data
		else if (comp.compare(data, tail.data) > 0) {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
		//compares the data to the head data to see if data is less than the head data
		else if (comp.compare(data, head.data) < 0) {
			node.next = head;
			head.prev = node;
			head = node;
		}
		else {
			Node curr = head.next;
			while (curr.next != null && comp.compare(data, curr.data) > 0) {
				curr = curr.next;
			}
			node.next = curr;
			node.prev = curr.prev;
			curr.prev.next = node;
			curr.prev = node;
		}
		//increase the size of the list
		size++;
		
	}
	
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @param data - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the data or null
	 */
	@Override
	public Node remove(T data, Comparator<T> comparator) {
		//calls the super class to use the method
		return super.remove(data, comparator);

	}
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @return an iterator positioned at the head of the list
	 */
	@Override
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
}