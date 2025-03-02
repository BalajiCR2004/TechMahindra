import java.util.ArrayList;
import java.util.Arrays;

public class CopyList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        ArrayList<String> copiedList = new ArrayList<>(colors);
        System.out.println("Original List: "+colors);
        System.out.println("Copied List: " + copiedList);
    }
}