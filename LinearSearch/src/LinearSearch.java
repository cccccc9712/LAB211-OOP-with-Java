public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        // Loop through the array and compare each element with the target
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the target is found
            }
        }
        return -1; // Return -1 if the target is not found in the array
    }

    public static void main(String[] args) {
        int[] myArray = {5, 2, 9, 1, 5, 6};
        int targetElement = 9;

        int result = linearSearch(myArray, targetElement);

        if (result != -1) {
            System.out.println("Element " + targetElement + " found at index " + result);
        } else {
            System.out.println("Element " + targetElement + " not found in the array");
        }
    }
}
