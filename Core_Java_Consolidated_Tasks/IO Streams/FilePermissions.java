import java.io.File;

public class FilePermissions {
    public static void main(String[] args) {
        File file = new File("C:/Users/crbal/OneDrive/Desktop/Test.txt");
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}