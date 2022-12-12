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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author Miles Levine
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph;
	
	public TownGraphManager() {
		this.graph = new Graph();
	}
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		boolean bool = true;
		//calling the addVertex method in graph class to add a new town.
		if(graph.addVertex(new Town(v))) { //if method returns true then return true
			return bool;
		}
		else {
			bool = false;
			return bool;
		}
	}
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param name name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int degrees, String name) {
		boolean bool = true;
		//calling the addEdge method in the graph class to add a new road
		if (graph.addEdge(new Town(town1), new Town(town2), degrees, name) != null) {
			return bool;
		}
		else {
			bool = false;
			return bool;
		}
	}
	
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		String str;
		Road road = graph.getEdge(new Town(town1), new Town(town2));
		if (road == null) { //checks to see if the road exists
			return null;
		}
		str = road.getName();
		return str;
	}
	
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Town vertex = null;//default
		//loop through the vertex set to get the town
		for (Town town : graph.vertexSet()) {
			if (town.getName().equals(name)) {
				vertex = town;
			}
		}
		return vertex;
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		boolean bool = true;
		//copying
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		//calling the containsEdge method in the graph class to determine if the road is in the graph
		if (graph.containsEdge(t1, t2)) {
			return bool;
		}
		else {
			bool = false;
			return bool;
		}
	}
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		boolean bool = true;
		//calling the containsVertex method in the graph class to determine if the town is in the graph
		if (graph.containsVertex(new Town(v))) {
			return bool;
		}
		else {
			bool = false;
			return bool;
		}
	}
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> list = new ArrayList<>();
		//loops through the edge set 
		for (Road road : graph.edgeSet()) {
			if (!list.contains(road.getName())) {
				list.add(road.getName());
			}
		}
		//sorting the list
		Collections.sort(list);
		return list;
	}
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		boolean bool = true;
		//calling the removeVertex method in the graph class to remove the town
		if (graph.removeVertex(new Town(v))) {
			return bool;
		}
		else {
			bool = false;
			return bool;
		}
	}
	
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		boolean bool = true;
		//copying
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		//setting the connection
		Road connection = graph.getEdge(t1, t2);
		if(connection == null) {
			bool = false;
			return bool;
		}
		else {
			// deleting the road connection by using the removeEdge method in graph class
			graph.removeEdge(t1, t2, connection.getDegrees(), road);
			return bool;
		}
	}
	
	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		//creating a new set to copy the vertex set
		Set<Town> townsSet = graph.vertexSet();
		ArrayList<String> list = new ArrayList<String>();
		//looping through the set
		for(Town town: townsSet) {
			list.add(town.getName());
		}
		//sorting the list
		Collections.sort(list);
		return list;
	}
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		ArrayList<String> list = new ArrayList<String>();
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		if((graph.containsVertex(t1) && graph.containsVertex(t2)) 
				&& (!graph.edgesOf(t1).isEmpty() && !graph.edgesOf(t2).isEmpty())) {
			list = graph.shortestPath(t1, t2);
			if(list == null) {//if no path
				return null;
			}
			else {
				return list;
			}
		}
		return new ArrayList<String>();
	}
	
	/**
	 * @param selectedFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {

	}

}