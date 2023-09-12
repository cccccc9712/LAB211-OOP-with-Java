
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            Manager.mennu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Manager.normalCalculator();
                    break;
                case 2:
                    Manager.BMICalculator();
                    break;
                case 3:
                    return;
            }
        }

    }

}
