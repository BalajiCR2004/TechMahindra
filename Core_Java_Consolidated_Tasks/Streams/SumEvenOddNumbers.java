import java.util.Arrays;
import java.util.List;

public class SumEvenOddNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Calculate the sum of even numbers
        int sumEven = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue) .sum();

        // Calculate the sum of odd numbers
        int sumOdd = numbers.stream().filter(n -> n % 2 != 0) .mapToInt(Integer::intValue).sum(); 

        System.out.println("Sum of Even Numbers: " + sumEven);
        System.out.println("Sum of Odd Numbers: " + sumOdd);
    }
}
