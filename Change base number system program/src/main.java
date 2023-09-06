
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author tmtmt
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("================================MENU================================");
            System.out.print("1 - Convert Decimal to Binary.\n"
                    + "2 - Convert Binary to Decimal.\n"
                    + "3 - Convert Decimal to Hexadecimal.\n"
                    + "4 - Convert Hexadecimal to Decimal.\n"
                    + "5 - Convert Binary to Hexadecimal.\n"
                    + "6 - Convert Hexadecimal to Binary.\n"
                    + "Other choice to end the program.\n"
                    + "Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int decimal;
                    System.out.println("Enter the decimal number: ");
                    decimal = sc.nextInt();
                    String binary = decimalToBinary(decimal);
                    System.out.println("Binary representation: " + binary);
                case 2:
                    int bnr;
                    System.out.println("Enter the binary number: ");
                    bnr = sc.nextInt();
                    int decimalResult = binaryToDecimal(bnr);
                    System.out.println("The decimal number is: " + decimalResult);
                case 3:
                case 4:
                case 5:
            }
        } while (choice > 0 && choice < 5);
    }

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }

        return binary.toString();
    }

    public static int binaryToDecimal(int binary) {
        String numberStr = Integer.toString(binary);
        int[] digits = new int[numberStr.length()];
        int result = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Integer.parseInt(Character.toString(numberStr.charAt(i)));
        }

        int n = numberStr.length() - 1;

        for (int i = 0; i < numberStr.length(); i++) {
            result += digits[i] * Math.pow(2, n);
            n--;
        }

        return result;
    }
    
    public static String decimalToHexa(int decimal) {

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }

        return binary.toString();
    }
}
