
import java.util.Scanner;


public class Checker {
    
    private static Scanner sc = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                    
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be a double!");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static boolean isEven(double number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(double number) {
        return number % 2 != 0;
    }

    public static boolean isPerfectSquare(double number) {
        if (number < 0) {
            return false;
        }

        double sqrt = Math.sqrt(number);

        return sqrt * sqrt == number;
    }
}
