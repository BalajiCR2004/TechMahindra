import java.io.File;

public class FileType {
    public static void main(String[] args) {
        File file = new File("C:/Users/crbal/OneDrive/Desktop");
        if (file.isDirectory()) {
            System.out.println("It is a directory.");
        } else if (file.isFile()) {
            System.out.println("It is a file.");
        }
    }
}