import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinAndMax {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(23, 45, 12, 67, 89, 5, 34, 99);

        // Finding the minimum value
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);

        // Finding the maximum value
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        System.out.println("List of numbers: " + numbers);
        System.out.println("Minimum Value: " + min.orElse(null));
        System.out.println("Maximum Value: " + max.orElse(null));
    }
}
