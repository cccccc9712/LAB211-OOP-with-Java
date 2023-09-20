
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
         while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    String binary = Checker.checkInputBinary();
                    Manager.convertFromBinary(binary);
                    break;
                case 2:
                    String decimal = Checker.checkInputDecimal();
                    Manager.convertFromDecimal(decimal);
                    break;
                case 3:
                    String hexa = Checker.checkInputHexaDecimal();
                    Manager.convertFromHexa(hexa);
                    break;
                case 4:
                    return;
            }
        }
    }

}
