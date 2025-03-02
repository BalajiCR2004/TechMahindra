final class FinalClass {
    public final int FINAL_VARIABLE = 10;

    public final void finalMethod() {
        System.out.println("This is a final method.");
    }
}

public class FinalDemo {
    public static void main(String[] args) {
        FinalClass obj = new FinalClass();
        System.out.println("Final Variable: " + obj.FINAL_VARIABLE);
        obj.finalMethod();
    }
}
