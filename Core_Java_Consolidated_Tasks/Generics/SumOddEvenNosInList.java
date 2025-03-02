import java.util.List;

public class SumOddEvenNosInList{
    public static <T extends Number > int[] sumEvenOdd(List<T> numbers) {
        int evenSum = 0;
        int oddSum = 0;
        
        for (T num : numbers) {
            if (num.intValue() % 2 == 0) {
                evenSum += num.intValue();
            } else {
                oddSum += num.intValue();
            }
        }
        
        return new int[]{evenSum, oddSum};
    }
    public static void main(String[] args) {
        List<Integer> numList=List.of(1,2,3,4,5,6,7,8,9,10);
        int[] sums = sumEvenOdd(numList);
        
        System.out.println("Sum of even numbers: " + sums[0]);
        System.out.println("Sum of odd numbers: " + sums[1]);

    }
}
