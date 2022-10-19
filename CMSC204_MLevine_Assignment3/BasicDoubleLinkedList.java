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

import java.util.NoSuchElementException;
import java.util.*;

/**
 * @author Miles Levine
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

	/**
	 * Adds element to the front of the list and updated the size of the list
	 * @param data
	 * @return
	 */
	public void addToFront(T data) {
		//creating a new node
		Node node = new Node(data, head, null);
		
		//if tail value is null then set tail to node value
		if (tail == null) {
			tail = node;
		}
		
		//if head is not null then the previous is the item of node
		if (head != null) {
			head.prev = node;
		}
		head = node;
		//increasing the size of the list
		size++;
	}
	
	/**
	 * Adds an element to the end of the list and updated the size of the list
	 * @param data
	 * @return
	 */
	public void addToEnd(T data) {
		//create a new node
		Node node = new Node(data, null, tail);
		//if the head value is null then set head equal to node item
		if (head == null) {
			head = node;
		}
		
		//if the tail is not null value then have the item of node stored into the next
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		
		//increasing the size of the list
		size++;
	}

	/**
	 * Removes the first instance of the targetData from the list.
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public Node remove(T targetData, Comparator<T> comparator) {
		//fields of type node
		Node previous = null;
		Node current = head;
		//loop until the current is equal to null
		while (current != null) {
			//if the current data is equal to the target data
			if (comparator.compare(current.data, targetData) == 0) {
				//if the current equals head then set current equal to the next head
				if (current == head) {
					current = head.next;
					head = head.next;
				}
				//if the current is equal to the tail then set current to null and set the tail to null
				else if (current == tail) {
					tail = previous;
					previous.next = null;
					current = null;
				}
				//else set the previous to the next current and set the current to the next
				else {
					previous.next = current.next;
					current = current.next;
				}
				//decreasing the size of the list
				size--;
				return current;
			}
			else {
				previous = current;
				current = current.next;
			}
		}
		
		return null;
	}
	
	/**
	 * Removes and returns the last element from the list.
	 * @return
	 */
	public T retrieveLastElement() {
		//if list is empty then throw exception
		if (head == null) {
			throw new NoSuchElementException();
			
		}
		//generic type field to store the data of tail
		T result = tail.data;
		tail = tail.prev;
		//decrease the size of the list
		size--;
		return result;
	}
	
	/**
	 * Removes and returns the first element from the list.
	 * @return
	 */
	public T retrieveFirstElement() {
		//if list is empty throw exception
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node node = head;
		head = head.next;
		head.prev = null;
		//decreasing the size of the list
		size--;
		return node.data;
	}
	
	/**
	 * This method returns an object of the DoubleLinkedListIterator. 
	 * (the inner class that implements java's ListIterator interface)
	 * @return a ListIterator object
	 */
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	
	/**
	 * Returns but does not remove the first element from the list.
	 * @return
	 */
	public T getFirst() {
		return head.data;
	}
	
	/**
	 * Returns the number of nodes in the list.
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Returns but does not remove the last element from the list.
	 * @return
	 */
	public T getLast() {
		return tail.data;
	}
	

	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return
	 */
	public ArrayList<T> toArrayList() {
		ListIterator<T> newIterator = new DoubleLinkedListIterator();
		ArrayList<T> newList = new ArrayList<T>();
		
		//loops through the list
		while (newIterator.hasNext()) {
			newList.add(newIterator.next());
		}
		return newList;
	}
	
	//DoubleLinkedListIterator inner class
	public class DoubleLinkedListIterator implements ListIterator<T> {
		//fields
		private Node curr;
		private Node last;
		
		//constructor
		public DoubleLinkedListIterator() {
			curr = head;
			last = null;
		}
		
		public T next() {
			//if current has null value then throw exception
			if(curr == null) {
				throw new NoSuchElementException();
			}
			else {
				T result = curr.data;
				last = curr;
				curr = curr.next;
				
				if(curr != null) { 
					curr.prev = last;
				}
				return result;
			}
		}
		
		public boolean hasNext() {
			return curr != null;
		}
		
		public T previous() {
			//if current has null value then throw exception
			if(last == null) {
				throw new NoSuchElementException();
			}
			else {
				curr = last;
				last = curr.prev;
				T result = curr.data;
				return result;
			}
		}
		
		public boolean hasPrevious() {
			return last != null;
		}
		
		public void set(T arg0) {
			curr.data = arg0;
		}
		//Override methods
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T arg0) {
			throw new UnsupportedOperationException();
			
		}
		
		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	//Node inner class
	protected class Node {
		protected T data;
		protected Node next;
		protected Node prev;
		
		//constructor
		protected Node(T item, Node next, Node prev) {
			this.data = item;
			this.next = next;
			this.prev = prev;
		}
	}
	//End of Node inner class
	
	//fields
	protected int size;
	protected Node head; 
	protected Node tail;
	
	//Default constructor
	public BasicDoubleLinkedList() {
		
		size = 0;
		head = tail = null;
		
	}
	
}