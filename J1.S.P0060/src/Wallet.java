
class Wallet {
    private int amountInWallet;

    public Wallet() {
        this.amountInWallet = 0;//
    }
    
     public void setAmount(int initialAmount) {
        this.amountInWallet = initialAmount;
    }

    public int calcTotal(int[] bills) {
        int total = 0;
        for (int bill : bills) {
            total += bill;
        }
        return total;
    }

    public boolean canBuy(int total) {
        return amountInWallet >= total;
    }

    public void purchase(int total) {
        if (canBuy(total)) {
            amountInWallet -= total;
            System.out.println("You can buy it.");
            System.out.println("Remaining amount in wallet: " + amountInWallet);
        } else {
            System.out.println("You can`t buy it.");
        }
    }
}