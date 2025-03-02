import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class ReadFileBytes {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/crbal/OneDrive/Desktop/Visual Studio Code.lnk");
        byte[] bytes = Files.readAllBytes(file.toPath());
        System.out.println(Arrays.toString(bytes));
    }
}