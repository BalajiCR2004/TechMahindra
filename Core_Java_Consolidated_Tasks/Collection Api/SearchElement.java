import java.util.ArrayList;
import java.util.Arrays;

public class SearchElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        String searchColor = "Blue";
        if (colors.contains(searchColor)) {
            System.out.println(searchColor + " is found in the list.");
        } else {
            System.out.println(searchColor + " is not found in the list.");
        }
    }
}