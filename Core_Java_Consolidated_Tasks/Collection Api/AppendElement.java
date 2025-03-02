import java.util.LinkedList;

public class AppendElement {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.addLast("Yellow"); //appending element at the last position
        System.out.println("Linked List after appending: " + list);
    }
}