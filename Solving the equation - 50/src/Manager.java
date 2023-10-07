
public class Manager {

    public static int menu() {
        System.out.print("========= Equation Program =========\n"
                + "1. Caculate Superlative Equation\n"
                + "2. Caculate Quadratic Equation\n"
                + "3. Exit\n"
                + "Please choose an option: ");

        int choice = Checker.checkInputIntLimit(1, 3);
        return choice;
    }

    public static void caculateSuperlative() {
        System.out.println("----- Caculate Equation -----");
        System.out.println("Please input number.");
        System.out.print("Enter A: ");
        double a = Checker.checkInputDouble();
        System.out.print("Enter B: ");
        double b = Checker.checkInputDouble();
        if (b > 0) {
            System.out.println(a + "x" + " + " + b + " = 0");
        } else {
            System.out.println(a + "x" + " " + b + " = 0");
        }
        double x = -b / a;
        System.out.println("Solution: x= " + x);

        System.out.print("Number is odd: ");
        if (isOdd(a)) {
            System.out.print(a + " ");
        }
        if (isOdd(b)) {
            System.out.print(b + " ");
        }
        if (isOdd(x)) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("Number is even: ");
        if (isEven(a)) {
            System.out.print(a + " ");
        }
        if (isEven(b)) {
            System.out.print(b + " ");
        }
        if (isEven(x)) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        if (isPerfectSquare(a)) {
            System.out.print(a + " ");
        }
        if (isPerfectSquare(b)) {
            System.out.print(b + " ");
        }
        if (isPerfectSquare(x)) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void caculateQuadratic() {
        System.out.println("----- Caculate Quadratic Equation -----");
        System.out.println("Please input number.");
        System.out.print("Enter A: ");
        double a = Checker.checkInputDouble();
        System.out.print("Enter B: ");
        double b = Checker.checkInputDouble();
        System.out.print("Enter C: ");
        double c = Checker.checkInputDouble();
        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        System.out.print("Number is odd: ");
        if (isOdd(a)) {
            System.out.print(a + " ");
        }
        if (isOdd(b)) {
            System.out.print(b + " ");
        }
        if (isOdd(c)) {
            System.out.print(c + " ");
        }
        if (isOdd(x1)) {
            System.out.print(x1 + " ");
        }
        if (isOdd(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
        System.out.print("Number is even: ");
        if (isEven(a)) {
            System.out.print(a + " ");
        }
        if (isEven(b)) {
            System.out.print(b + " ");
        }
        if (isEven(c)) {
            System.out.print(b + " ");
        }
        if (isEven(x1)) {
            System.out.print(x1 + " ");
        }
        if (isEven(x2)) {
            System.out.print(x1 + " ");
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        if (isPerfectSquare(a)) {
            System.out.print(a + " ");
        }
        if (isPerfectSquare(b)) {
            System.out.print(b + " ");
        }
        if (isPerfectSquare(c)) {
            System.out.print(c + " ");
        }
        if (isPerfectSquare(x1)) {
            System.out.print(x1 + " ");
        }
        if (isPerfectSquare(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
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
