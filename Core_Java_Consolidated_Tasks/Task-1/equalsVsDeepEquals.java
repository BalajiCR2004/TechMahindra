import java.util.Arrays;

public class equalsVsDeepEquals {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        // Using equals() - compares reference, not content
        System.out.println("Using equals() on arrays:");
        System.out.println(arr1.equals(arr2));  // Output: false

        // Using deepEquals() - compares content deeply
        System.out.println("\nUsing deepEquals() on arrays:");
        System.out.println(Arrays.equals(arr1, arr2));  // Output: true
    }
}
