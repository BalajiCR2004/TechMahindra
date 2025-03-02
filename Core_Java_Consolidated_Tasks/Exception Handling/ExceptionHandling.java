public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            System.out.println(10 / 0); // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
