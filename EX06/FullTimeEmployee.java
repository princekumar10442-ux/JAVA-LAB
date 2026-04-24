

// Child class of Employee (Hierarchical Inheritance)
public class FullTimeEmployee extends Employee {

    protected double baseSalary;
    protected double extraBenefit; // Bonus or commission

    // Constructor
    public FullTimeEmployee(String name, String panNo, String joiningDate,
                            String designation, int empId,
                            double baseSalary, double extraBenefit) {

        // Call parent constructor
        super(name, panNo, joiningDate, designation, empId);

        this.baseSalary = baseSalary;
        this.extraBenefit = extraBenefit;
    }

    // Method to calculate CTC (Cost to Company)
    @Override
    public double calcCTC() {
        return baseSalary + extraBenefit;
    }
}
