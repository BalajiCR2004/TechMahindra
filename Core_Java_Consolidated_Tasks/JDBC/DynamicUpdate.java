import java.sql.*;
import java.util.Scanner;

public class DynamicUpdate {
    static final String DB_URL = "jdbc:mysql://localhost:3306/techmahindra";
    static final String USER = "root";
    static final String PASS = "12345";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter user ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();

            String sql = "UPDATE users SET name = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}