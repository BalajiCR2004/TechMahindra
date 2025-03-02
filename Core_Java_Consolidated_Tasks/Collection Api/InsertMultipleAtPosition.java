import java.util.LinkedList;

public class InsertMultipleAtPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");

        LinkedList<String> newElements = new LinkedList<>();
        newElements.add("Yellow");
        newElements.add("Black");

        list.addAll(2, newElements);
        System.out.println("After inserting multiple elements at position 2: " + list);
    }
}