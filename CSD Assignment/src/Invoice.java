import java.util.*;

public class Invoice {

    private static Scanner sc = new Scanner(System.in);

    String invoiceId;
    String customerId;
    Map<IceCream, Integer> iceCreamBill;
    private double total;
    private Customer customer; // Add a field to store the customer information
    private static int nextInvoiceId = 1;

    static IceCream ic1 = new IceCream("ic01", "Socola", "Cone", 2.50);
    static IceCream ic2 = new IceCream("ic02", "Socola", "Popsicle", 1.80);
    static IceCream ic3 = new IceCream("ic03", "Vanila", "Cone", 2.20);
    static IceCream ic4 = new IceCream("ic04", "Vanila", "Popsicle", 1.60);
    static IceCream ic5 = new IceCream("ic05", "Coconut", "Cone", 2.80);
    static IceCream ic6 = new IceCream("ic06", "Pineapple", "Cone", 2.30);

    public Invoice(String customerID, String customerName, String phoneNumber) {
        // Generate invoice ID with the format #0001, #0002, etc.
        this.invoiceId = String.format("#%04d", nextInvoiceId);
        nextInvoiceId++; // Increment for the next invoice
        this.customerId = customerID;
        this.iceCreamBill = new HashMap<>();
        this.customer = new Customer(customerId, customerName, phoneNumber);
        this.total = 0.0;
    }

    public void setIceCreamItem(Map<IceCream, Integer> iceCreamItem) {
        this.iceCreamBill = iceCreamItem;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public Map<IceCream, Integer> getIceCreamBill() {
        return iceCreamBill;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double countTotal() {
        total = 0;
        for (Map.Entry<IceCream, Integer> entry : iceCreamBill.entrySet()) {
            total += entry.getKey().price * entry.getValue();
        }
        return total;
    }

    public void printInvoice() {
        System.out.println("==========" + getInvoiceId() + "==========");
        System.out.println("Customer Id: " + getCustomer().getCustomerId());
        System.out.println("Customer Name: " + getCustomer().getCustomerName());
        System.out.println("Customer Phone Number: " + getCustomer().getPhoneNumber());
        System.out.println(getCustomer().getCustomerName() + "'s Bill list:");
        for (Map.Entry<IceCream, Integer> entry : getIceCreamBill().entrySet()) {
            IceCream iceCream = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(iceCream.getName() + " x " + quantity);
        }
        double total = countTotal();
        System.out.println("Total: $" + total + "\n");
    }


    public static String generateRandomCustomerId() {
        int length = 10;
        StringBuilder customerIdBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);

            customerIdBuilder.append(digit);
        }
        return customerIdBuilder.toString();
    }

    private static final Set<String> usedCustomerIds = new HashSet<>();

    public static String generateUniqueCustomerId() {
        String customerId;
        do {
            customerId = generateRandomCustomerId();
        } while (usedCustomerIds.contains(customerId));

        // Mark the generated customer ID as used
        usedCustomerIds.add(customerId);

        return customerId;
    }


    public static Invoice createBill(InvoiceManage invoiceManager) {
        String customerId = generateUniqueCustomerId();
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter Customer Phone Number: ");
        String phoneNumber = sc.nextLine();
        Invoice invoice = new Invoice(customerId, customerName, phoneNumber);
        invoiceManager.insert(invoice);
        System.out.println("Your Invoice ID: " + invoice.getInvoiceId());
        return invoice;
    }

    public static void printIceCream() {
        System.out.println("IceCream List: ");
        System.out.println("1. " + ic1.toString());
        System.out.println("2. " + ic2.toString());
        System.out.println("3. " + ic3.toString());
        System.out.println("4. " + ic4.toString());
        System.out.println("5. " + ic5.toString());
        System.out.println("6. " + ic6.toString());
    }

    public void addIceCreamItem(IceCream iceCream, int quantity) {
        iceCreamBill.put(iceCream, quantity);
    }

    public static void addItem(Invoice invoice) {
        while (true) {
            printIceCream();
            System.out.print("Please choose an item (1-6) or 0 to finish: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice >= 1 && choice <= 6) {
                IceCream selectedIceCream = null;
                int quantity;

                switch (choice) {
                    case 1:
                        selectedIceCream = ic1;
                        break;
                    case 2:
                        selectedIceCream = ic2;
                        break;
                    case 3:
                        selectedIceCream = ic3;
                        break;
                    case 4:
                        selectedIceCream = ic4;
                        break;
                    case 5:
                        selectedIceCream = ic5;
                        break;
                    case 6:
                        selectedIceCream = ic6;
                        break;
                }

                if (selectedIceCream != null) {
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    invoice.addIceCreamItem(selectedIceCream, quantity);
                }
            }
        }
    }

    public static void removeItem(Invoice invoice) {
        while (true) {
            System.out.println("Items in the invoice:");
            int itemIndex = 1;

            for (Map.Entry<IceCream, Integer> entry : invoice.getIceCreamBill().entrySet()) {
                IceCream iceCream = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(itemIndex + ". " + iceCream.getName() + " " + iceCream.getType() + " x " + quantity);
                itemIndex++;
            }

            System.out.print("Enter the item number to remove (1-" + (itemIndex - 1) + ") or 0 to finish: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }
            if (choice >= 1 && choice < itemIndex) {
                IceCream selectedIceCream = null;
                int selectedIndex = 1;

                for (Map.Entry<IceCream, Integer> entry : invoice.getIceCreamBill().entrySet()) {
                    if (selectedIndex == choice) {
                        selectedIceCream = entry.getKey();
                        break;
                    }
                    selectedIndex++;
                }

                if (selectedIceCream != null) {
                    invoice.removeItem(selectedIceCream);
                    System.out.println(selectedIceCream.getName() + " is removed from the invoice.");
                }
            } else {
                System.out.println("Invalid choice. Please select a valid item.");
            }
        }
    }

    public static void editItem(Invoice invoice) {
        while (true) {
            System.out.println("Items in the invoice:");
            int itemIndex = 1;

            for (Map.Entry<IceCream, Integer> entry : invoice.getIceCreamBill().entrySet()) {
                IceCream iceCream = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(itemIndex + ". " + iceCream.getName() + " " + iceCream.getType() + " x " + quantity);
                itemIndex++;
            }

            System.out.print("Enter the item number to edit (1-" + (itemIndex - 1) + ") or 0 to finish: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice >= 1 && choice < itemIndex) {
                IceCream selectedIceCream = null;
                int selectedIndex = 1;

                for (Map.Entry<IceCream, Integer> entry : invoice.getIceCreamBill().entrySet()) {
                    if (selectedIndex == choice) {
                        selectedIceCream = entry.getKey();
                        break;
                    }
                    selectedIndex++;
                }

                if (selectedIceCream != null) {
                    System.out.print("Enter the new quantity: ");
                    int newQuantity = sc.nextInt();
                    invoice.editIceCreamItem(selectedIceCream, newQuantity);
                    System.out.println(selectedIceCream.getName() + " quantity updated to " + newQuantity);
                }
            } else {
                System.out.println("Invalid choice. Please select a valid item.");
            }
        }
    }

    public void editIceCreamItem(IceCream iceCream, int newQuantity) {
        iceCreamBill.put(iceCream, newQuantity);
    }

    public void removeItem(IceCream iceCream) {
        iceCreamBill.remove(iceCream);
    }

}