
/**
 *
 * @author tmtmt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true){
            int input = Manager.menu();
            switch(input){
                case 1: 
                    Manager.login();
                    break;
                case 2:
                    Manager.Register();
            }
        }
        
//        gr.addVertex("A");
//        gr.addVertex("B");
//        gr.addVertex("C");
//        gr.addVertex("D");
//        gr.addVertex("E");
//        gr.addVertex("F");
//        gr.addEdge("A", "B", 7);
//        gr.addEdge("B", "A", 7);
//        gr.addEdge("A", "C", 9);
//        gr.addEdge("C", "A", 9);
//        gr.addEdge("A", "F", 14);
//        gr.addEdge("F", "A", 14);
//        gr.addEdge("B", "C", 10);
//        gr.addEdge("C", "B", 10);
//        gr.addEdge("B", "D", 15);
//        gr.addEdge("D", "B", 15);
//        gr.addEdge("C", "D", 11);
//        gr.addEdge("D", "C", 11);
//        gr.addEdge("C", "F", 2);
//        gr.addEdge("F", "C", 2);
//        gr.addEdge("F", "E", 9);
//        gr.addEdge("E", "F", 9);
//        gr.addEdge("E", "D", 6);
//        gr.addEdge("D", "E", 6);
//        gr.display();
    }

}
