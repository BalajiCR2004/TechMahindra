import java.sql.*;
import java.util.Scanner;

public class DeleteRow {
    static final String DB_URL = "jdbc:mysql://localhost:3306/techmahindra";
    static final String USER = "root";
    static final String PASS = "12345";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter user ID to delete: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}