
import java.util.Scanner;

class Person {
    private Wallet wallet;

    public Person() {
    }

    public void runProgram() {
        Scanner scanner = new Scanner(System.in);
        wallet = new Wallet();

        System.out.println("========== Shopping program ==========");
        System.out.print("Input number of bills: ");
        int numBills = scanner.nextInt();
        int[] bills = new int[numBills];

        for (int i = 0; i < numBills; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = scanner.nextInt();
        }
        int total = wallet.calcTotal(bills);
        
        System.out.print("Input value of wallet: ");
        int walletAmount = scanner.nextInt();
        wallet.setAmount(walletAmount);


        
        System.out.println("This is total of bill: " + total);
         
        
        wallet.purchase(total);

        scanner.close();
    }
}