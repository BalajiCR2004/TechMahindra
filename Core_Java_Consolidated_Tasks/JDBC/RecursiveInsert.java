import java.sql.*;
import java.util.Scanner;

public class RecursiveInsert {
    static final String DB_URL = "jdbc:mysql://localhost:3306/techmahindra";
    static final String USER = "root";
    static final String PASS = "12345";

    public static void insertRows(Connection conn, PreparedStatement pstmt, int count, Scanner scanner) throws SQLException {
        if (count == 0) return;

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.executeUpdate();

        insertRows(conn, pstmt, count - 1, scanner);
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Scanner scanner = new Scanner(System.in)) {

            String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            System.out.print("Enter number of rows to insert: ");
            int count = scanner.nextInt();
            scanner.nextLine(); 

            insertRows(conn, pstmt, count, scanner);
            System.out.println("Insertion completed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}