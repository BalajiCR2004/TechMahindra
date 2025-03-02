import java.io.File;
import java.util.Date;

public class LastModified {
    public static void main(String[] args) {
        File file = new File("C:/Users/crbal/OneDrive/Desktop/Visual Studio Code.lnk");
        System.out.println("Last Modified: " + new Date(file.lastModified()));
    }
}