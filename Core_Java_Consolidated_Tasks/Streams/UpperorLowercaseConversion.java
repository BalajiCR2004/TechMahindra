import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperorLowercaseConversion {
    public static void main(String[] args) {
        // List of strings
        List<String> words = Arrays.asList("balaji", "abinesh", "ashwin", "dhanish","chukka");

        // Convert to uppercase
        List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());

        // Convert to lowercase
        List<String> lowerCaseWords = words.stream()
                                           .map(String::toLowerCase)
                                           .collect(Collectors.toList());

        System.out.println("Original List: " + words);
        System.out.println("Uppercase List: " + upperCaseWords);
        System.out.println("Lowercase List: " + lowerCaseWords);
    }
}
