public class TrailingZeroes {
    public static int countTrailingZeroes(int num) {
        int count = 0;
        for (int i = 5; num / i >= 1; i *= 5) {
            count += num / i;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 100;
        System.out.println("Trailing Zeroes in " + num + "! : " + countTrailingZeroes(num));
    }
}
