

// Abstract base class (Parent Class)
public abstract class Employee {

    // Abstract method (must be implemented by child classes)
    public abstract double calcCTC();

    // Common attributes for all employees
    protected String name;
    protected String panNo;
    protected String joiningDate;
    protected String designation;
    protected int empId;

    // Constructor to initialize employee details
    public Employee(String name, String panNo, String joiningDate, String designation, int empId) {
        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    // Method to display employee basic details
    public void displayDetails() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Role: " + designation);
    }
}