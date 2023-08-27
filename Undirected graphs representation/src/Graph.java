
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author tmtmt
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Graph graph = new Graph(6);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        
        System.out.println("Enter the start point:");
        int n = sc.nextInt();
        System.out.println("Enter the end point:");
        int m = sc.nextInt();
        
        if(graph.checkEdge(n, m)){
            System.out.println("This is an edge");
        } else{
            System.out.println("This is not an edge");
        }
    }
    
    private boolean adjacencyMatrix[][];
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }
    
    public void addEdge(int i, int j){
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true;
        }
    }
    
    public void removeEdge(int i, int j){
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            adjacencyMatrix[i][j] = false;
            adjacencyMatrix[j][i] = false;
        }
    }
    
    public boolean checkEdge(int i, int j){
        if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
            return adjacencyMatrix[i][j] || adjacencyMatrix[j][i];
        } else {
            return false;
        }
    }
}
