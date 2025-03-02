import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStrings {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Balaji", "Ashwin", "Abinesh", "Dhanish", "Chukka");

        // Sorting in ascending order
        List<String> ascendingOrder = names.stream()
                                           .sorted()
                                           .collect(Collectors.toList());

        // Sorting in descending order
        List<String> descendingOrder = names.stream()
                                            .sorted((a, b) -> b.compareTo(a)) // Reverse order
                                            .collect(Collectors.toList());

        System.out.println("Original List: " + names);
        System.out.println("Ascending Order: " + ascendingOrder);
        System.out.println("Descending Order: " + descendingOrder);
    }
}
