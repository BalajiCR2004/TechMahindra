public class DivisionWithoutOperators {
    public static void main(String[] args) {
        int dividend = 20, divisor = 3;
        int quotient = 0, remainder = dividend;

        while (remainder >= divisor) {
            remainder -= divisor;
            quotient++;
        }

        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}
