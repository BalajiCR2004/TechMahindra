import java.sql.*;
import java.util.Scanner;

public class MenuDrivenDB {
    static final String DB_URL = "jdbc:mysql://localhost:3306/techmahindra";
    static final String USER = "root";
    static final String PASS = "12345";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select a Row");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        insertRow(conn, scanner);
                        break;
                    case 2:
                        updateRow(conn, scanner);
                        break;
                    case 3:
                        deleteRow(conn, scanner);
                        break;
                    case 4:
                        selectRow(conn, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertRow(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.executeUpdate();
        System.out.println("Row inserted.");
    }

    private static void updateRow(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter user ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();

        String sql = "UPDATE users SET name = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newName);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        System.out.println("Row updated.");
    }

    private static void deleteRow(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter user ID to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        System.out.println("Row deleted.");
    }

    private static void selectRow(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter user ID to select: ");
        int id = scanner.nextInt();

        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
        }
    }
}