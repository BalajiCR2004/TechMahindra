import java.util.LinkedList;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");

        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
    }
}