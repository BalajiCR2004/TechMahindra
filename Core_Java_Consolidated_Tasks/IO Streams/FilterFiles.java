import java.io.File;
import java.io.FilenameFilter;

public class FilterFiles {
    public static void main(String[] args) {
        File dir = new File("C:/Users/crbal/OneDrive/Desktop");
        String[] files = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}