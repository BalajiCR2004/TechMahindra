import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}

class PositiveNumberCheck {
    public static void readNumbers(String filename) throws FileNotFoundException, PositiveNumberException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 0) {
                throw new PositiveNumberException("Positive number found: " + num);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            readNumbers("numbers.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: File not found!");
        } catch (PositiveNumberException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
