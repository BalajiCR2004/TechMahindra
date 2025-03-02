public class TestStringProcessor {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();

        String sampleText = "hello world this is a test";
        String subText = "is";
        
        // Testing reverseString method
        System.out.println("Reversed String: " + processor.reverseString(sampleText));

        // Testing countOccurrences method
        System.out.println("Occurrences of '" + subText + "': " + processor.countOccurrences(sampleText, subText));

        // Testing splitAndCapitalize method
        System.out.println("Capitalized Words: " + processor.splitAndCapitalize(sampleText));
    }
}
