
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();
        System.out.println("Enter number of the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.print("Unsorted array: [");

        for (int i = 0; i < n; i++) {
            int value = generator.nextInt(8) + 1;
            arr[i] = value;
            if (i == n - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
        
        BubbleSort(arr);

        System.out.print("Sorted array: [");
        for(int i = 0; i < n; i ++){
            if (i == n - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
    }

    public static void BubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements  
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
}
