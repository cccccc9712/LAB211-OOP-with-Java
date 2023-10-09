/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class main {

    /**
     * @param args the command line arguments
     */
    private static double a, b, c;

    public static void main(String[] args) {
//        ptb2 pt2 = new ptb2(4, 4, 1);
//        System.out.println(pt2);

        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    caculatePTB1();
                    break;
                case 2:
                    caculatePTB2();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void caculatePTB1() {
        System.out.println("----- Caculate Equation -----");
        System.out.println("Please input number.");
        System.out.print("Enter A: ");
        a = Checker.checkInputDouble();
        System.out.print("Enter B: ");
        b = Checker.checkInputDouble();
        ptb1 pt1 = new ptb1(a, b);
        System.out.println(pt1);
    }

    public static void caculatePTB2() {
        System.out.println("----- Caculate Quadratic Equation -----");
        System.out.println("Please input number.");
        System.out.print("Enter A: ");
        a = Checker.checkInputDouble();
        System.out.print("Enter B: ");
        b = Checker.checkInputDouble();
        System.out.print("Enter C: ");
        c = Checker.checkInputDouble();
        ptb2 pt2 = new ptb2(a, b, c);
        System.out.println(pt2);
    }

    public static int menu() {
        System.out.print("========= Equation Program =========\n"
                + "1. Caculate Superlative Equation\n"
                + "2. Caculate Quadratic Equation\n"
                + "3. Exit\n"
                + "Please choose an option: ");

        int choice = Checker.checkInputIntLimit(1, 3);
        return choice;
    }
}
