import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 1, 9, 10, 6);

        // Remove duplicates using streams
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList()); 

        System.out.println("Original List: " + numbers);
        System.out.println("List without Duplicates: " + uniqueNumbers);
    }
}
