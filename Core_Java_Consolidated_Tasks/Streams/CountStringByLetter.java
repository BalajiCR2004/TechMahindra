import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class CountStringByLetter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Balaji", "Ashwin", "Abinesh", "Dhanish", "Chukka");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting letter: ");
        char inputLetter = scanner.next().charAt(0);
        scanner.close();

        char startLetter = Character.toUpperCase(inputLetter);

        long count = names.stream().filter(name -> Character.toUpperCase(name.charAt(0)) == startLetter).count();

        // Print the result
        System.out.println("Number of names starting with " + startLetter + ": " + count);
    }

}
