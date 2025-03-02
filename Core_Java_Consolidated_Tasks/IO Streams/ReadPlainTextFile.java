import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadPlainTextFile {
    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("C:/Users/crbal/OneDrive/Desktop/Test.txt")));
        System.out.println(content);
    }
}