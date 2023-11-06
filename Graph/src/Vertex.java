
import java.util.HashMap;
import java.util.Map;


public class Vertex {

    String label;
    
    HashMap<Vertex, Integer> adjList = new HashMap<>();

    public Vertex() {
    }

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<Vertex, Integer> getVertexMap() {
        return adjList;
    }

    public void setVertexMap(HashMap<Vertex, Integer> adjList) {
        this.adjList = adjList;
    }
    
    
}
