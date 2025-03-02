import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ShuffleList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        Collections.shuffle(colors);
        System.out.println("Shuffled List: " + colors);
    }
}