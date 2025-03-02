import java.util.ArrayList;
import java.util.Arrays;

public class RetrieveElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        System.out.println("Element at index 2: " + colors.get(2));
    }
}