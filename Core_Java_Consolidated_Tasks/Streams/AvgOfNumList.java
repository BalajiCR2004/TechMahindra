import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;


public class AvgOfNumList{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50,100,90);

        OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();

        if (average.isPresent()) {
            System.out.println("Average: " + average.getAsDouble());
        } else {
            System.out.println("List is empty, cannot calculate average.");
        }
    }
}