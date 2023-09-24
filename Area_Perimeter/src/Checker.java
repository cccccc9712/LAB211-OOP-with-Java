
import java.util.Scanner;

public class Checker {

    private static final Scanner sc = new Scanner(System.in);

    public static double checkInputPossitive() {
        while (true) {
            double result = Double.parseDouble(sc.nextLine());
            if (result >= 0) {
                return result;
            } else {
                System.out.println("Side of shape must be a possitive number!");
            }
        }
    }
}
