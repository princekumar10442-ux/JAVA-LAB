import java.sql.Connection;
import java.sql.PreparedStatement;

public class RestaurantDAO {

    public void insertRestaurants(Connection con) {
        try {
            String sql = "INSERT INTO Restaurant(Name, Address) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            for (int i = 1; i <= 10; i++) {
                ps.setString(1, "Cafe Java");
                ps.setString(2, "Address " + i);
                ps.executeUpdate();
            }

            System.out.println("✔ 10 Restaurants Inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}