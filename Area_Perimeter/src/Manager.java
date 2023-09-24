public class Manager {
    
    static Triangle inputTriangle() {
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = Checker.checkInputPossitive();
            System.out.print("Please input side B of Triangle: ");
            double b = Checker.checkInputPossitive();
            System.out.print("Please input side C of Triangle: ");
            double c = Checker.checkInputPossitive();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }
    }
    
    static Rectangle inputRectangle() {
        System.out.print("Please input side width of Rectangle: ");
        double width = Checker.checkInputPossitive();
        System.out.print("Please input length of Rectangle: ");
        double length = Checker.checkInputPossitive();
        return new Rectangle(width, length);
    }

    static Circle inputCircle() {
        System.out.print("Please input radius of Circle: ");
        double radius = Checker.checkInputPossitive();
        return new Circle(radius);
    }
    
    static void display(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
}
