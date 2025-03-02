import java.util.Arrays;

public class arrayCopyRange{
    public static void main(String[] args) {
        int[] array1={1,2,3,4,5,6,7,8,9,0};
        int[] array2=Arrays.copyOfRange(array1, 1, 5);
        System.out.println("Original Array:");
        for (int i : array1) {
            System.out.print(i+" ");
        }
        System.out.println("\nCopied Array for some range: ");
        for (int i : array2) {
            System.out.print(i+" ");
        }
    }
}