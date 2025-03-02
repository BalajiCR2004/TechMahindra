import java.util.Arrays;

class SortThread extends Thread {
    private int[] array;

    public SortThread(int[] array) {
        this.array = array;
    }

    public void run() {
        Arrays.sort(array);
    }

    public int[] getSortedArray() {
        return array;
    }
}

public class SortArrayThreads {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {5, 3, 8, 1, 2, 7};
        SortThread sortThread = new SortThread(arr);
        sortThread.start();
        sortThread.join();
        System.out.println("Sorted Array: " + Arrays.toString(sortThread.getSortedArray()));
    }
}