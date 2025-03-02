import java.util.LinkedList;

public class IterateElementsLL {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        System.out.println("Iterating through elements:");
        for (String color : list) {
            System.out.println(color);
        }
    }
}