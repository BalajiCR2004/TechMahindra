import java.io.File;
import java.io.FileNotFoundException;

public class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

class EmptyFileCheck {
    public static void checkFile(String filename) throws FileNotFoundException, EmptyFileException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found!");
        }
        if (file.length() == 0) {
            throw new EmptyFileException("File is empty!");
        }
        System.out.println("File is not empty.");
    }

    public static void main(String[] args) {
        try {
            checkFile("test.txt");
        } catch (FileNotFoundException | EmptyFileException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
