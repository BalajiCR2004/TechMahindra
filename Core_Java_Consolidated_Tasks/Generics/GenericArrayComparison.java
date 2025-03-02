import java.util.Arrays;

public class GenericArrayComparison{

    public static <T> boolean arraysEqualCheck(T[] array1 ,T[] array2){
        if(array1.length!=array2.length){
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if(!array1[i].equals(array2[i])){
                return false;
            }
        }
        return true;
    }
    public static <T> void printArrayEquals(T[] array1 ,T[] array2){
        boolean result=arraysEqualCheck(array1, array2);
        if(result==true){
            System.out.println((Arrays.toString(array1))+"\t"+(Arrays.toString(array2))+" both are equal");
        }
        else{
            System.out.println((Arrays.toString(array1))+"\t"+(Arrays.toString(array2))+" both are not equal");
        }
    }
    public static void main(String[] args) {
        Integer[] intArr1={1,2,3,4};
        Integer[] intArr2={1,2,3,4};
        String[] strArr1={"Balaji","Abinesh","Ashwin","Chukka"};
        String[] strArr2={"Balaji","Abinesh","Ashwin","Dhanish"};

        printArrayEquals(intArr1, intArr2);
        printArrayEquals(strArr1, strArr2);


    }
}
