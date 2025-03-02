import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListIteration {
    public static void main(String[] args) {
        ArrayList<Integer> numList=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        //Using Traditional foreach loop 
        System.out.println("\nUsing Traditional foreach loop");
        for (Integer integer : numList) {
            System.out.print(integer+" ");
        }
        System.out.println("\nUsing Lambda functions");
        //Using lambda function
        numList.stream().forEach(num->System.out.print(num+" "));
    }
}
