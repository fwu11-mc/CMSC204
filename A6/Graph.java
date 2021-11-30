import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{

	Set<Town> townSet = new HashSet<>();
	Set<Road> roadSet = new HashSet<>();
    private ArrayList<String> shortestPath = new ArrayList<>();
    private Town destination;
	
    
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
        Road road = null;
        for (Road road1 : roadSet) {
            if (road1.contains(sourceVertex) && road1.contains(destinationVertex)) {
                road = road1;
            }
        }
        return road;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}

		if (!townSet.contains(sourceVertex) || !townSet.contains(destinationVertex)) {
			throw new IllegalArgumentException();
		}

        Road road = new Road(sourceVertex, destinationVertex, weight, description);
        roadSet.add(road);

        return road;
	}

	@Override
	public boolean addVertex(Town v) {
        if (v == null) {
            throw new NullPointerException();
        }

        if (!townSet.contains(v)) {
            townSet.add(v);
            return true;
        }

        return false;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        for (Road r : roadSet) {
            if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean containsVertex(Town v) {
        return townSet.contains(v);
	}

	@Override
	public Set<Road> edgeSet() {
		return roadSet;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> e = new HashSet<>();
		for (Road road : roadSet) {
			if (road.contains(vertex)) {
				e.add(road);
			}
		}
		return e;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        if (sourceVertex == null || destinationVertex == null || description == null) {
            throw new NullPointerException();
        }

        if (!townSet.contains(sourceVertex) || !townSet.contains(destinationVertex)) {
            throw new IllegalArgumentException();
        }

        Road road = null;
        for (Road r : roadSet) {
            if (r.contains(sourceVertex) && r.contains(destinationVertex) &&
                    r.getWeight() == weight && r.getName().equals(description)) {
                road = r;
            }
        }
        return roadSet.remove(road) ? road : null;
	}

	@Override
	public boolean removeVertex(Town v) {
		return townSet.remove(v);
	}

	@Override
	public Set<Town> vertexSet() {
		return townSet;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        String shortPath = "";
        int inMile = 0;
        destination = destinationVertex;
        dijkstraShortestPath(sourceVertex);


        for (int i = 0; i < shortestPath.size() - 1; i++) {
            Town source = new Town(shortestPath.get(i));
            Town d = new Town(shortestPath.get(i + 1));
            Road r = getEdge(source, d);
            inMile += r.getWeight();
            shortPath += source + " via " + r.getName() + " to " + d
                    + " " + r.getWeight() + " mi;";
        }
        
        shortestPath.clear();
        
        for (String step : shortPath.split(";")) {
            shortestPath.add(step);
        }
        shortestPath.add("Total miles: " + inMile + " mi");
        
        return shortestPath;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
    	int[][] adjMatrix = new int[townSet.size()][townSet.size()];
		Town[] twn = new Town[townSet.size()];
		int size = 0;
		for (Town town : townSet) {
			twn[size] = new Town(town);
			size++;
		}

		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				if (i == j || !containsEdge(twn[i], twn[j])) {
					adjMatrix[i][j] = 0;
				} else {
					int weight = getEdge(twn[i], twn[j]).getWeight();
					adjMatrix[i][j] = adjMatrix[j][i] = weight;
				}
			}
		}
	}

}
