public class Main {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        generateFibonacci(44);
    }

    public static void generateFibonacci(int n) {
        long[] fibonacci = new long[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        System.out.println("Fibonacci Sequence:");
        System.out.print(fibonacci[0] + ", " + fibonacci[1]);

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            System.out.print(", " + fibonacci[i]);
        }

        System.out.println();
    }

}