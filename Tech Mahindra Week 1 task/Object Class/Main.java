public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alice", 25);
        User user2 = new User("Alice", 25);
        SecondUser secondUser1 = new SecondUser("Bob", 30);
        SecondUser secondUser2 = new SecondUser("Bob", 30);

        // Printing objects
        System.out.println("User Class toString(): " + user1);
        System.out.println("SecondUser Class (default toString()): " + secondUser1);

        // Comparing objects
        System.out.println("Comparing User objects with equals(): " + user1.equals(user2));
        System.out.println("Comparing SecondUser objects with == (no equals() override): " + (secondUser1 == secondUser2));
    }
}
