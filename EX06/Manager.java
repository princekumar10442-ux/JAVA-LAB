

// Manager class (Multilevel Inheritance)
public class Manager extends FullTimeEmployee {

    private double travelAllowance;
    private double eduAllowance;

    // Constructor
    public Manager(String name, String panNo, String joiningDate,
                   String designation, int empId,
                   double baseSalary, double perfBonus,
                   double travelAllowance, double eduAllowance) {

        // Call parent constructor (FullTimeEmployee)
        super(name, panNo, joiningDate, designation, empId, baseSalary, perfBonus);

        this.travelAllowance = travelAllowance;
        this.eduAllowance = eduAllowance;
    }

    // Override CTC calculation
    @Override
    public double calcCTC() {
        // baseSalary + bonus + allowances
        return super.calcCTC() + travelAllowance + eduAllowance;
    }
}