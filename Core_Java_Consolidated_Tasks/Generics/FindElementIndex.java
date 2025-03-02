import java.util.List;

public class FindElementIndex {
    // Generic method to find the index of the first occurrence of an element
    public static <T> int findFirstIndex(List<T> list, T target) {
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        List<String> words = List.of("Balaji","Abinesh","Ashwin","Chukka");
        System.out.println("Index of Balaji: " + findFirstIndex(words, "Balaji")); 
        System.out.println("Index of Ashwin: " + findFirstIndex(words, "Ashwin"));   
    }
}