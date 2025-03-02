import java.util.ArrayList;
import java.util.Arrays;

public class UpdateElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        colors.set(1, "Black");
        System.out.println("After updating second element: " + colors);
    }
}