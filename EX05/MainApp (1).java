import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();

        // Create Customers
        Customer c1 = new Customer(101, "Alice Johnson");
        Customer c2 = new Customer(102, "Bob Smith");
        Customer c3 = new Customer(103, "Carol White");
        Customer c4 = new Customer(104, "David Brown");

        // Add Accounts
        c1.addAccount(new SavingsAccount(1001, 10000, 4.5));
        c2.addAccount(new LoanAccount(1002, 50000));
        c3.addAccount(new SavingsAccount(1003, 25000, 4.0));
        c4.addAccount(new LoanAccount(1004, 30000));

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);

        // ================= TRANSACTIONS =================
        System.out.println("=== TRANSACTION DEMO ===\n");

        // Savings transactions
        c1.accounts.get(0).deposit(5000);
        c1.accounts.get(0).withdraw(200);
        c1.accounts.get(0).withdraw(20000); // will fail

        // Loan transactions
        c2.accounts.get(0).deposit(10000);
        c2.accounts.get(0).withdraw(5000);

        // ================= DISPLAY =================
        System.out.println("\n=== CONSOLIDATED CUSTOMER ACCOUNT INFO ===");
        System.out.println("---------------------------------------------------------------------");

        System.out.printf("%-10s %-18s %-15s %-15s %-10s\n",
                "Cust ID", "Customer Name", "Account Type", "Account No.", "Balance");

        System.out.println("---------------------------------------------------------------------");

        for (Customer c : customers) {
            for (Account a : c.accounts) {
                System.out.printf("%-10d %-18s %-15s %-15d %.2f\n",
                        c.id, c.name, a.type, a.accNo, a.balance);
            }
        }

        System.out.println("---------------------------------------------------------------------");
    }
}