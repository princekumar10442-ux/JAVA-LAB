

// Another child class of Employee
public class ContractEmployee extends Employee {

    private int noOfHours;
    private double hourlyRate;

    // Constructor
    public ContractEmployee(String name, String panNo, String joiningDate,
                            String designation, int empId,
                            int noOfHours, double hourlyRate) {

        super(name, panNo, joiningDate, designation, empId);

        this.noOfHours = noOfHours;
        this.hourlyRate = hourlyRate;
    }

    // CTC calculation for contract employee
    @Override
    public double calcCTC() {
        return noOfHours * hourlyRate;
    }
}