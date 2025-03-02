import java.io.File;

public class FileSize {
    public static void main(String[] args) {
        File file = new File("C:/Users/crbal/OneDrive/Desktop/Visual Studio Code.lnk");
        System.out.println("Size in bytes: " + file.length());
        System.out.println("Size in KB: " + file.length() / 1024);
        System.out.println("Size in MB: " + file.length() / (1024 * 1024));
    }
}