import java.util.LinkedList;
import java.util.Iterator;

public class ReverseIteration {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        Iterator<String> iterator = list.descendingIterator();
        System.out.println("Iterating in reverse order:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}