import java.sql.*;

public class MenuItemDAO {

    // INSERT
    public void insertMenuItems(Connection con) {
        try {
            String sql = "INSERT INTO MenuItem(Name, Price, ResId) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            for (int i = 1; i <= 10; i++) {
                ps.setString(1, "Product" + i);
                ps.setInt(2, i * 50);
                ps.setInt(3, 1);
                ps.executeUpdate();
            }

            System.out.println("✔ 10 Menu Items Inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT PRICE <=100
    public void selectPriceLessThan100(Connection con) {
        try {
            String sql = "SELECT * FROM MenuItem WHERE Price <= 100";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- Price <= 100 ---");
            printTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT FROM CAFE JAVA
    public void selectFromCafeJava(Connection con) {
        try {
            String sql = "SELECT m.* FROM MenuItem m " +
                         "JOIN Restaurant r ON m.ResId = r.Id " +
                         "WHERE r.Name='Cafe Java'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- Items from Cafe Java ---");
            printTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updatePrices(Connection con) {
        try {
            String sql = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
            Statement st = con.createStatement();

            int rows = st.executeUpdate(sql);
            System.out.println("\n✔ " + rows + " rows updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteItems(Connection con) {
        try {
            String sql = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
            Statement st = con.createStatement();

            int rows = st.executeUpdate(sql);
            System.out.println("\n✔ " + rows + " rows deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    public void selectAll(Connection con) {
        try {
            String sql = "SELECT * FROM MenuItem";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- All Menu Items ---");
            printTable(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // PRINT TABLE
    private void printTable(ResultSet rs) throws Exception {
        ResultSetMetaData md = rs.getMetaData();
        int cols = md.getColumnCount();

        for (int i = 1; i <= cols; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}