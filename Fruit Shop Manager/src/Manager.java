
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tmtmt
 */
public class Manager {

    public static void menu() {
        System.out.println("========== Fruit Shop Manager ==========");
        System.out.println("1 - Create Fruit.\n"
                + "2 - View Orders.\n"
                + "3 - Shopping (for buyer).\n"
                + "4 - Exit.");
        System.out.print("Please choose an option: ");
    }

    public static ArrayList<Fruit> createFruit(ArrayList<Fruit> list) {
        System.out.println("Please input the fruit information!");
        String id;
        while (true) {
            System.out.print("Enter ID: ");
            id = Checker.checkInputString();
            if (Checker.checkIdExist(list, id)) {
                System.out.println("ID already exists. Please enter a different ID.");
            } else {
                break; // ID is valid and doesn't exist in the list, exit the loop
            }
        }
        System.out.print("Enter Name: ");
        String name = Checker.checkInputString();
        System.out.print("Enter Price: ");
        double price = Checker.checkInputDouble();
        System.out.print("Enter Quantity: ");
        int quantity = Checker.checkInputInt();
        System.out.print("Enter Origin: ");
        String origin = Checker.checkInputString();

        list.add(new Fruit(id, name, price, quantity, origin));
        return list;
    }

    public static void display(ArrayList<Fruit> list) {
    while (true) {
        createFruit(list);
        System.out.print("Do you want to add more fruits?(Y/N): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (input.equalsIgnoreCase("N")) {
            break;
        } else if (!input.equalsIgnoreCase("Y")) {
            System.out.println("Invalid input. Please enter 'Y' to continue or 'N' to stop.");
        }
    }

    // Print the list of fruits after they have been added
    print(list);
}


    private static void print(ArrayList<Fruit> list) {
        if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }

        // Print the header
        System.out.println("\nList of Fruit:");
        System.out.printf("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |\n");

        // Print each product
        for (int i = 0; i < list.size(); i++) {
            Fruit fruit = list.get(i);
            System.out.printf("| %10d | %14s | %12s | %10s |\n",
                    i + 1, fruit.getName(), fruit.getOrigin(), fruit.getPrice());
        }
        System.out.println("\n");
    }
    
    static void viewOrder(Hashtable<String, ArrayList<Order>> ht) {
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> lo = ht.get(name);
            displayListOrder(lo);
        }
    }

    static void shoppingStuff(ArrayList<Fruit> list, Hashtable<String, ArrayList<Order>> ht) {
        //check list empty user can't buy
        if (list.isEmpty()) {
            System.err.println("No have item.");
            return;
        }
        //loop until user don't want to buy continue
        ArrayList<Order> lo = new ArrayList<>();
        while (true) {
            print(list);
            System.out.print("Enter item: ");
            int item = Checker.checkInputIntLimit(1, list.size());
            Fruit fruit = getFruitByItem(list, item);
            System.out.print("Enter quantity: ");
            int quantity = Checker.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            //check item exist or not
            if (!Checker.checkItemExist(lo, fruit.getId())) {
                updateOrder(lo, fruit.getId(), quantity);
            } else {
                lo.add(new Order(fruit.getId(), fruit.getName(),
                        quantity, fruit.getPrice()));
            }

            if (!Checker.checkInputYN()) {
                break;
            }
        }
        displayListOrder(lo);
        System.out.print("Enter name: ");
        String name = Checker.checkInputString();
        ht.put(name, lo);
        System.err.println("Add successfull");
    }

    static Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    static void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    //if order exist then update order
    static void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
}
