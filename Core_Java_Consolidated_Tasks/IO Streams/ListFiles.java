import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File directory = new File("C:/Users/crbal/OneDrive/Desktop");
        String[] fileList = directory.list();
        if (fileList != null) {
            for (String file : fileList) {
                System.out.println(file);
            }
        }
    }
}