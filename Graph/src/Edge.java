public class Edge {
    Vertex vertexFrom;
    Vertex vertexTo;
    int weight;

    public Edge() {
    }

    public Edge(Vertex vertexFrom, Vertex vertexTo, int weight) {
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
        this.weight = weight;
    }

    public Vertex getVertexFrom() {
        return vertexFrom;
    }

    public void setVertexFrom(Vertex vertexFrom) {
        this.vertexFrom = vertexFrom;
    }

    public Vertex getVertexTo() {
        return vertexTo;
    }

    public void setVertexTo(Vertex vertexTo) {
        this.vertexTo = vertexTo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
    
}
