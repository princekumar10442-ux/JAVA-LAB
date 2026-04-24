import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class RestaurantFXApp extends Application {

    static final String URL = "jdbc:mysql://localhost:3306/restaurant_db?useSSL=false&allowPublicKeyRetrieval=true";
    static final String USER = "root";
    static final String PASS = "Nusb@04082006";

    TableView<ObservableList<String>> table = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();

        Menu restaurantMenu = new Menu("Restaurant");
        MenuItem rInsert = new MenuItem("Insert");
        MenuItem rView = new MenuItem("View");

        Menu menuItemMenu = new Menu("MenuItem");
        MenuItem mInsert = new MenuItem("Insert");
        MenuItem mView = new MenuItem("View");
        MenuItem mUpdate = new MenuItem("Update");
        MenuItem mDelete = new MenuItem("Delete");

        restaurantMenu.getItems().addAll(rInsert, rView);
        menuItemMenu.getItems().addAll(mInsert, mView, mUpdate, mDelete);
        menuBar.getMenus().addAll(restaurantMenu, menuItemMenu);

        root.setTop(menuBar);
        root.setCenter(table);

        rInsert.setOnAction(e -> showRestaurantInsert());
        rView.setOnAction(e -> loadTable("SELECT * FROM Restaurant"));

        mInsert.setOnAction(e -> showMenuInsert());
        mView.setOnAction(e -> loadTable("SELECT * FROM MenuItem"));
        mUpdate.setOnAction(e -> showMenuUpdate());
        mDelete.setOnAction(e -> showMenuDelete());

        stage.setScene(new Scene(root, 700, 400));
        stage.setTitle("Restaurant Management");
        stage.show();
    }

    Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

    void loadTable(String query) {
        table.getColumns().clear();
        table.getItems().clear();

        try (Connection con = connect();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                final int colIndex = i;

                TableColumn<ObservableList<String>, String> col =
                        new TableColumn<>(md.getColumnName(i));

                col.setCellValueFactory(data ->
                        new javafx.beans.property.SimpleStringProperty(
                                data.getValue().get(colIndex - 1)));

                table.getColumns().add(col);
            }

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();

                for (int i = 1; i <= cols; i++) {
                    row.add(rs.getString(i));
                }

                table.getItems().add(row);
            }

        } catch (Exception ex) {
            showAlert("Error: " + ex.getMessage());
        }
    }

    // ---------- INSERT RESTAURANT ----------
    void showRestaurantInsert() {

        TextField id = new TextField();
        TextField name = new TextField();
        TextField addr = new TextField();

        Button btn = new Button("Insert");

        btn.setOnAction(e -> {
            try (Connection con = connect()) {

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO Restaurant VALUES (?, ?, ?)");

                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.setString(2, name.getText());
                ps.setString(3, addr.getText());

                ps.executeUpdate();

                showAlert("Restaurant Inserted!");
                loadTable("SELECT * FROM Restaurant");

            } catch (Exception ex) {
                showAlert("Error: " + ex.getMessage());
            }
        });

        showForm("Insert Restaurant",
                new Label("Id"), id,
                new Label("Name"), name,
                new Label("Address"), addr,
                btn);
    }

    // ---------- INSERT MENU ----------
    void showMenuInsert() {

        TextField id = new TextField();
        TextField name = new TextField();
        TextField price = new TextField();
        TextField resId = new TextField();

        Button btn = new Button("Insert");

        btn.setOnAction(e -> {
            try (Connection con = connect()) {

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO MenuItem VALUES (?, ?, ?, ?)");

                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.setString(2, name.getText());
                ps.setInt(3, Integer.parseInt(price.getText()));
                ps.setInt(4, Integer.parseInt(resId.getText()));

                ps.executeUpdate();

                showAlert("Menu Item Inserted!");
                loadTable("SELECT * FROM MenuItem");

            } catch (Exception ex) {
                showAlert("Error: " + ex.getMessage());
            }
        });

        showForm("Insert MenuItem",
                new Label("Id"), id,
                new Label("Name"), name,
                new Label("Price"), price,
                new Label("RestaurantId"), resId,
                btn);
    }

    // ---------- UPDATE ----------
    void showMenuUpdate() {

        TextField id = new TextField();
        TextField price = new TextField();

        Button btn = new Button("Update");

        btn.setOnAction(e -> {
            try (Connection con = connect()) {

                PreparedStatement ps = con.prepareStatement(
                        "UPDATE MenuItem SET Price=? WHERE Id=?");

                ps.setInt(1, Integer.parseInt(price.getText()));
                ps.setInt(2, Integer.parseInt(id.getText()));

                ps.executeUpdate();

                showAlert("Price Updated!");
                loadTable("SELECT * FROM MenuItem");

            } catch (Exception ex) {
                showAlert("Error: " + ex.getMessage());
            }
        });

        showForm("Update Price",
                new Label("Id"), id,
                new Label("New Price"), price,
                btn);
    }

    // ---------- DELETE ----------
    void showMenuDelete() {

        TextField id = new TextField();

        Button btn = new Button("Delete");

        btn.setOnAction(e -> {
            try (Connection con = connect()) {

                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM MenuItem WHERE Id=?");

                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.executeUpdate();

                showAlert("Deleted!");
                loadTable("SELECT * FROM MenuItem");

            } catch (Exception ex) {
                showAlert("Error: " + ex.getMessage());
            }
        });

        showForm("Delete MenuItem",
                new Label("Id"), id,
                btn);
    }

    // ---------- FORM ----------
    void showForm(String title, javafx.scene.Node... nodes) {

        VBox vbox = new VBox(10, nodes);
        vbox.setPadding(new Insets(15));

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(vbox, 300, 300));
        stage.show();
    }

    void showAlert(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).show();
    }
}