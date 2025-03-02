import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFoundHandling {
    public static void readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            readFile("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: File not found!");
        }
    }
}
