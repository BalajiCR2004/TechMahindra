import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        Collections.sort(colors);
        System.out.println("Sorted List: " + colors);
    }
}