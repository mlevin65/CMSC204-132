/*
 * Class: CMSC204 
 * Instructor: Prof. Kuijt
 * Description: Write a program that creates a database of courses.  
 * It will either read from a file of courses or allow the user to add one course at a time. 
 * Due: 11/6/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Miles Levine
*/


import java.io.IOException;
import java.util.*;

/**
 * @author Miles Levine
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	protected int size;
	//implementing the hash table
	protected LinkedList<CourseDBElement> hashTable[];
	private final double LOAD_FACTOR = 1.5;
	
	
	/**
	 * Default constructor
	 * @param size
	 */
	public CourseDBStructure(int n) {
		//divide by the size factor
		int sizeFactor = (int) (n / LOAD_FACTOR);
		//see if it is a 4k+3 prime
		size = is4kPlus3Prime(sizeFactor);
		//System.out.println(size);
		hashTable = new LinkedList[size];
		
	}

	/**
	 * Constructor used for testing
	 * @param testing
	 * @param size
	 */
	public CourseDBStructure(String testing, int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		//convert crn to string
		String str = "" + crn;
		int index = str.hashCode() % size;
		if(hashTable[index] == null) {
			throw new IOException();
		}
		else {
			for(int i = 0; i < size; i++) {
				CourseDBElement temp = hashTable[index].get(i);
				if(temp.getCRN() == crn) {
					return temp;
				}
			}
			return null;
		}
	}
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) {
		String str = Integer.toString(element.getCRN());
		//finding the index
		int index = str.hashCode() % size;
		hashTable[index] = new LinkedList<CourseDBElement>();
		//adding the index
		hashTable[index].add(element);
	}
	
	/**
	 * @return size of the hash table
	 */
	@Override
	public int getTableSize() {
		return size;
	}
	
	/**
	 * method to see if the number that is passed is a prime number
	 * @param n
	 * @return true if it is a prime 
	 */
	public boolean isPrime (int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * method to find if the prime number is a 4k+3 prime
	 * @param n
	 * @return returns the next 4k+3 prime number
	 */
	public int is4kPlus3Prime (int n) {
		boolean isTrue = false;
		int num;
		//System.out.println(n);

		while (isTrue == false) {
			if (isPrime(n) == false) {
				n++;
				continue;
			}
			num = (n - 3) % 4;
			if (num == 0) {
				isTrue = true;
				
			}
			else {
			n++;
			}
			
		}
//		System.out.println(n);
		return n;	
	}
	
	/**
	 * showAll method
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> arrList = new ArrayList<String>();
		LinkedList<CourseDBElement> linkList;

		for (int i = 0; i < size; i++) {
			linkList = hashTable[i];
			if (linkList != null) {
				for (int j = 0; j < linkList.size(); j++) {
					CourseDBElement element = (CourseDBElement) linkList.get(j);
					arrList.add(element.toString());
					}
			}
		}
		return arrList;
	}

}