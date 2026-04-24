import java.sql.*;

public class RestaurantApp {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            // -------- INSERT --------
            for (int i = 1; i <= 10; i++) {
                stmt.executeUpdate("INSERT INTO Restaurant VALUES (" + i +
                        ", 'Cafe " + i + "', 'Address " + i + "')");
            }

            stmt.executeUpdate("INSERT INTO MenuItem VALUES (1,'Pizza',80,1)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (2,'Burger',120,2)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (3,'Pasta',90,3)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (4,'Sandwich',60,1)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (5,'Coffee',50,1)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (6,'Tea',30,2)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (7,'Noodles',110,3)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (8,'Paratha',40,4)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (9,'Paneer',150,5)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (10,'PavBhaji',70,1)");

            System.out.println("\nData Inserted Successfully");

            // -------- SELECT price <= 100 --------
            System.out.println("\nItems with price <= 100:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM MenuItem WHERE Price <= 100");
            printTable(rs);

            // -------- SELECT from Cafe 1 --------
            System.out.println("\nItems in Cafe 1:");
            rs = stmt.executeQuery(
                    "SELECT m.* FROM MenuItem m JOIN Restaurant r " +
                    "ON m.ResId = r.Id WHERE r.Name='Cafe 1'");
            printTable(rs);

            // -------- UPDATE --------
            stmt.executeUpdate("UPDATE MenuItem SET Price=200 WHERE Price <=100");

            System.out.println("\nAfter Update:");
            rs = stmt.executeQuery("SELECT * FROM MenuItem");
            printTable(rs);

            // -------- DELETE --------
            stmt.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");

            System.out.println("\nAfter Delete:");
            rs = stmt.executeQuery("SELECT * FROM MenuItem");
            printTable(rs);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printTable(ResultSet rs) throws Exception {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        for (int i = 1; i <= columns; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}