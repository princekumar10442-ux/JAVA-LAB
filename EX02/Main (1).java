public class Main {
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Toyota", "Camry", 40000, 18, "T001", 85);
        Vehicle v2 = new Vehicle("Honda", "City", 15000, 20, "H002", 88);
        Vehicle v3 = new Vehicle(v1); // copy constructor

        Vehicle[] list = {v1, v2, v3};

        // Tabular heading
        System.out.println("Brand\tModel\tPrice\tMileage\tMfgCode\tEfficiency");

        // Printing table
        for (Vehicle v : list) {
            System.out.println(
                v.brand + "\t" +
                v.model + "\t" +
                v.getPrice() + "\t" +
                v.getMileage() + "\t" +
                v.getMfgCode() + "\t" +
                v.getEfficiency()
            );
        }
    }
}


