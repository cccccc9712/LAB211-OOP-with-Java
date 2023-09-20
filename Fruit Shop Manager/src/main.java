
import java.util.ArrayList;
import java.util.Hashtable;
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
        ArrayList<Fruit> list = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        while(true){
            Manager.menu();
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    Manager.display(list);
                    break;
                case 2:
                    Manager.viewOrder(ht);
                    break;
                case 3:
                    Manager.shoppingStuff(list, ht);
                    break;
                case 4:
            }
        }
    }
    
}
