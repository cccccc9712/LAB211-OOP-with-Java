
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tmtmt
 */
public class Checker {
    
    private static final Scanner sc = new Scanner(System.in);
    
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
    
    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be an integer!");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkInputString() {
        while (true) {
            try {
                String result = sc.nextLine();
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be a string! ");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static boolean checkIdExist(ArrayList<Fruit> list, String targetId) {
        for (Fruit fr : list) {
            if (targetId.equalsIgnoreCase(fr.getId())) {
                return true; // ID exists, return true
            }
        }
        return false; // ID not found, return false
    }
    
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
    
    public static boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    public static boolean checkItemExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }
}
