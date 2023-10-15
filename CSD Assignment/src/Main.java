import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        InvoiceManage invoiceManager = new InvoiceManage();
        Invoice invoice = null;
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    Invoice.createBill(invoiceManager);
                    break;
                case 2:
                    chooseInvoiceToAdd(invoiceManager);
                    break;
                case 3:
                    chooseInvoiceToRemove(invoiceManager);
                    break;
                case 4:
                    chooseInvoiceToEdit(invoiceManager);
                    break;
                case 5:
                    printInvoiceOption(invoiceManager);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void chooseInvoiceToAdd(InvoiceManage invoiceManager) {
        System.out.print("Enter the Invoice ID to add items to: ");
        String invoiceID = sc.next();
        Invoice foundInvoice = invoiceManager.search(invoiceID);

        if (foundInvoice != null) {
            System.out.println("Add items to the invoice:");
            Invoice.addItem(foundInvoice);
        } else {
            System.out.println("Invoice ID: " + invoiceID + " is not existed. Please create a new Invoice.");
        }
    }

    public static void chooseInvoiceToEdit(InvoiceManage invoiceManager) {
        System.out.print("Enter the Invoice ID to edit items: ");
        String invoiceID = sc.next();
        Invoice foundInvoice = invoiceManager.search(invoiceID);

        if (foundInvoice != null) {
            System.out.println("Add items to the invoice:");
            Invoice.editItem(foundInvoice);
        } else {
            System.out.println("Invoice ID: " + invoiceID + " is not existed. Please create a new Invoice.");
        }
    }

    public static void chooseInvoiceToRemove(InvoiceManage invoiceManager) {
        System.out.print("Enter the Invoice ID to remove items from: ");
        String invoiceID = sc.next();
        Invoice foundInvoice = invoiceManager.search(invoiceID);

        if (foundInvoice != null) {
            System.out.println("Remove items from the selected invoice:");
            Invoice.removeItem(foundInvoice);
        } else {
            System.out.println("Invoice ID: " + invoiceID + " is not existed. Please create a new Invoice.");
        }
    }


    public static void printInvoiceOption(InvoiceManage invoiceManager) {
        while (true) {
            System.out.println("1. Enter an invoice ID.");
            System.out.println("2. Print all invoices.");
            System.out.println("3. Back.");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the Invoice ID to print: ");
                    String invoiceID = sc.next();
                    Invoice foundInvoice = invoiceManager.search(invoiceID);
                    if (foundInvoice != null) {
                        foundInvoice.printInvoice();
                    } else {
                        System.out.println("Invoice ID: " + invoiceID + " is not existed");
                    }
                    break;
                case 2:
                    invoiceManager.printInOrder();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static int menu() {
        System.out.println("===== Mixue Sale Management =====");
        System.out.println("1. Create an invoice.");
        System.out.println("2. Add more items to invoice.");
        System.out.println("3. Remove items for your invoice.");
        System.out.println("4. Edit Item in your invoice.");
        System.out.println("5. Print your invoice. ");
        System.out.println("0. Exit");
        System.out.print("Please choose an option: ");
        int choice = sc.nextInt();
        return choice;
    }
}
