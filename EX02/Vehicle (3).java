class Vehicle{

    // Public data members
    public String brand;
    public String model;

    // Private data members
    private double price;
    private double mileage;
    private String mfgCode;
    private double efficiency;

    // Default constructor
    Vehicle() {
        brand = "Unknown";
        model = "Unknown";
        price = 0;
        mileage = 0;
        mfgCode = "NA";
        efficiency = 0;
    }

    // Parameterized constructor
    Vehicle(String b, String m, double p, double ml, String code, double eff) {
        brand = b;
        model = m;
        price = p;
        mileage = ml;
        mfgCode = code;
        efficiency = eff;
    }

    // Copy constructor
    Vehicle(Vehicle v) {
        brand = v.brand;
        model = v.model;
        price = v.price;
        mileage = v.mileage;
        mfgCode = v.mfgCode;
        efficiency = v.efficiency;
    }

    // Getters
    double getPrice() { return price; }
    double getMileage() { return mileage; }
    String getMfgCode() { return mfgCode; }
    double getEfficiency() { return efficiency; }

    // Setters
    void setPrice(double p) { price = p; }
    void setMileage(double ml) { mileage = ml; }
    void setMfgCode(String code) { mfgCode = code; }
    void setEfficiency(double eff) { efficiency = eff; }

    // Required methods
    void start() { System.out.println(brand + " started"); }
    void stop() { System.out.println(brand + " stopped"); }
    void drive() { System.out.println(brand + " is driving"); }

    void calcMileage(double distance, double fuel) {
        if (fuel != 0) mileage = distance / fuel;
    }

    void changeSpeed(int speed) {
        System.out.println(brand + " speed changed to " + speed);
    }
}


