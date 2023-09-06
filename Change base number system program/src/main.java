
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

        binaryAndDecimal binary = new binaryAndDecimal();
        binaryAndDecimal decimalResult = new binaryAndDecimal();

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
                    String b = binary.decimalToBinary(decimal);
                    System.out.println("Binary representation: " + b);
                    break;

                case 2:
                    int bnr;
                    System.out.println("Enter the binary number: ");
                    bnr = sc.nextInt();
                    int decResult = decimalResult.binaryToDecimal(bnr);
                    System.out.println("Decimal representation: " + decResult);
                    break;

                case 3:
                    System.out.println("Enter the decimal number: ");
                    decimal = sc.nextInt();
                    String hexadecimal = Integer.toHexString(decimal);
                    System.out.println("Hexadecimal representation: " + hexadecimal.toUpperCase());
                    break;

                case 4:
                    System.out.println("Enter the hexa number: ");
                    String hexa = sc.next();
                    int a = Integer.parseInt(hexa, 16);
                    System.out.println("Decimal representation: " + a);
                    break;
                case 5:
                    System.out.print("Enter a binary number: ");
                    String binaryInput = sc.next();
                    int decimalValue = Integer.parseInt(binaryInput, 2);
                    String hexadecimalValue = Integer.toHexString(decimalValue);
                    System.out.println("Hexadecimal representation: " + hexadecimalValue.toUpperCase());
                    break;

                case 6:
                    System.out.print("Enter a hexadecimal number: ");
                    String hexInput = sc.next();
                    int gg = Integer.parseInt(hexInput, 16);
                    String binaryValue = Integer.toBinaryString(gg);
                    System.out.println("Binary representation: " + binaryValue);
                    break;
            }
        } while (choice > 0 && choice < 5);
    }

}
