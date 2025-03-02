import java.util.ArrayList;
import java.util.Arrays;

public class InsertElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        colors.add(0, "Orange");
        System.out.println("After inserting at first position: " + colors);
    }
}