/**
 *
 * @author tmtmt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle rectangle = Manager.inputRectangle();
        Circle circle = Manager.inputCircle();
        Triangle trigle = Manager.inputTriangle();
        System.out.println("-----Shape caculator-----");
        Manager.display(trigle, rectangle, circle);
    }

}
