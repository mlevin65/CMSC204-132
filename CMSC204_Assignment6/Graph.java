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
public class Graph implements GraphInterface<Town, Road> {
	private Set<Town> towns;
	private Set<Road> roads;
	private Map<String, Town> pastTown; //map with the string as the name and town as the town

	public Graph() { //copying
		this.towns = new HashSet<>();
		this.roads = new HashSet<>();
		this.pastTown = new HashMap<>();
	}
	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road r = null;
		//loops through the roads
		for (Road edges : roads) {
			if ((sourceVertex.equals(edges.getTown1()) || sourceVertex.equals(edges.getTown2()))
					&& (destinationVertex.equals(edges.getTown2()) || destinationVertex.equals(edges.getTown1()))) {
				return edges;
			}
		}
		return r;
	}
	
    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) throws NullPointerException {
		boolean bool = true;
		//if the town is null throw exception
		if (v == null) {
			throw new NullPointerException();
		}
		//adding the town
		towns.add(v);
		if (containsVertex(v)) {
			bool = false;
			return bool;
		}
		return bool;
	}
	
	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException, NullPointerException {
		//if the towns are not connected throw exception
		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		 //if the road is null throw exception
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		//creating a new road to add the the graph
		Road road = new Road(sourceVertex, destinationVertex, weight, description); 
		roads.add(road);
		
		return road;
	}
	
    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		boolean bool = true;
		//loops through the towns
		for (Town t : towns) {
			//checks to see if the graph contains the town
			if (t.equals(v)) { 
				return bool;
			}
		}
		bool = false;
		return bool;
	}
	
    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		boolean bool = true;
		//loops through the edges
		for (Road r : roads) {
			if ((sourceVertex.equals(r.getTown1()) || sourceVertex.equals(r.getTown2())) 
					&& (destinationVertex.equals(r.getTown2()) || destinationVertex.equals(r.getTown1()))) {
				return bool;
			}
		}
		bool = false;
		return bool;
	}
	
    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) throws NullPointerException, IllegalArgumentException {
		Set<Road> result = new HashSet<>();
		//if the town is null throw exception
		if (vertex == null) {
			throw new NullPointerException();
		}
		//if the town doesn't exist in the graph throw exception
		if (!containsVertex(vertex)) {
			throw new IllegalArgumentException();
		}
		//loops through the roads
		for (Road road : roads) {
			//if the roads have the same towns then adds them to the set
			if (road.getTown1().equals(vertex) || road.getTown2().equals(vertex)) {
				result.add(road);
			}
		}
		return result;
	}
	
    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		boolean bool = true;
		Town town = null;
		//loops through the towns
		for (Town t : towns) {
			//checks if the towns are the same
			if (t.equals(v)) {
				town = t;
			}
		}
		if (town != null) {
			//delete the specified town
			towns.remove(town);
			return bool;
		}
		else {
			bool = false;
			return bool;
		}
	}
	
    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road roadDeleted = new Road(sourceVertex, destinationVertex, weight, description);
		Iterator<Road> i = roads.iterator();
		Road current;

		//loop that goes through the road set to find road that needs to be deleted
		while(i.hasNext()) {
			current = i.next();
			//If roads have the same towns
			if(current.equals(roadDeleted)) {
				
				//If the weights are equal
				if((weight == current.getDegrees())) {

					//If the names are the same
					if((description.equals(current.getName()))) {
						//deleting the current road
						roads.remove(current);
						return current;
					}
				}
			}
		}
		return null;
	}
	
    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		return towns;
	}
	
    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		return roads;
	}
	
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */  
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		ArrayList<String> shortPath = new ArrayList<>();
		//call the algorithm to find the shortest path
		dijkstraShortestPath(sourceVertex);
		Town town;
		town = destinationVertex;
		//loops until the town is equal to the source vertex
		while (!town.equals(sourceVertex)) {
			if (!pastTown.containsKey(town.getName())) {
				shortPath.clear();
			}
			else {
				Town t = pastTown.get(town.getName());
				Road r = getEdge(t, town);
				//adding the pathway
				shortPath.add(0, t.getName() + " via " + r.getName() + " to " + town.getName() + " " + r.getDegrees() + " mi");
				town = t;
			}
		}
		return shortPath;
	}
	
    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Set<Town> traveled = new HashSet<>(); //pathways that has been traversed
		List<Town> newTown = new ArrayList<>(); //towns that haven't been visited
		HashMap<String, Integer> weight = new HashMap<>();
		//clear from previous use
		pastTown.clear();
		
		//loop that goes through the towns
		for (Town town : towns) {
			newTown.add(town);
			weight.put(town.getName(), Integer.MAX_VALUE);
			pastTown.put(town.getName(), null);
		}
		
		weight.put(sourceVertex.getName(), 0);
		//loop that goes through the new towns until there are non left
		while (!newTown.isEmpty()) {
			int lowestWeight = 0;

			for (int index = 1; index < newTown.size(); index++) {
				Town unvisitedVertex = newTown.get(index);
				//picking the best path according to the algorithm
				if (weight.get(unvisitedVertex.getName()) < weight.get(newTown.get(lowestWeight).getName())) {
					lowestWeight = index;
				}
			}
			
			//deleting the lowest weight vertices and storing them in the traveled vertices
			Town lowestWeightVertex = newTown.remove(lowestWeight);
			traveled.add(lowestWeightVertex);
			
			//finding the total distance from the chosen vertex to unvisited vertex
			//loop that goes through the pathway
			for (Road road : edgesOf(lowestWeightVertex)) {
				Town nextTown = road.getTown2();
				
				if (nextTown.equals(lowestWeightVertex)) {
					nextTown = road.getTown1();
				}
				
				int adjacentWeight = weight.get(lowestWeightVertex.getName()) + road.getDegrees();
				
				//replace the nextTown with the better weighted town
				if (adjacentWeight < weight.get(nextTown.getName())) {
					//replacing
					weight.put(nextTown.getName(), adjacentWeight);
					pastTown.put(nextTown.getName(), lowestWeightVertex);
					
				}
			}
		}
	}
	
}
