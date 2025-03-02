import java.util.LinkedList;
import java.util.ListIterator;

public class IterateFromPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        ListIterator<String> iterator = list.listIterator(2);
        System.out.println("Iterating from position 2:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}