/*
 * Class: CMSC204 
 * Instructor: Prof. Kuijt
 * Description: In this project you will be creating an application to maintain a network 
 * of towns and the roads connecting them. The application will use Dijkstra’s Shortest Path 
 * algorithm to find the shortest distance between any two towns. 
 * Due: 12/11/2022
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
public class Town implements Comparable<Town> {
	private String name;
	private Town neighboringTowns;
	
	
	public Town(String name) {
		this.name = name;
	}
	
	public Town(Town templateTown){
		//copying
		this.neighboringTowns = templateTown;
	}
	
	/**
	 * Compare to method
	 * @return 0 if names are equal, a positive or negative number if the names are not equal
	 */
	public int compareTo(Town o){
		int x;
		x = name.compareTo(o.name);
		return x;
		
	}
	
	/**
	 * 
	 * @return true if the town names are equal, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		Town town = (Town) obj;
		if(this.name.compareTo(town.name) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Return the town's name
	 * @return town's name
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the hashcode for the name of the town
	 */
	@Override
	public int hashCode() {
		int x;
		x = name.hashCode();
		return x;
	}
}
