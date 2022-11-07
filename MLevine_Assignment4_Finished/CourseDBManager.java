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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Miles Levine
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	
	private CourseDBStructure structure = new CourseDBStructure(13);
	
	/**
	 * finds CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		} catch (IOException e) {
			e.getMessage();
			return null;
		}
	}
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(newElement);
	}
	
	/**
	 * showAll method
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 */
	@Override
	public ArrayList<String> showAll() {
		return structure.showAll();
	}
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
			//makes a new scanner to see when the file does not have any new lines.
			Scanner fileData = new Scanner(input);
			while(fileData.hasNext()) {
				String id = fileData.next();
				int crn = fileData.nextInt();
				int numCredits = fileData.nextInt();
				String roomNum = fileData.next();
				String instructor = fileData.nextLine();
				//adds the new data that is in the file to the hash table
				add(id, crn, numCredits, roomNum, instructor);
			}
			fileData.close();
		}
		catch(FileNotFoundException e) {
			System.out.print("File not found");
			e.getMessage();
		}
	}
	
}