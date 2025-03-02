import java.util.ArrayList;
import java.util.Arrays;

public class alternateElementsArray {
    public static void main(String[] args) {
        ArrayList<Integer> numList=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        ArrayList<Integer> alternateNumList=new ArrayList<>();
        for (int index = 1; index <numList.size(); index+=2) {
            alternateNumList.add(numList.get(index));
        }
        
        System.out.println(alternateNumList);
    }
}
