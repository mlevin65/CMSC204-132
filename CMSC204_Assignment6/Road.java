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
public class Road implements Comparable<Road> {
	private Town town1;
	private Town town2;
	private String name;
	private int degrees;
	
	
	public Road(Town source, Town destination, int degrees, String name) {
		this.town1 = source;
		this.town2 = destination;
		this.degrees = degrees;
		this.name = name;
	}
	
	public Road(Town source, Town destination, String name) {
		//making copies
		this.town1 = source;
		this.town2 = destination;
		this.name = name;
		this.degrees = 1;
	}
	
	/**
	 * @return 0 if the road names are the same, a positive or negative number if the road names are not the same
	 */
	public int compareTo(Road r){
		if (degrees > r.degrees) {
			return 1;
		}
		if (degrees < r.degrees) {
			return -1;
		}
		return 0;

	}
	
	/**
	 * Returns true only if the edge contains the given town
	 * @param town - a vertex of the graph
	 * @return true only if the edge if connected to the given vertex
	 */
	public boolean contains(Town town) {
		return (town1.compareTo(town) == 0 || town2.compareTo(town) == 0);

	}
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road. Remember that a road 
	 * that goes from point A to point B is the same as a road that goes from point B to point A.
	 * @param r road object to compare it to
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == this) {
			return true;
		}
		if (!(o instanceof Road)) {
			return false;
		}
		Road r = (Road) o;
		return (town1.equals(r.town1) || town1.equals(r.town2)) && (town2.equals(r.town2) || town2.equals(r.town1));
	}
	
	public int hashCode() {
		return getTown1().hashCode() + getTown2().hashCode();
	}
	
	
	//getters
	/**
	* Returns the first town on the road
	* @return A town on the road
	*/
	public Town getTown1() {
		return town1;
	}
	
	/**
	* Returns the second town on the road
	* @return A town on the road
	*/
	public Town getTown2() {
		return town2;
	}

	/**
	* Returns the road name
	* @return The name of the road
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Returns the distance of the road
	* @return the distance of the road
	*/
	public int getDegrees() {
		return degrees;
	}
	
	//setters
	public void setTown1(Town source) {
		this.town1 = source;
	}
	
	public void setTown2(Town destination) {
		this.town2 = destination;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDegrees(int weight) {
		this.degrees = weight;
	}

}