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

import java.util.*;

/**
 * @author Miles Levine
 *
 */
public class CourseDBElement implements Comparable{
	private String id, instructor, roomNumber;
	private int crn, numCredits;
	
	/**
	 * Default Constructor
	 */
	public CourseDBElement() {
		id = "";
		crn = 0;
		numCredits = 0;
		roomNumber = "";
		instructor = "";
	}
	
	/**
	 * Constructor that sets up the variables with its parameters.
	 * @param id
	 * @param crn
	 * @param numCredits
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String id, int crn, int numCredits, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.numCredits = numCredits;
		this.roomNumber = roomNum;
		this.instructor = instructor;
	
	}
	
	/**
	 * Compares this object with the specified object for order.
	 * @param x the object to be compared
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(CourseDBElement x) {
		return (this.crn - x.crn);
	
	}
	
	@Override
	public int hashCode() {		
		int result = 31 + crn;
		return result;
		
	}
	
	//Getters
	/**
	 * Gets the CRN
	 * @return crn
	 */
	public int getCRN() {
		return crn;
	}
	
	/**
	 * Gets the ID
	 * @return
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Gets the room number
	 * @return
	 */
	public String getRoomNum() {
		return roomNumber;
	}
	
	/**
	 * Gets the instructor's name
	 * @return
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
	 * gets the number of credits
	 * @return
	 */
	public int getNumCredits() {
		return numCredits;
	}
	
	//Setters
	
	/**
	 * Sets CRN
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * Sets ID
	 * @param id
	 */
	public void setID(String id) {
		this.id = id;
	}
	
	/**
	 * Sets the Room number
	 * @param roomNum
	 */
	public void setRoomNum(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	/**
	 * Sets the Instructor's name
	 * @param instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * Sets the number of credits
	 * @param numCredits
	 */
	public void setNumCredits(int numCredits){
		this.numCredits = numCredits;
	}

	/**
	 * toString method
	 * @return a string with the proper format that is needed
	 */
	@Override
	public String toString() {
		String str = ("\nCourse:" + id + " CRN:" + crn + " Credits:" + numCredits
		+ " Instructor:" + instructor + " Room:" + roomNumber);
		return str;
	}
	
}