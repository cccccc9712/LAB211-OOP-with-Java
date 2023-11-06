
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Deque;
import java.util.PriorityQueue;

public class Graph {

    Set<Vertex> vertices = new HashSet<>();

    public Graph() {
    }

    public void addVertex(String label) {
        vertices.add(new Vertex(label));
    }

    public Vertex getVertex(String label) {
        return this.vertices.stream().filter(vertex -> vertex.label.equals(label)).findFirst().get();
    }

    public void addEdge(String srcLabel, String destLabel, int weight) {
        Vertex src = this.getVertex(srcLabel);
        src.adjList.put(this.getVertex(destLabel), weight);
    }

    public void display() {
        for (Vertex vt : vertices) {
            System.out.print(vt.label + " -> ");
            vt.adjList.entrySet().stream().forEach(entry -> System.out.print("(" + entry.getKey().label + ", " + entry.getValue() + ")"));
            System.out.println();
        }
    }

    public void BFS(String startLabel) {
        Set<Vertex> visited = new HashSet<>();
        Deque<Vertex> queue = new ArrayDeque<>(1000);
        Vertex startVertex = this.getVertex(startLabel);

        if (startVertex == null) {
            System.out.println("Start vertex not found.");
            return;
        }

        queue.addLast(startVertex);

        while (!queue.isEmpty()) {
            Vertex pop = queue.removeFirst();

            if (!visited.contains(pop)) {
                System.out.print(pop.label + " ");

                // Get adjacent vertices and add them to the queue
                for (Vertex adjVertex : pop.adjList.keySet()) {
                    if (!visited.contains(adjVertex)) {
                        queue.addLast(adjVertex);
                    }
                }
            }
            visited.add(pop);
        }
    }

    public void dijkstra(String startLabel, String targetLabel) {
        Vertex startVertex = this.getVertex(startLabel);
        Vertex targetVertex = this.getVertex(targetLabel);

        if (startVertex == null || targetVertex == null) {
            System.out.println("Start or target vertex not found.");
            return;
        }

        List<Vertex> visited = new ArrayList<>();
        HashMap<Vertex, Integer> distanceToVertex = new HashMap<>();
        this.vertices.forEach(vertex -> distanceToVertex.put(vertex, Integer.MAX_VALUE));

        distanceToVertex.put(startVertex, 0);

        HashMap<Vertex, Vertex> previous = new HashMap<>();

        Deque<Vertex> queue = new ArrayDeque<>();
        queue.addLast(startVertex);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.removeFirst();

            if (visited.contains(currentVertex)) {
                continue; 
            }

            visited.add(currentVertex);

            for (Vertex adj : currentVertex.adjList.keySet()) {
                int totalDistance = currentVertex.adjList.get(adj) + distanceToVertex.get(currentVertex);

                if (totalDistance < distanceToVertex.get(adj)) {
                    distanceToVertex.put(adj, totalDistance);
                    previous.put(adj, currentVertex);
                    queue.addLast(adj);
                }
            }
        }

        if (!visited.contains(targetVertex)) {
            System.out.println("Target vertex is not reachable from the start vertex.");
            return;
        }

        List<Vertex> shortestPath = new ArrayList<>();
        Vertex current = targetVertex;
        while (!current.equals(startVertex)) {
            shortestPath.add(current);
            current = previous.get(current);
        }
        shortestPath.add(startVertex);

        Collections.reverse(shortestPath);

        System.out.println("Shortest path from " + startLabel + " to " + targetLabel + ": ");
        for (Vertex vertex : shortestPath) {
            System.out.print(vertex.label + " ");
        }
        System.out.println("\nShortest distance: " + distanceToVertex.get(targetVertex));
    }

//    public Graph printMST(Graph graph) {
//        Graph mst = new Graph();
//        Set<Vertex> visited = new HashSet<>();
//        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
//        
//        Vertex startVertex = graph.vertices.iterator().next();
//        visited.add(startVertex);
//        startVertex.
//    }
    
//    public Graph printDFS(){
//        
//    }
    
    public List<String> checkEuler(Graph graph) {
        List<String> startingVertices = new ArrayList<>();
        List<String> startVerticePath = new ArrayList<>();
        
        int oddDegreeCount = 0;
        for(Vertex vertex : graph.vertices){
            startingVertices.add(vertex.label);
            if(vertex.adjList.size() %2 !=0){
                oddDegreeCount++;
                startVerticePath.add(vertex.label);
            }
        }
        if(oddDegreeCount == 0){
            return startingVertices;
        }else if(oddDegreeCount == 2){
            return startVerticePath;
        }else{
            return new ArrayList<>();
        }
}


}
