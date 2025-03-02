import java.io.File;

public class FileExists {
    public static void main(String[] args) {
        File file = new File("C:/Users/crbal/OneDrive/Desktop/Visual Studio Code.lnk");
        System.out.println("Exists: " + file.exists());
    }
}