class PrimeSumThread extends Thread {
    private int start, end;
    private long sum;

    public PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void run() {
        sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) sum += i;
        }
    }

    public long getSum() {
        return sum;
    }
}

public class PrimeSumThreads {
    public static void main(String[] args) throws InterruptedException {
        int limit = 100;
        PrimeSumThread thread1 = new PrimeSumThread(1, limit / 2);
        PrimeSumThread thread2 = new PrimeSumThread(limit / 2 + 1, limit);
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();

        long totalSum = thread1.getSum() + thread2.getSum();
        System.out.println("Sum of prime numbers up to " + limit + ": " + totalSum);
    }
}