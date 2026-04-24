import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    private static final String USER = "root";
    private static final String PASS = "idk@.890";
    public static Connection getConnection() {
        try {
            System.out.println("Trying to connect...");

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            System.out.println("✅ Connected successfully!");
            return con;

        } catch (Exception e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
        return null;
    }
}