import java.util.LinkedList;

public class InsertFirstLast {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.addFirst("Orange");
        list.addLast("Yellow");
        System.out.println("After inserting at first and last positions: " + list);
    }
}