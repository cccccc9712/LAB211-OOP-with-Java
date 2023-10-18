
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

    public static ArrayList<Fruit> list = new ArrayList<>();
    public static Hashtable<String, ArrayList<Fruit>> htb = new Hashtable<>();

    public static void menu() {
        System.out.println("========== Fruit Shop Manager ==========");
        System.out.println("1 - Create Fruit.\n"
                + "2 - View Orders.\n"
                + "3 - Shopping (for buyer).\n"
                + "4 - Exit.");
        System.out.print("Please choose an option: ");
    }

    public static ArrayList<Fruit> createFruit() {
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

    public static void display() {
        while (true) {
            createFruit();
            System.out.print("Do you want to add more fruits?(Y/N): ");
            if (!Checker.checkInputYN()) {
                break;
            }
        }

        print();
    }

    private static void print() {
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

    static void viewOrder() {
        for (String name : htb.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Fruit> lo = htb.get(name);
            displayListOrder(lo);
        }
    }

    static void shoppingStuff() {
        // Check if the list of fruits is empty
        if (list.isEmpty()) {
            System.err.println("No items available for purchase.");
            return;
        } else {
            // Create a list to store the customer's order
            ArrayList<Fruit> listOrder = new ArrayList<>();

            while (true) {
                print();
                System.out.print("Enter the item number you want to purchase: ");
                int item = Checker.checkInputIntLimit(1, list.size());
                Fruit selectedFruit = getFruitByIndex(list, item);

                if (selectedFruit.getQuantity() == 0) {
                    System.out.println("This item is out of stock.");
                } else {
                    System.out.print("Enter the quantity you want to purchase: ");
                    int quantity = Checker.checkInputIntLimit(1, selectedFruit.getQuantity());

                    // Update the selected fruit's quantity
                    selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);

                    // Check if the item already exists in the listOrder and update it
                    updateOrder(listOrder, selectedFruit.getId(), quantity);
                }

                System.out.print("Do you want to continue shopping? (Y/N): ");
                if (!Checker.checkInputYN()) {
                    break;
                }
            }

            displayListOrder(listOrder);

            // Ask for the customer's name and store the order
            System.out.print("Enter your name: ");
            String name = Checker.checkInputString();
            htb.put(name, listOrder);

            System.err.println("Order added successfully.");
        }
    }

    static Fruit getFruitByIndex(ArrayList<Fruit> lf, int item) {
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

    static void displayListOrder(ArrayList<Fruit> customerOrders) {
        System.out.println("========== Customer Orders ==========");

        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");

        double customerTotal = 0;

        for (Fruit order : customerOrders) {
            System.out.printf("%15s%15d%15.2f$%15.2f$\n", order.getName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            customerTotal += order.getPrice() * order.getQuantity();
        }

        System.out.println("Total for this customer: " + customerTotal);
    }

    static void updateOrder(ArrayList<Fruit> lo, String id, int quantity) {
        for (Fruit order : lo) {
            if (order.getId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }

        // If the order does not exist in the list, create a new one
        Fruit newOrder = getFruitById(list, id);
        newOrder.setQuantity(quantity);
        lo.add(newOrder);
    }

    static Fruit getFruitById(ArrayList<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return new Fruit(fruit.getId(), fruit.getName(), fruit.getPrice(), 0, fruit.getOrigin());
            }
        }
        return null;
    }
}
