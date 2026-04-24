

// Main class to run the program
public class Payroll_M {

    public static void main(String[] args) {

        // Creating Full-Time Employee object
        FullTimeEmployee swe = new FullTimeEmployee(
                "Prince", "AB45444", "2023-01-10",
                "SWE", 101, 80000, 5000
        );

        // Creating Contract Employee object
        ContractEmployee contractor = new ContractEmployee(
                "Ash", "FDHBJ5678", "2023-05-15",
                "Consultant", 201, 160, 50
        );

        // Creating Manager object (Multilevel Inheritance)
        Manager manager = new Manager(
                "Dev", "MF4F9999", "2020-03-20",
                "Tech Lead", 301, 120000, 15000,
                8000, 4000
        );

        // Displaying Payroll Report
        System.out.println("Employee Payroll Report\n");

        swe.displayDetails();
        System.out.println("Total CTC (INR): " + swe.calcCTC());

        System.out.println();

        contractor.displayDetails();
        System.out.println("Total CTC (INR): " + contractor.calcCTC());

        System.out.println();

        manager.displayDetails();
        System.out.println("Total CTC (INR): " + manager.calcCTC());
    }
}
